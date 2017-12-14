package com.fabernovel.constraintanimations.di.common;

import android.app.Activity;

import com.fabernovel.constraintanimations.app.example.ui.activity.ExampleActivity;
import com.fabernovel.constraintanimations.di.PerActivity;
import com.fabernovel.constraintanimations.di.example.ExampleSubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@PerActivity
@Module(subcomponents = {ExampleSubcomponent.class})
public abstract class AndroidComponentsModule {

    @Binds
    @IntoMap
    @ActivityKey(ExampleActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
        bindExampleInjectorFactory(ExampleSubcomponent.Builder builder);
}
