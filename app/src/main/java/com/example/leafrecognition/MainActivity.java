package com.example.leafrecognition;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leafrecognition.networking.EventModel;
import com.example.leafrecognition.networking.ImageSenderInfo;
import com.example.leafrecognition.networking.NetworkCall;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PathInterface {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView preview;
    private ImageView cameraopen;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private ArrayList<Pata> pataList;
    private RecyclerView rec_preview;
    private PataAdapter pataAdapter;
    String filePath;
    SharedPref sharedPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref=new SharedPref(this);
        preview = (ImageView) findViewById(R.id.preview);
        cameraopen = (ImageView) findViewById(R.id.cameraopen);
        rec_preview = (RecyclerView) findViewById(R.id.rec_preview);

        pataList = new ArrayList<>();
        pataAdapter = new PataAdapter(this, this, pataList);
        rec_preview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rec_preview.setAdapter(pataAdapter);
        allImage();
        cameraopen.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Logger.d("click: " + "click");
                    Log.d("click","click");
                    //NetworkCall.fileUpload(filePath, new ImageSenderInfo("obj", 22), sharedPref.getBaseUrl());
                    NetworkCall.fileUploadBase(filePath, sharedPref.getBaseUrl());
                } catch (Exception e) {
                    Log.d("click",e.getMessage());
                    Logger.d("click: " + "error");
                }
            }
        });
    }

    public void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Uri tempUri = getImageUri(this.getApplicationContext(), imageBitmap);
            filePath = getPath(tempUri);
            Picasso.get().load(new File(filePath)).into(preview);
        }

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "" + System.currentTimeMillis(), null);
        return Uri.parse(path);
    }

    private String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    void allImage() {
        String[] columns = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA, MediaStore.Images.Media.DATE_TAKEN};
        String[] whereArgs = {"image/jpeg", "image/png", "image/jpg"};

        String orderBy = MediaStore.Images.Media.DATE_TAKEN + " DESC";
        String where = MediaStore.Images.Media.MIME_TYPE + "=? or "
                + MediaStore.Images.Media.MIME_TYPE + "=? or "
                + MediaStore.Images.Media.MIME_TYPE + "=?";
        pataList.clear();
        try (Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, where, whereArgs, orderBy)) {
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                // this means error, or simply no results found
                return;
            }
            do {
                String s = cursor.getString(1);
                pataList.add(new Pata(s));
                Log.d("path", s);

            } while (cursor.moveToNext());

        }
        try {
            Picasso.get().load(new File(pataList.get(0).getPath())).into(preview);
        } catch (Exception e) {
        }
        pataAdapter.notifyDataSetChanged();


    }

    @Override
    public void passPath(String path) {
        Picasso.get().load(new File(path)).into(preview);
        filePath = path;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventModel event) throws ClassNotFoundException {
        if (event.isTagMatchWith("response")) {
            String responseMessage = "Response from Server:\n" + event.getMessage();
            //responseTextView.setText(responseMessage);
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            if (event.getMessage().equalsIgnoreCase("Blueberry")) {
                intent.putExtra("leaf", "blueberry");
                startActivity(intent);
            } else if (event.getMessage().equalsIgnoreCase("Strawberry")) {
                intent.putExtra("leaf", "strawberry");
                startActivity(intent);
            } else if (event.getMessage().equalsIgnoreCase("Tomato")) {
                intent.putExtra("leaf", "tomato");
                startActivity(intent);
            } else if (event.getMessage().equalsIgnoreCase("Potato")) {
                intent.putExtra("leaf", "potato");
                startActivity(intent);
            } else if (event.getMessage().equalsIgnoreCase("Data Shakh")) {
                intent.putExtra("leaf", "data shakh");
                startActivity(intent);
            } else if (event.getMessage().equalsIgnoreCase("Jasmine")) {
                intent.putExtra("leaf", "jasmine");
                startActivity(intent);
            }else if (event.getMessage().equalsIgnoreCase("Mint")) {
                intent.putExtra("leaf", "mint");
                startActivity(intent);
            }else if (event.getMessage().equalsIgnoreCase("Neem")) {
                intent.putExtra("leaf", "neem");
                startActivity(intent);
            }else if (event.getMessage().equalsIgnoreCase("Dumur")) {
                intent.putExtra("leaf", "dumur");
                startActivity(intent);
            }else if (event.getMessage().equalsIgnoreCase("Joba")) {
                intent.putExtra("leaf", "joba");
                startActivity(intent);
            }else if (event.getMessage().equalsIgnoreCase("Paan")) {
                intent.putExtra("leaf", "paan");
                startActivity(intent);
            }else if (event.getMessage().equalsIgnoreCase("Mango")) {
                intent.putExtra("leaf", "mango");
                startActivity(intent);
            }else if (event.getMessage().equalsIgnoreCase("Guava")) {
                intent.putExtra("leaf", "guava");
                startActivity(intent);
            }else if (event.getMessage().equalsIgnoreCase("Lemon")) {
                intent.putExtra("leaf", "lemon");
                startActivity(intent);
            }else if (event.getMessage().equalsIgnoreCase("Other")) {
                new AlertDialog.Builder(this)
                        .setTitle("Sorry!")
                        .setMessage("No leaf found.")
                        .setPositiveButton(android.R.string.ok, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .create()
                        .show();
            } else {
                Toast.makeText(this, responseMessage, Toast.LENGTH_SHORT).show();
            }

        }
    }
}