package com.fabernovel.constraintanimations.app.onboarding.presenter;

import com.fabernovel.constraintanimations.app.common.Presenter;
import com.fabernovel.constraintanimations.app.onboarding.ui.OnboardingViewContract;

import javax.inject.Inject;

public class OnboardingPresenter extends Presenter<OnboardingViewContract> {

    @Inject OnboardingPresenter(OnboardingViewContract view) {
        super(view);
    }
}
