package teddywilson.animationspractice;

import android.app.Activity;
import android.os.Bundle;

import teddywilson.animationspractice.views.MeanRelativeLayout;

/**
 * Created by Theodore Wilson on 4/10/17.
 * © Toeboat LLC
 */

public class TouchInterceptActivity extends Activity {

    MeanRelativeLayout mParent;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_intercept);

        mParent = (MeanRelativeLayout) findViewById(R.id.parent);

    }
}
