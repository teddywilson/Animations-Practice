package teddywilson.animationspractice;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import teddywilson.animationspractice.views.CircleView;

/**
 * Created by Theodore Wilson on 4/3/17.
 * © Toeboat LLC
 */

public class DotsActivity extends Activity{

    FrameLayout parent;
    LinearLayout buttonContainer;
    List<CircleView> dots;
    DisplayMetrics displayMetrics;

    final int NUM_DOTS = 10;
    final int ANIM_DURATION = 200;
    int yOffset = 0;

    private enum State {
        LINE,
        ZIGZAG,
        CIRCLE
    }
    private State state = State.LINE;
    private static String STATE = "state";

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_dots);
        parent = (FrameLayout) findViewById(R.id.parent);
        buttonContainer = (LinearLayout) findViewById(R.id.linear_layout_buttons);
        buttonContainer.post(new Runnable() {
            @Override
            public void run() {
                yOffset = buttonContainer.getMeasuredHeight()/2;
            }
        });
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        dots = new ArrayList<>();
        for(int i = 0; i < NUM_DOTS; i++){
            CircleView cv = new CircleView(this);
            dots.add(cv);
            parent.addView(cv);
        }

        if(savedInstance == null) {
            line(null);
        } else {
            state = (State) savedInstance.getSerializable(STATE);
            if(state == null){
                state = State.LINE;
            }
            switch (state){
                case LINE:
                    line(null);
                    break;
                case ZIGZAG:
                    zigzag(null);
                    break;
                case CIRCLE:
                    circle(null);
                    break;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        bundle.putSerializable(STATE, state);
        super.onSaveInstanceState(bundle);
    }

    public void zigzag(View view){
        int space = displayMetrics.widthPixels/NUM_DOTS;
        int midY = displayMetrics.heightPixels/2;
        int count = 2;
        for(int i = 0; i < NUM_DOTS; i++){
            CircleView cv = dots.get(i);
            ObjectAnimator x = ObjectAnimator.ofFloat(cv, "x", i * space + (space/2 - cv.getMeasuredWidth()));
            ObjectAnimator y;
            if((i + 2) % 2  == 0) {
                y = ObjectAnimator.ofFloat(cv, "y", midY-yOffset);
            } else {
                if(count++ % 2 == 0){
                    y = ObjectAnimator.ofFloat(cv, "y", midY-200-yOffset);
                } else {
                    y = ObjectAnimator.ofFloat(cv, "y", midY+200-yOffset);
                }
            }
            AnimatorSet set = new AnimatorSet();
            set.setInterpolator(new LinearInterpolator());
            set.setDuration(ANIM_DURATION);
            set.playTogether(x, y);
            set.start();
        }
        state = State.ZIGZAG;
    }

    public void line(View view){
        int space = displayMetrics.widthPixels/NUM_DOTS;
        int midY = displayMetrics.heightPixels/2;
        for(int i = 0; i < NUM_DOTS; i++){
            CircleView cv = dots.get(i);
            ObjectAnimator x = ObjectAnimator.ofFloat(cv, "x", i * space + (space/2 - cv.getMeasuredWidth()));
            ObjectAnimator y = ObjectAnimator.ofFloat(cv, "y", midY-yOffset);
            AnimatorSet set = new AnimatorSet();
            set.setInterpolator(new LinearInterpolator());
            set.setDuration(ANIM_DURATION);
            set.playTogether(x, y);
            set.start();
        }
        state = State.LINE;
    }

    public void circle(View view) {
        float radius = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) / 4;
        float originX = displayMetrics.widthPixels / 2;
        float originY = displayMetrics.heightPixels / 2;
        double slice = 2 * Math.PI / NUM_DOTS;
        for (int i = 0; i < NUM_DOTS; i++) {
            CircleView cv = dots.get(i);
            float x = radius * ((float) Math.cos(slice * i)) + originX - cv.getMeasuredWidth();
            float y = radius * ((float) Math.sin(slice * i)) + originY - cv.getMeasuredHeight();
            ObjectAnimator xAnim = ObjectAnimator.ofFloat(cv, "x", x);
            ObjectAnimator yAnim = ObjectAnimator.ofFloat(cv, "y", y-yOffset);
            AnimatorSet set = new AnimatorSet();
            set.setInterpolator(new LinearInterpolator());
            set.setDuration(ANIM_DURATION);
            set.playTogether(xAnim, yAnim);
            set.start();
        }
        state = State.CIRCLE;
    }

}
