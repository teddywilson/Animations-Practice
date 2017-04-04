package teddywilson.animationspractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import teddywilson.animationspractice.fragments.ViewPagerFragment;

/**
 * Created by Theodore Wilson on 4/4/17.
 * © Toeboat LLC
 */

public class ViewPagerActivity extends FragmentActivity {

    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_view_pager);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ViewPagerFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
