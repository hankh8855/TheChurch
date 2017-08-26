package com.church.trust.thechurch.show;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.church.trust.thechurch.R;
import com.church.trust.thechurch.util.ActivityUtils;

public class ShowActivity extends AppCompatActivity {

    public static final String EXTRA_WEEKLY_ID = "WEEKLY_ID";
    public static final String EXTRA_temp_ID = "temp_ID";

    private  ShowPresenter showPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_act);

        //Create the fragment
        ShowFragment showFragment = (ShowFragment) getSupportFragmentManager().findFragmentById(R.id.editContentFrame);
        if(showFragment==null){
            showFragment = ShowFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),showFragment,R.id.editContentFrame);
        }

        showPresenter = new ShowPresenter(showFragment);
    }
}
