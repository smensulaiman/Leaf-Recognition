package com.example.leafrecognition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class DatasetActivity extends AppCompatActivity {

    ArrayList<Dataset> datasets;
    RecyclerView rec_dataset;
    DatasetRecyclerAdapter datasetRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataset);
        datasets=new ArrayList<>();
        rec_dataset=(RecyclerView)findViewById(R.id.rec_dataset);
        datasetRecyclerAdapter=new DatasetRecyclerAdapter(this,datasets);
        rec_dataset.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        rec_dataset.setAdapter(datasetRecyclerAdapter);

        datasets.add(new Dataset("Strawberry","Fragaria Ananassa","strawberry",R.drawable.strawberry));
        datasets.add(new Dataset("Blueberry","Cyanococcus","blueberry",R.drawable.blueberry));
        datasets.add(new Dataset("Potato","Solanum tuberosum","potato",R.drawable.potato));
        datasets.add(new Dataset("Tomato","Solanum lycopersicum","tomato",R.drawable.tomato));
        datasets.add(new Dataset("Data Shakh","Amaranthus Viridis","data shakh",R.drawable.datasakh));
        datasets.add(new Dataset("Neem","Azadirachta Indica","neem",R.drawable.neem));
        datasets.add(new Dataset("Jasmine","Jasmine","jasmine",R.drawable.jasmine));
        datasets.add(new Dataset("Mint","Mentha","mint",R.drawable.mint));
        datasets.add(new Dataset("Paan","Piper betle","paan",R.drawable.paan));
        datasets.add(new Dataset("Joba","Hibiscus rosa-sinensis","joba",R.drawable.joba));
        datasets.add(new Dataset("Dumur","Ficus hispida","dumur",R.drawable.dumur));
        datasetRecyclerAdapter.notifyDataSetChanged();


    }
}