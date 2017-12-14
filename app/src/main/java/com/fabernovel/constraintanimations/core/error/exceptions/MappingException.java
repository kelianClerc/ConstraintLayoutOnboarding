package com.fabernovel.constraintanimations.core.error.exceptions;

import com.fabernovel.constraintanimations.core.error.ConstraintAnimationsException;
import com.fabernovel.constraintanimations.core.error.Errors;

public class MappingException extends ConstraintAnimationsException {

    public MappingException() {
        /* no-op */
    }

    public MappingException(String message) {
        super(message);
    }

    @Override public int getId() {
        return Errors.MAPPING;
    }
}
