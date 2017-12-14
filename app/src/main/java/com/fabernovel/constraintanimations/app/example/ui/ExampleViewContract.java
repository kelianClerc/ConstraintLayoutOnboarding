package com.fabernovel.constraintanimations.app.example.ui;

import android.support.annotation.StringRes;

import com.fabernovel.constraintanimations.app.common.ViewContract;

public interface ExampleViewContract extends ViewContract {
    void showMessage(@StringRes int message);
}
