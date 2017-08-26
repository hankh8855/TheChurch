package com.church.trust.thechurch.main;

import android.support.annotation.NonNull;

import com.church.trust.thechurch.BasePresenter;
import com.church.trust.thechurch.BaseView;
import com.church.trust.thechurch.data.Weekly;

/**
 * Created by Han on 2017-04-01.
 */

public interface MainContract {

    interface View extends BaseView<Presenter>{

        void showAddWeekly();
        void showWeeklyDetailsUi(String weeklyId);

        void showWeeklyDetailsUi_temp(int s);

    }

    interface Presenter extends BasePresenter{

        void addNewWeekly();
        void openWeeklyDetails(@NonNull Weekly clickedWeekly);

        void openWeeklyDetails_temp(@NonNull int s);

    }

}
