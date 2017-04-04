package teddywilson.animationspractice;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Theodore Wilson on 4/3/17.
 * © Toeboat LLC
 */

public class FadeActivity extends Activity{

    View fadeView;
    boolean isFaded = false;
    int duration = 1500;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_fade);
        fadeView = findViewById(R.id.view_to_fade);
    }

    public void toggleFade(View v){
        AnimatorSet set = new AnimatorSet();
        if(isFaded){
            ObjectAnimator fadeInAnim = ObjectAnimator.ofFloat(fadeView, "alpha", 1.0f);
            set.play(fadeInAnim);
        } else {
            ObjectAnimator fadeOutAnim = ObjectAnimator.ofFloat(fadeView, "alpha", 0.0f);
            set.play(fadeOutAnim);
        }
        set.start();
        isFaded = !isFaded;
    }


}
