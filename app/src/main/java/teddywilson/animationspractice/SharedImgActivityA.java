package teddywilson.animationspractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

/**
 * Created by Theodore Wilson on 4/7/17.
 * © Toeboat LLC
 */

public class SharedImgActivityA extends Activity {

    ImageView imgView;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_shared_img_a);
        imgView = (ImageView) findViewById(R.id.image_view);
    }

    public void go(View v){
        Intent intent = new Intent(this, SharedImgActivityB.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(this, imgView, "a");
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }


}
