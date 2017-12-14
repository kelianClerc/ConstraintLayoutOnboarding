package com.fabernovel.constraintanimations.di.onboarding;

import com.fabernovel.constraintanimations.app.onboarding.ui.OnboardingViewContract;

import dagger.Module;
import dagger.Provides;

@Module
public class OnboardingModule {
    private final OnboardingViewContract viewContract;

    public OnboardingModule(OnboardingViewContract viewContract) {
        this.viewContract = viewContract;
    }

    @Provides
    OnboardingViewContract viewContract() {
        return viewContract;
    }
}
