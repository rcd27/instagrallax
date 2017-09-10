package com.githib.rcd27.instagrallax.post;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.githib.rcd27.instagrallax.MagnettoApp;
import com.githib.rcd27.instagrallax.R;
import com.githib.rcd27.instagrallax.dagger.PostModule;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PostActivity extends AppCompatActivity implements PostContract.View {

    public static final String POST_ID = "POST_ID";
    public static final String IMAGE_URL = "UMAGE_URL";

    @SuppressWarnings("FieldCanBeLocal")
    private ListView listView;
    private ImageView imageView;

    @Inject
    public PostContract.Presenter presenter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        listView = (ListView) findViewById(R.id.activity_post_list_view);
        imageView = (ImageView) findViewById(R.id.activity_post_image_view);

        MagnettoApp.getInstance().getAppComponent().plus(new PostModule(this)).inject(this);

        // see: http://www.androiddesignpatterns.com/2015/03/activity-postponed-shared-element-transitions-part3b.html
        postponeEnterTransition(); // temporarily prevent shared element transition.
        // picasso.tag
        // TODO взять picasso из DI
        Picasso.with(this)
                .load(getIntent().getExtras().getString(IMAGE_URL))
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

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, PostRepository.getInstance().getComments());
//        listView.setAdapter(adapter);


        String currentPostID = getIntent().getExtras().getString(POST_ID);
        presenter.procedeComments(currentPostID);
        setTitle("id#" + currentPostID);
    }

    @Override
    public void showComments(@NonNull List<PostComment> comments) {
        // пока просто берём текст комментария
        List<String> simpleCommentsString = new ArrayList<>();
        for (PostComment pc : comments) {
            simpleCommentsString.add(pc.commentText);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, simpleCommentsString);

        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        // picasso.cancel
        finishAfterTransition();
        super.onBackPressed();
    }
}
