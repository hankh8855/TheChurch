package com.church.trust.thechurch.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.church.trust.thechurch.R;
import com.church.trust.thechurch.sample.SampleFragment;
import com.church.trust.thechurch.sample.SamplePresenter;

public class MainActivity extends AppCompatActivity {

    private MainPresenter mMainPresenter;
    FragmentPagerAdapter fragmentPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vpPager);
        fragmentPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);

        //Create the fragment
//        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainContentFrame);
//        if (mainFragment == null){
//            mainFragment = MainFragment.newInstance();
//            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),mainFragment,R.id.mainContentFrame);
//        }

        //Create the presenter
//        mMainPresenter = new MainPresenter(mainFragment);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this,"selected page position: "+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public static class MainPagerAdapter extends FragmentPagerAdapter{

        private static int NUM_ITEMS = 2;

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    MainFragment mainFragment = MainFragment.newInstance();
                    new MainPresenter(mainFragment);
                    return mainFragment;
                case 1:
                    SampleFragment sampleFragment = SampleFragment.newInstance();
                    new SamplePresenter(sampleFragment);
                    return SampleFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "mine";
                case 1:
                    return "sample";
                default:
                    return "?";
            }
        }
    }
}
