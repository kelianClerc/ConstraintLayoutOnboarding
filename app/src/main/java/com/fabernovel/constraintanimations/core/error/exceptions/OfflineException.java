package com.fabernovel.constraintanimations.core.error.exceptions;

import com.fabernovel.constraintanimations.core.error.Errors;
import com.fabernovel.constraintanimations.core.error.ConstraintAnimationsException;

public class OfflineException extends ConstraintAnimationsException {
    @Override public int getId() {
        return Errors.OFFLINE;
    }
}
