package com.fabernovel.constraintanimations.app.common;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.fabernovel.constraintanimations.utils.logging.Logger;

import javax.inject.Inject;

import dagger.android.DaggerService;

public abstract class BaseService extends DaggerService {

    @Inject protected Logger logger;

    @Override
    public void onCreate() {
        super.onCreate();
        logger.v(this, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String s = "onStartCommand(intent: %s, flags: %s , startId: %s";
        logger.v(this, s, intent, flags, startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        logger.v(this, "onBind(intent: %s)", intent);
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        logger.v(this, "onUnbind(intent: %s)", intent);
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        logger.v(this, "onRebind(intent: %s)", intent);
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        logger.v(this, "onDestroy()");
        super.onDestroy();
    }
}
