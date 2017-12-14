package com.fabernovel.constraintanimations.app.main.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fabernovel.constraintanimations.R;
import com.fabernovel.constraintanimations.app.common.BaseActivity;
import com.fabernovel.constraintanimations.app.main.presenter.MainPresenter;
import com.fabernovel.constraintanimations.app.main.ui.MainViewContract;
import com.fabernovel.constraintanimations.di.ComponentManager;
import com.fabernovel.constraintanimations.utils.theme.ThemeUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainViewContract {

    @Inject MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ThemeUtils.ensureRuntimeTheme(this);
        super.onCreate(savedInstanceState);
        setupView();
    }

    @Override
    protected void injectDependencies() {
        ComponentManager.getMainComponent(this, this).inject(this);
    }

    private void setupView() {
        setContentView(R.layout.activity_example);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @OnClick(R.id.single_view_moving_button)
    public void onSingleViewMovingButton() {
        presenter.singleViewMoving();
    }

    @OnClick(R.id.onboarding_button)
    public void onOnboardingButton() {
        presenter.onBoarding();
    }
}
