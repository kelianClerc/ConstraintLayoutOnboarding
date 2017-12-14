package com.fabernovel.constraintanimations.di.logging;

import com.fabernovel.constraintanimations.BuildConfig;
import com.fabernovel.constraintanimations.Settings;
import com.fabernovel.constraintanimations.utils.logging.Logger;
import com.fabernovel.constraintanimations.utils.logging.NoOpLogger;
import com.fabernovel.constraintanimations.utils.logging.TimberLogger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoggingModule {

    protected static final boolean SHOW_HASH = Settings.logging.show_hashs;
    protected static final boolean ENABLED = Settings.logging.enabled;

    @Provides @Singleton
    Logger provideLogger() {
        return getLogger();
    }

    protected Logger getLogger() {
        if (BuildConfig.DEBUG && ENABLED) {
            return new TimberLogger(SHOW_HASH);
        }
        return new NoOpLogger();
    }
}
