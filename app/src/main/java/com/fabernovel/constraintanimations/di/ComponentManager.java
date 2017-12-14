package com.fabernovel.constraintanimations.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.fabernovel.constraintanimations.app.main.ui.MainViewContract;
import com.fabernovel.constraintanimations.app.onboarding.ui.OnboardingViewContract;
import com.fabernovel.constraintanimations.di.common.ApplicationComponent;
import com.fabernovel.constraintanimations.di.common.ContextModule;
import com.fabernovel.constraintanimations.di.common.DaggerApplicationComponent;
import com.fabernovel.constraintanimations.di.common.PreferencesModule;
import com.fabernovel.constraintanimations.di.common.RepositoryModule;
import com.fabernovel.constraintanimations.di.common.ServiceModule;
import com.fabernovel.constraintanimations.di.crashes.CrashesComponent;
import com.fabernovel.constraintanimations.di.crashes.CrashesModule;
import com.fabernovel.constraintanimations.di.logging.LoggingComponent;
import com.fabernovel.constraintanimations.di.logging.LoggingModule;
import com.fabernovel.constraintanimations.di.main.DaggerMainComponent;
import com.fabernovel.constraintanimations.di.main.MainComponent;
import com.fabernovel.constraintanimations.di.main.MainModule;
import com.fabernovel.constraintanimations.di.onboarding.DaggerOnboardingComponent;
import com.fabernovel.constraintanimations.di.onboarding.OnboardingComponent;
import com.fabernovel.constraintanimations.di.onboarding.OnboardingModule;
import com.fabernovel.constraintanimations.di.threading.ThreadingComponent;
import com.fabernovel.constraintanimations.di.threading.ThreadingModule;
import com.fabernovel.constraintanimations.di.trace.TracerModule;

import java.io.File;

public class ComponentManager {

    private static ApplicationComponent applicationComponent;
    private static LoggingComponent loggingComponent;
    private static ThreadingComponent threadingComponent;
    private static CrashesComponent crashesComponent;
    private static MainComponent mainComponent;

    public static void init(
        SharedPreferences preferences, File cacheDirectory, Context applicationContext
    ) {
        CrashesModule crashesModule = new CrashesModule();
        LoggingModule loggingModule = new LoggingModule();
        PreferencesModule preferencesModule = new PreferencesModule(preferences);
        ServiceModule serviceModule = new ServiceModule(cacheDirectory, applicationContext);
        TracerModule tracerModule = new TracerModule();
        RepositoryModule repositoryModule = new RepositoryModule();
        initApplicationComponent(
            loggingModule,
            preferencesModule,
            serviceModule,
            tracerModule,
            repositoryModule
        );
        initLoggingComponent();
        ThreadingModule threadingModule = new ThreadingModule();
        initThreadingComponent(threadingModule);
        initCrashesComponent(crashesModule);
    }

    public static ApplicationComponent getApplicationComponent() {
        return safeReturn(applicationComponent);
    }

    public static LoggingComponent getLoggingComponent() {
        return safeReturn(loggingComponent);
    }

    public static ThreadingComponent getThreadingComponent() {
        return safeReturn(threadingComponent);
    }

    public static CrashesComponent getCrashesComponent() {
        return safeReturn(crashesComponent);
    }

    private static void initApplicationComponent(
        LoggingModule loggingModule,
        PreferencesModule preferencesModule,
        ServiceModule serviceModule,
        TracerModule tracerModule,
        RepositoryModule repositoryModule
    ) {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .loggingModule(loggingModule)
            .tracerModule(tracerModule)
            .preferencesModule(preferencesModule)
            .serviceModule(serviceModule)
            .repositoryModule(repositoryModule)
            .build();
    }

    private static void initLoggingComponent() {
        loggingComponent = applicationComponent.loggingComponentBuilder().build();
    }

    private static void initThreadingComponent(ThreadingModule threadingModule) {
        threadingComponent = applicationComponent.plus(threadingModule);
    }

    private static void initCrashesComponent(CrashesModule crashesModule) {
        crashesComponent = applicationComponent.plus(crashesModule);
    }

    @NonNull
    private static <C> C safeReturn(C component) {
        if (component == null) {
            fail();
        }
        return component;
    }

    private static void fail() {
        String message = "ComponentManager.init() was not called on Application#onCreate()";
        throw new RuntimeException(message);
    }

    public static MainComponent getMainComponent(Context context, MainViewContract viewContract) {
        if (mainComponent == null) {
            ContextModule contextModule = new ContextModule(context);
            MainModule mainModule = new MainModule(viewContract);
            mainComponent = DaggerMainComponent
                .builder()
                .applicationComponent(getApplicationComponent())
                .contextModule(contextModule)
                .mainModule(mainModule)
                .build();
        }
        return mainComponent;
    }

    public static OnboardingComponent getOnboardingComponent(
        Context context, OnboardingViewContract viewContract
    ) {
        return DaggerOnboardingComponent
            .builder()
            .applicationComponent(getApplicationComponent())
            .onboardingModule(new OnboardingModule(viewContract))
            .contextModule(new ContextModule(context))
            .build();
    }
}
