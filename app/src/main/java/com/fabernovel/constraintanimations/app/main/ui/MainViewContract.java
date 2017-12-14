package com.fabernovel.constraintanimations.app.main.ui;

import android.support.annotation.StringRes;

import com.fabernovel.constraintanimations.app.common.ViewContract;

public interface MainViewContract extends ViewContract {
    void showMessage(@StringRes int message);
}
