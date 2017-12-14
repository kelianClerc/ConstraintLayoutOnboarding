package com.fabernovel.constraintanimations.di.example;

import android.content.Context;

import com.fabernovel.constraintanimations.app.example.ui.ExampleViewContract;
import com.fabernovel.constraintanimations.app.example.ui.activity.ExampleActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ExampleModule {
    @Binds abstract Context context(ExampleActivity activity);
    @Binds abstract ExampleViewContract viewContract(ExampleActivity activity);
}
