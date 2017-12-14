package com.fabernovel.constraintanimations.app.singleviewmoving.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fabernovel.constraintanimations.R;
import com.fabernovel.constraintanimations.app.common.BaseActivity;
import com.fabernovel.constraintanimations.app.singleviewmoving.ui.SingleViewMovingViewContract;
import com.fabernovel.constraintanimations.di.ComponentManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingleViewMovingActivity extends BaseActivity implements SingleViewMovingViewContract {

    @BindView(R.id.toolbar) Toolbar toolbar;

    public static Intent makeIntent(Context context) {
        return new Intent(context, SingleViewMovingActivity.class);
    }

    @Override
    protected void injectDependencies() {
        ComponentManager.getLoggingComponent().inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();
        setupToolbar();
    }

    private void setupView() {
        setContentView(R.layout.activity_single_moving);
        ButterKnife.bind(this);
    }

    private void setupToolbar() {
        toolbar.setNavigationOnClickListener(getNavigationListener());
    }

    private View.OnClickListener getNavigationListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        };
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, R.anim.slide_down);
    }
}
