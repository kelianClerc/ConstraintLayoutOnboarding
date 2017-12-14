package com.fabernovel.constraintanimations.app.onboarding.presenter;

import com.fabernovel.constraintanimations.app.common.Presenter;
import com.fabernovel.constraintanimations.app.onboarding.ui.OnboardingViewContract;
import com.fabernovel.constraintanimations.utils.trace.Trace;

import javax.inject.Inject;

public class OnboardingPresenter extends Presenter<OnboardingViewContract> {

    @Inject OnboardingPresenter(OnboardingViewContract view) {
        super(view);
    }

    private boolean onboardingDone;

    @Trace
    public void onStart() {
        if (onboardingDone) {
            return;
        }
        beginOnboarding();
    }

    private void beginOnboarding() {
        view.showOnboarding();
    }

    @Trace
    public void onboardingDone() {
        onboardingDone = true;
    }
}
