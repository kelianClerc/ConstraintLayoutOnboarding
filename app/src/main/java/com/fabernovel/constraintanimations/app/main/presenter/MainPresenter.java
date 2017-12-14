package com.fabernovel.constraintanimations.app.main.presenter;

import com.fabernovel.constraintanimations.app.common.Presenter;
import com.fabernovel.constraintanimations.app.main.ui.MainViewContract;
import com.fabernovel.constraintanimations.utils.trace.Trace;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainViewContract> {

    private boolean viewIsAlreadyLoadedWithData;

    @Inject
    MainPresenter(MainViewContract view) {
        super(view);
    }

    @Trace
    public void start() {
        // TODO (kelianclerc) 14/12/17
    }

    @Trace
    public void stop() {
        // TODO (kelianclerc) 14/12/17
    }
}
