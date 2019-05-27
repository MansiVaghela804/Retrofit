package com.example.retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.retrofit.APIInterface.APIInterface;
import com.example.retrofit.APIManager.APIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CustomAdapter.ItemClickListener {


    List<RetroPosts> postsList;
    public CustomAdapter adapter;
    public RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.setCancelable(true);
        progressDoalog.show();
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<RetroPosts>> listCall = apiInterface.getAllPosts();
        listCall.enqueue(new Callback<List<RetroPosts>>() {
            @Override
            public void onResponse(Call<List<RetroPosts>> call, Response<List<RetroPosts>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPosts>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
     }

    private void generateDataList(List<RetroPosts> photoList) {
        recyclerView = findViewById(R.id.recycler);
        adapter = new CustomAdapter(photoList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        final RetroPosts retroPosts = postsList.get(position);
        Intent intent = new Intent(this,PostDetailsActivity.class);
        intent.putExtra("body",postsList.get(position).getBody());
        startActivity(intent);
        Toast.makeText(this,"Item Clicked", Toast.LENGTH_SHORT).show();
    }
}
