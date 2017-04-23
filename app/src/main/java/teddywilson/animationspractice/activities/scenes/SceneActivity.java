package teddywilson.animationspractice.activities.scenes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/23/17.
 * © Toeboat LLC
 */

public class SceneActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout mSceneRoot;
    Button mButton1, mButton2, mButton3, mButton4;
    Scene scene1, scene2, scene3, scene4;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_scene);

        mSceneRoot = (LinearLayout) findViewById(R.id.scene_root);
        mButton1 = (Button) findViewById(R.id.button_1);
        mButton2 = (Button) findViewById(R.id.button_2);
        mButton3 = (Button) findViewById(R.id.button_3);
        mButton4 = (Button) findViewById(R.id.button_4);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);

        scene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_1, this);
        scene2 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_2, this);
        scene3 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_3, this);
        scene4 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_4, this);
    }

    @Override
    public void onClick(View v){
        if(v == mButton1){

            TransitionManager.go(scene1);

        } else if(v == mButton2){

            TransitionManager.go(scene2);

        } else if(v == mButton3){

            TransitionManager.go(scene3);

        } else if(v == mButton4){

            TransitionManager.go(scene4);

        }
    }
}
