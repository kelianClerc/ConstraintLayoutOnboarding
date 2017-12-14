package com.fabernovel.constraintanimations.di.common;

import com.fabernovel.constraintanimations.di.crashes.CrashesComponent;
import com.fabernovel.constraintanimations.di.crashes.CrashesModule;
import com.fabernovel.constraintanimations.di.logging.LoggingComponent;
import com.fabernovel.constraintanimations.di.logging.LoggingModule;
import com.fabernovel.constraintanimations.di.threading.ThreadingComponent;
import com.fabernovel.constraintanimations.di.threading.ThreadingModule;
import com.fabernovel.constraintanimations.di.trace.TracerModule;
import com.fabernovel.constraintanimations.utils.logging.Logger;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
    LoggingModule.class,
    PreferencesModule.class,
    ServiceModule.class,
    TracerModule.class,
    RepositoryModule.class,
    AndroidInjectionModule.class,
    AndroidSupportInjectionModule.class,
    AndroidComponentsModule.class
})
public interface ApplicationComponent {
    Logger logger();

    LoggingComponent.Builder loggingComponentBuilder();
    CrashesComponent plus(CrashesModule module);
    ThreadingComponent plus(ThreadingModule module);
}
