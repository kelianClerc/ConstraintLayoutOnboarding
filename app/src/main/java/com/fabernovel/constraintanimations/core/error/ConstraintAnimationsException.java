package com.fabernovel.constraintanimations.core.error;

public abstract class ConstraintAnimationsException extends Exception {
    public ConstraintAnimationsException() {
    }

    public ConstraintAnimationsException(String message) {
        super(message);
    }

    public abstract int getId();
}
