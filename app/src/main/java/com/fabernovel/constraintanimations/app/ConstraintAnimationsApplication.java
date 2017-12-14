package com.fabernovel.constraintanimations.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;

import com.fabernovel.constraintanimations.BuildConfig;
import com.fabernovel.constraintanimations.R;
import com.fabernovel.constraintanimations.Settings;
import com.fabernovel.constraintanimations.di.ComponentManager;
import com.fabernovel.constraintanimations.di.crashes.CrashesComponent;
import com.fabernovel.constraintanimations.utils.aspect.ThreadingAspect;
import com.fabernovel.constraintanimations.utils.aspect.TracerAspect;
import com.raizlabs.android.dbflow.config.FlowManager;

import net.danlew.android.joda.JodaTimeAndroid;
import net.hockeyapp.android.CrashManager;

import org.aspectj.lang.Aspects;

import java.io.File;

import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ConstraintAnimationsApplication extends Application {

    protected static final String DEFAULT_FONT = "fonts/GillSansMT.ttf";
    protected static final String PREFS_NAME = "ConstraintAnimations";

    protected static final boolean HOCKEY_APP_ENABLED = Settings.crashes.enabled;
    protected static final String HOCKEY_APP_KEY = Settings.crashes.app_id;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
        setupLogging();
        setupHockeyApp();
        setupDatabase();
        setupCalligraphy();
        setupAspects();
        setupJoda();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    private void setupJoda() {
        JodaTimeAndroid.init(this);
    }

    private void setupHockeyApp() {
        if (!HOCKEY_APP_ENABLED) {
            return;
        }
        CrashesComponent component = ComponentManager.getCrashesComponent();
        CrashManager.register(this, HOCKEY_APP_KEY, component.crashesListener());
        registerActivityLifecycleCallbacks(component.activityListener());
        registerComponentCallbacks(component.componentListener());
    }

    private void setupAspects() {
        ThreadingAspect threadingAspect = Aspects.aspectOf(ThreadingAspect.class);
        threadingAspect.init();
        TracerAspect loggerAspect = Aspects.aspectOf(TracerAspect.class);
        loggerAspect.init();
    }


    protected void setupGraph() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        File cacheDirectory = getCacheDir();
        ComponentManager.init(preferences, cacheDirectory, getApplicationContext());
    }

    private void setupDatabase() {
        FlowManager.init(this);
    }

    private void setupCalligraphy() {
        CalligraphyConfig config = new CalligraphyConfig.Builder()
            .setDefaultFontPath(DEFAULT_FONT)
            .setFontAttrId(R.attr.fontPath)
            .build();
        CalligraphyConfig.initDefault(config);
    }

    private void setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
