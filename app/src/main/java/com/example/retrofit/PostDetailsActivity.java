package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class PostDetailsActivity extends AppCompatActivity {

    TextView body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

//        body = (TextView) findViewById(R.id.body);
//        body.setText(getIntent().getStringExtra("body"));
    }
}
