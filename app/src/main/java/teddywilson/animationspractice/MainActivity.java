package teddywilson.animationspractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

    }

}
