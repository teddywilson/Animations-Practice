package teddywilson.animationspractice.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/19/17.
 * © Toeboat LLC
 */

public class PhotoDetailsActivity extends AppCompatActivity {

    ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_photo_details);


        String url = getIntent().getStringExtra("url");
        mImageView = (ImageView) findViewById(R.id.image_view);
        mImageView.setTransitionName("a");
        Glide.with(this).load(url).centerCrop().into(mImageView);


    }
}
