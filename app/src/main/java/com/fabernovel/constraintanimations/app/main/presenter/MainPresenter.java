package com.fabernovel.constraintanimations.app.main.presenter;

import com.fabernovel.constraintanimations.app.common.Presenter;
import com.fabernovel.constraintanimations.app.main.navigator.MainNavigator;
import com.fabernovel.constraintanimations.app.main.ui.MainViewContract;
import com.fabernovel.constraintanimations.utils.trace.Trace;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainViewContract> {

    private final MainNavigator navigator;

    @Inject MainPresenter(MainViewContract view, MainNavigator navigator) {
        super(view);
        this.navigator = navigator;
    }

    @Trace
    public void start() {
        // TODO (kelianclerc) 14/12/17
    }

    @Trace
    public void stop() {
        // TODO (kelianclerc) 14/12/17
    }

    public void singleViewMoving() {
        navigator.navigateToSingleViewMoving();
    }
}
