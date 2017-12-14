package com.fabernovel.constraintanimations.di.onboarding;

import com.fabernovel.constraintanimations.app.onboarding.ui.activity.OnboardingActivity;
import com.fabernovel.constraintanimations.di.PerActivity;
import com.fabernovel.constraintanimations.di.common.ApplicationComponent;
import com.fabernovel.constraintanimations.di.common.ContextModule;

import dagger.Component;

@PerActivity
@Component(
    dependencies = ApplicationComponent.class,
    modules = {OnboardingModule.class, ContextModule.class}
)
public interface OnboardingComponent {
    void inject(OnboardingActivity activity);
}
