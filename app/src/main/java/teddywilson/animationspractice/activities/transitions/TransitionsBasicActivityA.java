package teddywilson.animationspractice.activities.transitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/22/17.
 * © Toeboat LLC
 */

public class TransitionsBasicActivityA extends AppCompatActivity implements View.OnClickListener {

    Button mButton;
    EditText mEditTextA, mEditTextB;

    @Override
    public void onCreate(Bundle savedInstance){
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_transition_a);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);

        mEditTextA = (EditText) findViewById(R.id.edit_text_a);
        mEditTextB = (EditText) findViewById(R.id.edit_text_b);
    }

    @Override
    public void onClick(View v){
        if(v == mButton){
            Intent i = new Intent(this, TransitionsBasicActivityB.class);

            Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    Pair.create((View) mButton, "random"),
                    Pair.create((View) mEditTextA, "editTextA"),
                    Pair.create((View) mEditTextB, "editTextB")
            ).toBundle();

            startActivity(i, bundle);
        }
    }
}
