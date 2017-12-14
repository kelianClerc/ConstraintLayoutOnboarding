package com.fabernovel.constraintanimations.app.singleviewmoving.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fabernovel.constraintanimations.R;
import com.fabernovel.constraintanimations.app.common.BaseActivity;
import com.fabernovel.constraintanimations.app.singleviewmoving.ui.SingleViewMovingViewContract;
import com.fabernovel.constraintanimations.di.ComponentManager;

public class SingleViewMovingActivity extends BaseActivity implements SingleViewMovingViewContract {

    public static Intent makeIntent(Context context) {
        return new Intent(context, SingleViewMovingActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();
    }

    @Override
    protected void injectDependencies() {
        ComponentManager.getLoggingComponent().inject(this);
    }

    private void setupView() {
        setContentView(R.layout.activity_single_moving);
    }
}
