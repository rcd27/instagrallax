package com.githib.rcd27.instagrallax.post;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.githib.rcd27.instagrallax.R;
import com.githib.rcd27.instagrallax.data.PostRepository;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PostActivity extends AppCompatActivity {

    @SuppressWarnings("FieldCanBeLocal")
    private ListView listView;
    private ImageView imageView;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        listView = (ListView) findViewById(R.id.activity_post_list_view);
        imageView = (ImageView) findViewById(R.id.activity_post_image_view);

        // see: http://www.androiddesignpatterns.com/2015/03/activity-postponed-shared-element-transitions-part3b.html
        postponeEnterTransition(); // temporarily prevent shared element transition.
        Picasso.with(this)
                .load(getIntent().getExtras().getString("IMAGE_URL"))
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        startPostponedEnterTransition(); // resume shared element transition
                    }

                    @Override
                    public void onError() {
                        startPostponedEnterTransition();
                    }
                });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, PostRepository.getInstance().getComments());
        listView.setAdapter(adapter);

        int currentPostID = getIntent().getExtras().getInt("POST_ID");
        setTitle("id#" + currentPostID);
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
        super.onBackPressed();
    }
}
