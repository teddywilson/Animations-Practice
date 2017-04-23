package teddywilson.animationspractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import teddywilson.animationspractice.activities.CardFlipActivity;
import teddywilson.animationspractice.activities.propertyAnimator.DotsActivity;
import teddywilson.animationspractice.activities.gestures.DragActivity;
import teddywilson.animationspractice.activities.gestures.ExpandTouchActivity;
import teddywilson.animationspractice.activities.propertyAnimator.ExpandingFABActivity;
import teddywilson.animationspractice.activities.propertyAnimator.FadeActivity;
import teddywilson.animationspractice.activities.gestures.GestureActivity;
import teddywilson.animationspractice.activities.PhotoGalleryActivity;
import teddywilson.animationspractice.activities.ScaleActivity;
import teddywilson.animationspractice.activities.scenes.SceneActivity;
import teddywilson.animationspractice.activities.transitions.SharedImgActivityA;
import teddywilson.animationspractice.activities.propertyAnimator.SnakeActivity;
import teddywilson.animationspractice.activities.gestures.TouchInterceptActivity;
import teddywilson.animationspractice.activities.ViewPagerActivity;
import teddywilson.animationspractice.activities.transitions.TransitionsBasicActivityA;
import teddywilson.animationspractice.adapter.MainActivityAdapter;
import teddywilson.animationspractice.listeners.RecyclerViewListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new MainActivityAdapter(this));
        recyclerView.addOnItemTouchListener(new RecyclerViewListener(this, recyclerView, new RecyclerViewListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this, FadeActivity.class));
                        break;

                    case 1:
                        startActivity(new Intent(MainActivity.this, DotsActivity.class));
                        break;

                    case 2:
                        startActivity(new Intent(MainActivity.this, ScaleActivity.class));
                        break;

                    case 3:
                        startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
                        break;

                    case 4:
                        startActivity(new Intent(MainActivity.this, ExpandingFABActivity.class));
                        break;

                    case 5:
                        startActivity(new Intent(MainActivity.this, SharedImgActivityA.class));
                        break;

                    case 6:
                        startActivity(new Intent(MainActivity.this, GestureActivity.class));
                        break;

                    case 7:
                        startActivity(new Intent(MainActivity.this, TouchInterceptActivity.class));
                        break;

                    case 8:
                        startActivity(new Intent(MainActivity.this, ExpandTouchActivity.class));
                        break;

                    case 9:
                        startActivity(new Intent(MainActivity.this, CardFlipActivity.class));
                        break;

                    case 10:
                        startActivity(new Intent(MainActivity.this, PhotoGalleryActivity.class));
                        break;

                    case 11:
                        startActivity(new Intent(MainActivity.this, DragActivity.class));
                        break;

                    case 12:
                        startActivity(new Intent(MainActivity.this, SnakeActivity.class));
                        break;

                    case 13:
                        startActivity(new Intent(MainActivity.this, TransitionsBasicActivityA.class));
                        break;

                    case 14:
                        startActivity(new Intent(MainActivity.this, SceneActivity.class));
                        break;
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

    }

}
