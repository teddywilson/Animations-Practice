package teddywilson.animationspractice.activities.transitions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/22/17.
 * © Toeboat LLC
 */

public class TransitionsBasicActivityB extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstance){
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_transition_b);
    }
}
