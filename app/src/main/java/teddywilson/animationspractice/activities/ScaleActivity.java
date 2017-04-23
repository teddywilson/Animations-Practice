package teddywilson.animationspractice.activities;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/4/17.
 * © Toeboat LLC
 */

public class ScaleActivity extends Activity{

    View fadeView;
    boolean isScaled = false;
    int duration = 300;
    DisplayMetrics displayMetrics;
    int originalWidth = 0;
    int originalHeight = 0;
    private ValueAnimator scaleUpX, scaleDownX, scaleDownY, scaleUpY;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_scale);
        fadeView = findViewById(R.id.view_to_scale);
        fadeView.post(new Runnable() {
            @Override
            public void run() {
                originalWidth = fadeView.getMeasuredWidth();
                originalHeight = fadeView.getMeasuredHeight();

                scaleDownX = ValueAnimator.ofInt(displayMetrics.widthPixels, originalWidth);
                scaleDownX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        fadeView.getLayoutParams().width = (Integer) animation.getAnimatedValue();
                        fadeView.setLayoutParams(fadeView.getLayoutParams());
                    }
                });
                scaleDownX.setDuration(duration);

                scaleUpX = ValueAnimator.ofInt(originalWidth, displayMetrics.widthPixels);
                scaleUpX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        fadeView.getLayoutParams().width = (Integer) animation.getAnimatedValue();
                        fadeView.setLayoutParams(fadeView.getLayoutParams());
                    }
                });
                scaleUpX.setDuration(duration);

                scaleDownY = ValueAnimator.ofInt(originalHeight * 3, originalHeight);
                scaleDownY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        fadeView.getLayoutParams().height = (Integer) animation.getAnimatedValue();
                        fadeView.setLayoutParams(fadeView.getLayoutParams());
                    }
                });
                scaleDownY.setDuration(duration);

                scaleUpY = ValueAnimator.ofInt(originalHeight, originalHeight * 3);
                scaleUpY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        fadeView.getLayoutParams().height = (Integer) animation.getAnimatedValue();
                        fadeView.setLayoutParams(fadeView.getLayoutParams());
                    }
                });
                scaleUpY.setDuration(duration);
            }
        });

        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    }

    public void toggleScale(View v){
        if(scaleDownX != null && scaleUpX != null) {
            AnimatorSet set = new AnimatorSet();
            if (isScaled) {
                set.playTogether(scaleDownX, scaleDownY);
            } else {
                set.playTogether(scaleUpX, scaleUpY);
            }
            set.setInterpolator(new LinearInterpolator());
            set.start();
            isScaled = !isScaled;
        }
    }

}
