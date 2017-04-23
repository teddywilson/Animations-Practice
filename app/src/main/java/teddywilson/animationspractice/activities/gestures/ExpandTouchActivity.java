package teddywilson.animationspractice.activities.gestures;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/10/17.
 * © Toeboat LLC
 */

public class ExpandTouchActivity extends Activity {

    RelativeLayout parent;
    Button button;

    @Override
    public void onCreate(Bundle instance){
        super.onCreate(instance);
        setContentView(R.layout.activity_expand_touch);
        parent = (RelativeLayout) findViewById(R.id.parent);
        button = (Button) findViewById(R.id.button);

        //Expand the touch delegate after the view has been drawn
        parent.post(new Runnable() {
            @Override
            public void run() {

                Rect rect = new Rect();
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ExpandTouchActivity.this, "Hey", Toast.LENGTH_LONG).show();
                    }
                });

                button.getHitRect(rect);

                rect.bottom += 500;
                rect.top -= 500;
                rect.left -= 100;
                rect.right += 100;

                TouchDelegate newDelegate = new TouchDelegate(rect, button);

                if(View.class.isInstance(button.getParent())) {
                    ((View) button.getParent()).setTouchDelegate(newDelegate);
                }

            }
        });
    }
}
