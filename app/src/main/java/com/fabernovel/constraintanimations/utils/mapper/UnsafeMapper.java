package com.fabernovel.constraintanimations.utils.mapper;

import com.fabernovel.constraintanimations.core.error.exceptions.MappingException;

public interface UnsafeMapper<U, T> {
    T map(U toMap) throws MappingException;
}
