package com.fabernovel.constraintanimations.data;

import android.support.annotation.StringRes;

import com.fabernovel.constraintanimations.R;
import com.fabernovel.constraintanimations.core.boundary.ExampleRepository;
import com.fabernovel.constraintanimations.utils.trace.Trace;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExampleRepositoryImpl implements ExampleRepository {

    @Inject ExampleRepositoryImpl( ) {}

    @Override @StringRes @Trace
    public int getExampleMessage() {
        return R.string.read_me;
    }
}
