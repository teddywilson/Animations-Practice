package teddywilson.animationspractice.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import teddywilson.animationspractice.R;
import teddywilson.animationspractice.adapter.PhotoGalleryAdapter;
import teddywilson.animationspractice.listeners.RecyclerViewListener;

/**
 * Created by Theodore Wilson on 4/19/17.
 * © Toeboat LLC
 */

public class PhotoGalleryActivity extends AppCompatActivity{

    RecyclerView mRecyclerView;
    PhotoGalleryAdapter mAdapter;
    List<String> mImages;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_photo_gallery);
        mImages = new ArrayList<>();
        mImages.add("https://s-media-cache-ak0.pinimg.com/564x/3a/f9/40/3af94086eed2a32cb90df23258f04bbc.jpg");
        mImages.add("http://hq-wall.net/wall_preview/10160/Lily_Pond_and_Japanese_Bridge,_Byfleet_Manor,_Surrey,_United.jpg");
        mImages.add("https://i.ytimg.com/vi/JwS4TCrbiRE/maxresdefault.jpg");
        mImages.add("https://www.1st-art-gallery.com/thumbnail/78000/78664/painting_page_800x/Renoir/A-Bowlful-Of-Roses.jpg?ts=1459229076");
        mImages.add("https://nyppagesix.files.wordpress.com/2016/07/forged-monet-painting.jpg?quality=90&strip=all&strip=all");

        mAdapter = new PhotoGalleryAdapter(this, mImages);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerViewListener(this, mRecyclerView, new RecyclerViewListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i = new Intent(PhotoGalleryActivity.this, PhotoDetailsActivity.class);
                i.putExtra("url", mImages.get(position));
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(PhotoGalleryActivity.this, view, "a");
                startActivity(i, options.toBundle());
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

}
