package com.fabernovel.constraintanimations.data.net.retrofit.model;

import android.support.annotation.Nullable;

import io.norberg.automatter.AutoMatter;

@AutoMatter
public interface RestError {
    @Nullable String error();
}
