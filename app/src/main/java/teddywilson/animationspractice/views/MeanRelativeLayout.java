package teddywilson.animationspractice.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Theodore Wilson on 4/10/17.
 *
 * - Relative layout which does not allow children to receive touch events.
 *
 */

public class MeanRelativeLayout extends RelativeLayout{

    public MeanRelativeLayout(Context context) {
        super(context);
    }

    public MeanRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeanRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

}
