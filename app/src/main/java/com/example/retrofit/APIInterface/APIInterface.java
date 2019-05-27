package com.example.retrofit.APIInterface;


import com.example.retrofit.RetroPosts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/posts")
    Call<List<RetroPosts>> getAllPosts();

}
