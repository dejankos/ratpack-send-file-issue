package org.example;

import io.netty.handler.codec.http.HttpResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.error.ServerErrorHandler;
import ratpack.handling.Context;

public class GlobalErrorHandler implements ServerErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalErrorHandler.class);


    @Override
    public void error(Context context, Throwable throwable) {
        LOGGER.error("global handler error", throwable);
        context.getResponse().status(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()).send();
    }
}
