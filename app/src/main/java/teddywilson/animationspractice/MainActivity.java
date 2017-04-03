package teddywilson.animationspractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import teddywilson.animationspractice.views.CircleView;

import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {

    FrameLayout parent;
    List<CircleView> dotViews;
    Button button;

    DisplayMetrics dm;
    int statusBarOffset;
    int xOffset;

    private boolean isStraight = true;

    private final int animDuration = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent = (FrameLayout) findViewById(R.id.parent);
        button = (Button) findViewById(R.id.button);

        dotViews = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            CircleView dot = new CircleView(this);
            dotViews.add(dot);
            parent.addView(dot);;
        }

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        //statusBarOffset = dm.heightPixels - parent.getMeasuredHeight();
        statusBarOffset = 150;
        xOffset = (dm.widthPixels/dotViews.size())/2;

        straightLine();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isStraight){
                    zigZag();
                } else {
                    straightLine();
                }
                isStraight = !isStraight;
            }
        });
    }

    private void straightLine(){
        for(int i = 0; i < dotViews.size(); i++){
            CircleView cv = dotViews.get(i);
            int[] location = new int[2];
            cv.getLocationOnScreen(location);

            int xDest = (dm.widthPixels/dotViews.size()) * i + xOffset;
            int yDest = (dm.heightPixels/2)-statusBarOffset;

            TranslateAnimation animation = new TranslateAnimation(cv.getX(), xDest, cv.getY(), yDest);
            animation.setDuration(animDuration);
            animation.setFillAfter(true);
            cv.startAnimation(animation);
        }
    }

    private void zigZag(){
        for(int i = 0; i < dotViews.size(); i++){
            final CircleView cv = dotViews.get(i);
            int[] location = new int[2];
            cv.getLocationOnScreen(location);

            int yOffset = 200;
            if(i % 2 != 0){
                yOffset = -yOffset;
            }

            int xDest = (dm.widthPixels/dotViews.size()) * i + xOffset;
            int yDest = (dm.heightPixels/2) + yOffset - statusBarOffset;

            TranslateAnimation animation = new TranslateAnimation(cv.getX(), xDest, cv.getY(), yDest);
            animation.setDuration(animDuration);
            animation.setFillAfter(true);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    cv.layout(y);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            cv.startAnimation(animation);
        }
    }

    private void circle(){

    }


}
