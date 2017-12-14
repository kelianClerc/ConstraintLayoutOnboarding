package com.fabernovel.constraintanimations.core.error.exceptions;

import android.support.annotation.Nullable;

import com.fabernovel.constraintanimations.core.error.Errors;
import com.fabernovel.constraintanimations.core.error.ConstraintAnimationsException;

public class ServerClientException extends ConstraintAnimationsException {

    private final String message;

    public ServerClientException(@Nullable String message) {
        this.message = message;
    }

    public String getServerMessage() {
        return message;
    }

    @Override public int getId() {
        return Errors.SERVER_CLIENT;
    }
}
