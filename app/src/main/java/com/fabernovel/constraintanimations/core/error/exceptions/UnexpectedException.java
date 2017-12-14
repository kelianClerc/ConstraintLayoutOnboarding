package com.fabernovel.constraintanimations.core.error.exceptions;

import com.fabernovel.constraintanimations.core.error.ConstraintAnimationsException;
import com.fabernovel.constraintanimations.core.error.Errors;

public class UnexpectedException extends ConstraintAnimationsException {
    @Override public int getId() {
        return Errors.GENERIC;
    }
}
