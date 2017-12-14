package com.fabernovel.constraintanimations.data.net.common;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ConnectivityInterceptor implements Interceptor {

    private final ConnectivityManager connectivityManager;

    @Inject ConnectivityInterceptor(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    @Override public Response intercept(Chain chain) throws IOException {
        if (isConnected()) {
            return chain.proceed(chain.request());
        }
        throw new OfflineIOException();
    }

    private boolean isConnected() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}

