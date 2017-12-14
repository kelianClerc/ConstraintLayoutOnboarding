package com.fabernovel.constraintanimations.di.main;

import com.fabernovel.constraintanimations.app.main.ui.activity.MainActivity;
import com.fabernovel.constraintanimations.di.PerActivity;
import com.fabernovel.constraintanimations.di.common.ApplicationComponent;
import com.fabernovel.constraintanimations.di.common.ContextModule;

import dagger.Component;

@PerActivity
@Component(
    dependencies = ApplicationComponent.class,
    modules = {
        ContextModule.class,
        MainModule.class
    }
)
public interface MainComponent {
    void inject(MainActivity activity);
}

