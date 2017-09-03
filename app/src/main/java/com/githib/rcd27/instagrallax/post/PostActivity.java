package com.githib.rcd27.instagrallax.post;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.githib.rcd27.instagrallax.R;

public class PostActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

//        recyclerView = (RecyclerView) findViewById(R.id.activity_post_recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new PostRecyclerViewAdapter());

        int currentPostID = getIntent().getExtras().getInt("POST_ID");
        setTitle("id#" + currentPostID);
    }
}
