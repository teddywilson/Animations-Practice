package teddywilson.animationspractice.activities.gestures;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/6/17.
 * © Toeboat LLC
 */

public class GestureActivity extends Activity implements GestureDetector.OnGestureListener {

    private GestureDetectorCompat gestureDetectorCompat;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        textView = (TextView) findViewById(R.id.text_view);
        gestureDetectorCompat = new GestureDetectorCompat(this, this);

    }

    @Override
    public boolean onDown(MotionEvent e) {
        textView.setText("On Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        textView.setText("On Show Press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        textView.setText("On Single Tap Up");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        textView.setText("On Scroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        textView.setText("On Long Press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        textView.setText("On Fling");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

}
