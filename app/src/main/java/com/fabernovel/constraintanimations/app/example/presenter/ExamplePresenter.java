package com.fabernovel.constraintanimations.app.example.presenter;

import android.support.annotation.StringRes;

import com.fabernovel.constraintanimations.app.common.Presenter;
import com.fabernovel.constraintanimations.app.example.ui.ExampleViewContract;
import com.fabernovel.constraintanimations.core.interactor.ExampleInteractor;
import com.fabernovel.constraintanimations.core.interactor.ExampleListener;
import com.fabernovel.constraintanimations.utils.trace.Trace;

import javax.inject.Inject;

public class ExamplePresenter extends Presenter<ExampleViewContract> implements ExampleListener {

    private boolean viewIsAlreadyLoadedWithData;

    private final ExampleInteractor interactor;

    @Inject ExamplePresenter(ExampleViewContract view, ExampleInteractor interactor) {
        super(view);
        this.interactor = interactor;
        viewIsAlreadyLoadedWithData = false;
    }

    @Trace
    public void start() {
        if (viewIsAlreadyLoadedWithData) {
            return;
        }
        interactor.execute(this);
    }

    @Trace
    public void stop() {
        interactor.done();
    }

    @Override @Deprecated @Trace
    public void onResult(@StringRes int message) {
        viewIsAlreadyLoadedWithData = true;
        view.showMessage(message);
    }
}
