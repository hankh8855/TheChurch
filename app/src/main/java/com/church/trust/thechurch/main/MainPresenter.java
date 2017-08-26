package com.church.trust.thechurch.main;

import android.support.annotation.NonNull;
import android.util.Log;

import com.church.trust.thechurch.data.Weekly;
import static com.google.common.base.Preconditions.checkNotNull;
/**
 * Created by Han on 2017-04-01.
 */

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mMainView;

    public MainPresenter(@NonNull MainContract.View mainView) {
        mMainView = checkNotNull(mainView,"mainView cannot be null");
        mMainView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void addNewWeekly() {
        mMainView.showAddWeekly();
    }

    @Override
    public void openWeeklyDetails(@NonNull Weekly requsetedWeekly) {
        checkNotNull(requsetedWeekly, "clickedWeekly cannot be null");
        mMainView.showWeeklyDetailsUi(requsetedWeekly.getId());
    }

    @Override
    public void openWeeklyDetails_temp(@NonNull int s) {
        mMainView.showWeeklyDetailsUi_temp(s);
    }
}
