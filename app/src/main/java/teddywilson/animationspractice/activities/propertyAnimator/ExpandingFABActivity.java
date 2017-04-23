package teddywilson.animationspractice.activities.propertyAnimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;

import teddywilson.animationspractice.R;
import teddywilson.animationspractice.activities.PinkActivity;

/**
 * Created by Theodore Wilson on 4/7/17.
 * © Toeboat LLC
 */

public class ExpandingFABActivity extends Activity implements View.OnClickListener{

    private FloatingActionButton fab;
    private DisplayMetrics dm;
    private int fabWidth, fabHeight;
    private FrameLayout viewRoot;

    @Override
    public void onCreate(Bundle savedInstanceState){
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_expanding_fab);
        viewRoot = (FrameLayout) findViewById(R.id.root);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.post(new Runnable() {
            @Override
            public void run() {
                fabWidth = fab.getMeasuredWidth();
                fabHeight = fab.getMeasuredHeight();
                fab.setOnClickListener(ExpandingFABActivity.this);
            }
        });

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
    }

    @Override
    public void onClick(View v){
        revealFromCenter();
    }

    private void revealWithAnimatorUtils(){
        AnimatorSet set = new AnimatorSet();
        final int finalRadius = (int) Math.hypot(viewRoot.getWidth(), viewRoot.getHeight());
        Animator revealAnim = ViewAnimationUtils.createCircularReveal(viewRoot, (int) fab.getX() + fabWidth/2,
                (int) fab.getY() + fabHeight/2, fabWidth/2, finalRadius);
        viewRoot.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(fab, "alpha", 0f);
        set.playTogether(revealAnim, fadeOut);
        set.setDuration(450);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(ExpandingFABActivity.this, PinkActivity.class));
            }
        });
        set.start();
    }

    private void revealFromCenter(){
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.change_bounds_with_arc);
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                revealWithAnimatorUtils();
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });

        TransitionManager.beginDelayedTransition(viewRoot, transition);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) fab.getLayoutParams();
        lp.gravity = Gravity.CENTER;
        fab.setLayoutParams(lp);

    }


}
