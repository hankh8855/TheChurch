package com.church.trust.thechurch.sample;

import android.support.annotation.NonNull;

import com.church.trust.thechurch.data.Weekly;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Han on 2017-04-01.
 */

public class SamplePresenter implements SampleContract.Presenter {

    private final SampleContract.View mSampleView;

    public SamplePresenter(@NonNull SampleContract.View sampleView) {
        mSampleView = checkNotNull(sampleView,"sampleView cannot be null");
        mSampleView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void addNewWeekly() {
        mSampleView.showAddWeekly();
    }

    @Override
    public void openWeeklyDetails(@NonNull Weekly requsetedWeekly) {
        checkNotNull(requsetedWeekly, "clickedWeekly cannot be null");
        mSampleView.showWeeklyDetailsUi(requsetedWeekly.getId());
    }

    @Override
    public void openWeeklyDetails_temp(@NonNull int s) {
        mSampleView.showWeeklyDetailsUi_temp(s);
    }
}
