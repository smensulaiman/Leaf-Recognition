package com.example.leafrecognition.networking;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;
import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall {

    public static void fileUpload(String filePath, ImageSenderInfo imageSenderInfo,String baseUrl) {

        ApiInterface apiInterface = RetrofitApiClient.getClient(baseUrl).create(ApiInterface.class);
        Logger.addLogAdapter(new AndroidLogAdapter());

        File file = new File(filePath);
        //create RequestBody instance from file
        RequestBody requestFile = RequestBody.create(MediaType.parse("image"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        Gson gson = new Gson();
        String patientData = gson.toJson(imageSenderInfo);

        RequestBody description = RequestBody.create(MultipartBody.FORM, patientData);

        // finally, execute the request
        Call<ResponseModel> call = apiInterface.fileUpload(description, body);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<ResponseModel> call, @NonNull Response<ResponseModel> response) {
                Logger.d("Response: " + response);

                ResponseModel responseModel = response.body();

                if(responseModel != null){
                    EventBus.getDefault().post(new EventModel("response", responseModel.getMessage()));
                    Logger.d("Response code " + response.code() +
                            " Response Message: " + responseModel.getMessage());
                } else
                    EventBus.getDefault().post(new EventModel("response", "ResponseModel is NULL"));
            }

            @Override
            public void onFailure(@NonNull Call<ResponseModel> call, @NonNull Throwable t) {
                Logger.d("Exception: " + t);
                EventBus.getDefault().post(new EventModel("response", t.getMessage()));
            }
        });
    }

    public static void fileUploadBase(String filePath,String baseUrl) {

        ApiInterface apiInterface = RetrofitApiClient.getClient(baseUrl).create(ApiInterface.class);
        Logger.addLogAdapter(new AndroidLogAdapter());

        File imgFile = new File(filePath);
        String base64Image="";
        try {
            if (imgFile.exists() && imgFile.length() > 0) {
                Bitmap bm = BitmapFactory.decodeFile(filePath);
                ByteArrayOutputStream bOut = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.JPEG, 100, bOut);
                base64Image = Base64.encodeToString(bOut.toByteArray(), Base64.DEFAULT);
               // Log.d("click",base64Image);
            }else{
                //Log.d("click",filePath);
                //Log.d("click",base64Image);
            }
        }
        catch (Exception e){
            Log.d("click",e.getMessage());
        }


        // finally, execute the request
        Call<ResponseModel2> call = apiInterface.fileUpload2(new RequestModel2(base64Image));
        call.enqueue(new Callback<ResponseModel2>() {
            @Override
            public void onResponse(@NonNull Call<ResponseModel2> call, @NonNull Response<ResponseModel2> response) {
                Logger.d("Response: " + response);

                ResponseModel2 responseModel = response.body();

                if(responseModel != null){
                    EventBus.getDefault().post(new EventModel("response", responseModel.getPrediction().getData()));
                    Logger.d("Response code " + response.code() +
                            " Response Message: " + responseModel.getPrediction().getData());
                } else
                    EventBus.getDefault().post(new EventModel("response", "ResponseModel is NULL"));
            }

            @Override
            public void onFailure(@NonNull Call<ResponseModel2> call, @NonNull Throwable t) {
                Logger.d("Exception: " + t);
                EventBus.getDefault().post(new EventModel("response", t.getMessage()));
            }
        });
    }

}
