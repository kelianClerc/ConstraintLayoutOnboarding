package com.fabernovel.constraintanimations.di.main;

import com.fabernovel.constraintanimations.app.main.ui.MainViewContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private final MainViewContract viewContract;

    public MainModule(MainViewContract viewContract) {
        this.viewContract = viewContract;
    }

    @Provides
    MainViewContract viewContract() {
        return viewContract;
    }
}
