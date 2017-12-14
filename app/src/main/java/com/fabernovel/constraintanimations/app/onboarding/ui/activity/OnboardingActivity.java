package com.fabernovel.constraintanimations.app.onboarding.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.fabernovel.constraintanimations.R;
import com.fabernovel.constraintanimations.app.common.BaseActivity;
import com.fabernovel.constraintanimations.app.onboarding.presenter.OnboardingPresenter;
import com.fabernovel.constraintanimations.app.onboarding.ui.OnboardingViewContract;
import com.fabernovel.constraintanimations.di.ComponentManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnboardingActivity extends BaseActivity implements OnboardingViewContract {

    @BindView(R.id.toolbar) Toolbar toolbar;

    @Inject OnboardingPresenter presenter;

    public static Intent makeIntent(Context context) {
        return new Intent(context, OnboardingActivity.class);
    }

    @Override
    protected void injectDependencies() {
        ComponentManager.getOnboardingComponent(this, this).inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();
        setupToolbar();
    }

    private void setupView() {
        setContentView(R.layout.activity_onboarding);
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

    @OnClick(R.id.add_button)
    public void onAddClicked() {
        Toast.makeText(this, "Open gallery", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showOnboarding() {
        // TODO (kelianclerc) 14/12/17  
    }
}
