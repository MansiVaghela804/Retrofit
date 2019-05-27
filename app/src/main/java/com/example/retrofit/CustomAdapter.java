package com.example.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    List<RetroPosts> postsList;
    Context context;

    public CustomAdapter(List<RetroPosts> postsList, Context context) {
        this.postsList = postsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle.setText(postsList.get(position).getTitle());
        holder.txtBody.setText(postsList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView userId,id,txtTitle,txtBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = (TextView)itemView.findViewById(R.id.title);
            txtBody = (TextView)itemView.findViewById(R.id.body);
        }
    }
}
