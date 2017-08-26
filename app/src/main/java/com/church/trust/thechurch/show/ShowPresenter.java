package com.church.trust.thechurch.show;

import android.support.annotation.NonNull;
import static com.google.common.base.Preconditions.checkNotNull;
/**
 * Created by Han on 2017-04-01.
 */

public class ShowPresenter implements ShowContract.Presenter{

    private final ShowContract.View mShowView;

    public ShowPresenter(@NonNull ShowContract.View showView) {
        mShowView = checkNotNull(showView,"showView cannot be null");
        mShowView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
