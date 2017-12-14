package com.fabernovel.constraintanimations.app.main.navigator;

import android.content.Context;
import android.content.Intent;

import com.fabernovel.constraintanimations.app.singleviewmoving.ui.activity.SingleViewMovingActivity;


import com.fabernovel.constraintanimations.utils.NavigatorUtils;

import javax.inject.Inject;

public class MainNavigator {
    private final Context context;

    @Inject MainNavigator(Context context) {
        this.context = context;
    }

    public void navigateToSingleViewMoving() {
        Intent intent = SingleViewMovingActivity.makeIntent(context);
        context.startActivity(intent, NavigatorUtils.getUpBundle(context));
    }
}
