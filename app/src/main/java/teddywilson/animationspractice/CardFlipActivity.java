package teddywilson.animationspractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Theodore Wilson on 4/11/17.
 * © Toeboat LLC
 */

public class CardFlipActivity extends FragmentActivity{

    private boolean isFlipped = false;

    @Override
    public void onCreate(Bundle instance){
        super.onCreate(instance);
        setContentView(R.layout.activity_card_flip);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.card, new CardFrontFragment())
                .commit();
    }

    public void flipCard(View v){
        if(isFlipped){
            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.animator.enter_right, R.animator.exit_left)
                    .replace(R.id.card, new CardFrontFragment())
                    .commit();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.animator.enter_right, R.animator.exit_left)
                    .replace(R.id.card, new CardBackFragment())
                    .commit();
        }
        isFlipped = !isFlipped;
    }

    public static class CardFrontFragment extends Fragment{

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card_front, container, false);
        }
    }

    public static class CardBackFragment extends Fragment{

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card_back, container, false);
        }
    }

}
