package teddywilson.animationspractice.activities;

import android.app.Activity;
import android.os.Bundle;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/7/17.
 * © Toeboat LLC
 */

public class PinkActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pink);
    }
}
