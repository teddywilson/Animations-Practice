package teddywilson.animationspractice.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Theodore Wilson on 4/22/17.
 * © Toeboat LLC
 */

public class SquareView extends View{

    Paint mPaint;
    int rectSize = 100;

    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(0, 0, rectSize, rectSize, mPaint);
        setMeasuredDimension(rectSize, rectSize);
    }

}
