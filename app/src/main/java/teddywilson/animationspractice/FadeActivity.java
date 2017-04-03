package teddywilson.animationspractice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by Theodore Wilson on 4/3/17.
 * © Toeboat LLC
 */

public class FadeActivity extends Activity{

    View fadeView;
    boolean isFaded = false;
    int duration = 1500;

    AlphaAnimation fadeOut, fadeIn;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_fade);
        fadeView = findViewById(R.id.view_to_fade);

        fadeOut = new AlphaAnimation(1.0f, 0.f);
        fadeOut.setDuration(duration);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fadeView.setAlpha(0.0f);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(duration);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fadeView.setAlpha(1.0f);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void toggleFade(View v){
        if(isFaded){
            fadeView.startAnimation(fadeIn);
        } else {
            fadeView.startAnimation(fadeOut);
        }
        isFaded = !isFaded;
    }


}
