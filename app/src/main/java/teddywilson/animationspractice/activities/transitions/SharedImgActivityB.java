package teddywilson.animationspractice.activities.transitions;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import teddywilson.animationspractice.R;

/**
 * Created by Theodore Wilson on 4/7/17.
 * © Toeboat LLC
 */

public class SharedImgActivityB extends Activity {

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_shared_img_b);

        ImageView smallImageView = (ImageView) findViewById(R.id.image_view);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            smallImageView.setTransitionName("a");
        }
    }

}
