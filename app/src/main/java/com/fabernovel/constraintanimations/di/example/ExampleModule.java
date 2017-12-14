package com.fabernovel.constraintanimations.di.example;

import android.content.Context;

import com.fabernovel.constraintanimations.app.main.ui.MainViewContract;
import com.fabernovel.constraintanimations.app.main.ui.activity.MainActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ExampleModule {
    @Binds abstract Context context(MainActivity activity);
    @Binds abstract MainViewContract viewContract(MainActivity activity);
}
