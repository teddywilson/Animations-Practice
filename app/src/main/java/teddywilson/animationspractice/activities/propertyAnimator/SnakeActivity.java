package teddywilson.animationspractice.activities.propertyAnimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

import teddywilson.animationspractice.R;
import teddywilson.animationspractice.views.CircleView;

/**
 * Created by Theodore Wilson on 4/22/17.
 * © Toeboat LLC
 */

public class SnakeActivity extends AppCompatActivity {

    FrameLayout mParent;
    CircleView mCircleView;

    private final int ANIM_DURATION_LEFT_RIGHT = 500;
    private final int ANIM_DURATION_DOWN = 100;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_snake);

        mParent = (FrameLayout) findViewById(R.id.parent);
        mCircleView = new CircleView(this);
        mParent.addView(mCircleView);

        //Don't start the animation until the view has been drawn.
        mParent.post(new Runnable() {
            @Override
            public void run() {
                recursiveAnim(true, mCircleView.getBottom());
            }
        });

    }

    private void recursiveAnim(final boolean isRight, final int currY){
        if(currY >= mParent.getBottom() - mCircleView.getHeight()){
            return;
        }
        mCircleView
                .animate()
                .x(isRight ? mParent.getRight()-mCircleView.getRight(): 0)
                .setDuration(ANIM_DURATION_LEFT_RIGHT)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mCircleView
                                .animate()
                                .y(currY)
                                .setDuration(ANIM_DURATION_DOWN)
                                .setInterpolator(new AccelerateDecelerateInterpolator())
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        recursiveAnim(!isRight, currY + mCircleView.getHeight());
                                    }
                                });
                    }
                });
    }
}
