package com.fabernovel.constraintanimations.data.net.common;

import com.fabernovel.constraintanimations.data.net.retrofit.model.RestError;

public interface ServiceErrorHandler {
    void handleClientError(int code, RestError error);
}
