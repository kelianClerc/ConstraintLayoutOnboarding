package com.fabernovel.constraintanimations.app.onboarding.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.TextView;
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

    private static final int ONBOARDING_MESSAGE_A_STEP = 0;
    private static final int ONBOARDING_MESSAGE_B_STEP = 1;
    private static final int ONBOARDING_WRITE_MESSAGE_STEP = 2;
    private static final int ONBOARDING_ADD_RESOURCE_STEP = 3;
    private static final int DEFAULT_STEP = ONBOARDING_MESSAGE_A_STEP;
    private static final int FINAL_STEP = ONBOARDING_ADD_RESOURCE_STEP;

    private final ConstraintSet constraintMessageA = new ConstraintSet();
    private final ConstraintSet constraintMessageB = new ConstraintSet();
    private final ConstraintSet constraintWrite = new ConstraintSet();
    private final ConstraintSet constraintAdd = new ConstraintSet();
    private final ConstraintSet constraintDefault = new ConstraintSet();

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.hint) TextView hint;
    @BindView(R.id.constraint) ConstraintLayout constraint;
    private int currentStep;

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
        setupOnboarding();
    }

    private void setupOnboarding() {
        constraintDefault.clone(constraint);
        constraintMessageA.clone(this, R.layout.partial_message_a_onboarding);
        constraintMessageB.clone(this, R.layout.partial_message_b_onboarding);
        constraintWrite.clone(this, R.layout.partial_write_onboarding);
        constraintAdd.clone(this, R.layout.partial_add_resource_onboarding);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
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
        currentStep = DEFAULT_STEP;
        processOnboarding();
    }

    private void processOnboarding() {
        ConstraintSet nextStep;
        switch (currentStep) {
            case ONBOARDING_MESSAGE_A_STEP:
                hint.setText("Here you can read your friend messages");
                nextStep = constraintMessageA;
                break;
            case ONBOARDING_MESSAGE_B_STEP:
                hint.setText("Here you can read your own messages");
                nextStep = constraintMessageB;
                break;
            case ONBOARDING_WRITE_MESSAGE_STEP:
                hint.setText("If you want to send a message you can type it here");
                nextStep = constraintWrite;
                break;
            case ONBOARDING_ADD_RESOURCE_STEP:
                hint.setText("To add a resource click here");
                nextStep = constraintAdd;
                break;
            default:
                nextStep = constraintDefault;
                break;
        }
        TransitionManager.beginDelayedTransition(constraint);
        nextStep.applyTo(constraint);
    }

    @OnClick(R.id.continue_onboarding)
    public void onContinueOnboarding() {
        currentStep++;
        processOnboarding();
    }
}
