package com.example.retrofitrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView variableRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://jsonplaceholder.typicode.com/todos/1/";
//                  https://jsonplaceholder.typicode.com/todos/1/photos

        variableRecyclerView = findViewById(R.id.recyclerviewid);

        variableRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofitobject = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitdata = retrofitobject.create(RetrofitInterface.class);

        Call<ArrayList<SampleData>> call = retrofitdata.getData();
        Log.e("tag","~~~~~~~api calling~~~~~~~~"+call.request().url());


        call.enqueue(new Callback<ArrayList<SampleData>>() {
            @Override
            public void onResponse(@NotNull Call<ArrayList<SampleData>> call, @NotNull Response<ArrayList<SampleData>> response) {

                Log.e("tag","~~~~~~~~on pass~~~~~~"+response.body());
                Toast.makeText(MainActivity.this,"on success!",Toast.LENGTH_LONG).show();

                RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this,response.body());
                variableRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<SampleData>> call, @NonNull Throwable t) {
                Log.e("tag","~~~~~~~~~on failure~~~~~~~~"+t.getMessage());
                Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_LONG).show();

            }
        });
    }
    }