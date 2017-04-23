package teddywilson.animationspractice.activities.gestures;

import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import teddywilson.animationspractice.R;
import teddywilson.animationspractice.views.SquareView;

/**
 * Created by Theodore Wilson on 4/22/17.
 * © Toeboat LLC
 */

public class DragActivity extends AppCompatActivity {

    SquareView mSquareView;
    float mCurrX = 0;
    float mCurrY = 0;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_drag);
        mSquareView = (SquareView) findViewById(R.id.view_square);
        mSquareView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = MotionEventCompat.getActionMasked(event);
                switch (action){

                    case MotionEvent.ACTION_UP | MotionEvent.ACTION_CANCEL:
                        return false;

                    case MotionEvent.ACTION_MOVE:



                        mCurrX = event.getX();
                        mCurrY = event.getY();


                }

                return true;
            }
        });
    }
}
