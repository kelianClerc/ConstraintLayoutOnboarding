package com.fabernovel.constraintanimations.app.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.fabernovel.constraintanimations.utils.logging.Logger;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Inject protected Logger logger;
    private OnDrawnListener onDrawnListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logger.v(this, "onCreate(savedInstanceState: " + savedInstanceState + ")");
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        addTreeObserver();
    }

    private void addTreeObserver() {
        final View rootView = findViewById(android.R.id.content);
        if (onDrawnListener == null) {
            onDrawnListener = new OnDrawnListener();
        }
        onDrawnListener.install(rootView, getOnViewDrawnListener());
    }

    @NonNull
    private OnDrawnListener.OnViewDrawn getOnViewDrawnListener() {
        return new OnDrawnListener.OnViewDrawn() {
            @Override
            public void onViewDrawn() {
                BaseActivity.this.onViewDrawn();
            }
        };
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logger.v(this, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logger.v(this, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logger.v(this, "onResume()");
    }

    /**
     * Called when the view activity is actually drawn for the first time. Activity views sizes are
     * then correctly initialized.
     */
    protected void onViewDrawn() {
        logger.v(this, "onViewDrawn()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logger.v(this, "onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Does not log outState since child may update outState, resulting in false logging.
        logger.v(this, "onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logger.v(this, "onStop()");
    }
}
