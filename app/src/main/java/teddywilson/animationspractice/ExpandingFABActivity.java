package teddywilson.animationspractice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

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
        revealWithAnimatorUtils();
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
        set.start();
    }

    private void revealWithObjectAnimtor(){
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator xAnim = ObjectAnimator.ofFloat(fab, "x", -dm.widthPixels);
        ObjectAnimator yAnim = ObjectAnimator.ofFloat(fab, "y", -dm.heightPixels);
        final int radius = (int) (((int) Math.sqrt(Math.pow(dm.widthPixels*2, 2)+Math.pow(dm.heightPixels*2, 2))) * 1.5);

        ValueAnimator xScaleAnim = ValueAnimator.ofInt(fabWidth, radius);
        xScaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                fab.getLayoutParams().width = (Integer) animation.getAnimatedValue();
                fab.setLayoutParams(fab.getLayoutParams());
            }
        });

        ValueAnimator yScaleAnim = ValueAnimator.ofInt(fabHeight, radius);
        yScaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                fab.getLayoutParams().height = (Integer) animation.getAnimatedValue();
                fab.setLayoutParams(fab.getLayoutParams());
            }
        });

        set.setDuration(300);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.playTogether(xAnim, yAnim, xScaleAnim, yScaleAnim);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(ExpandingFABActivity.this, PinkActivity.class));
            }
        });

        set.start();
    }

}
