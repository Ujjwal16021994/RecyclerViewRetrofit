package com.example.retrofitrecyclerview;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("photos")
    Call<ArrayList<SampleData>> getData();
}
