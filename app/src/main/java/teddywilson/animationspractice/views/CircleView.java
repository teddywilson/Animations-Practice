package teddywilson.animationspractice.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Theodore Wilson on 4/1/17.
 * © Toeboat LLC
 */

public class CircleView extends View {

    protected Paint mPaint;

    public CircleView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private final int RADIUS = 20;

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawCircle(RADIUS, RADIUS, RADIUS, mPaint);
    }

}
