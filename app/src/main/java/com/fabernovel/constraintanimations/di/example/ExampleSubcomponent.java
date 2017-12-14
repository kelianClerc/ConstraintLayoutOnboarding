package com.fabernovel.constraintanimations.di.example;

import com.fabernovel.constraintanimations.app.example.ui.activity.ExampleActivity;
import com.fabernovel.constraintanimations.di.PerActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerActivity
@Subcomponent(
    modules = {ExampleModule.class}
)
public interface ExampleSubcomponent extends AndroidInjector<ExampleActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ExampleActivity> {}
}
