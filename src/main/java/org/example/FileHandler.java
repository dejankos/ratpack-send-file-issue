package org.example;

import io.netty.handler.codec.http.HttpHeaderNames;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler implements Handler {

    private static final Path NON_EXISTING_FILE = Paths.get(System.getProperty("java.io.tmpdir") + System.currentTimeMillis() + ".txt");

    @Override
    public void handle(Context ctx) {
        ctx.getResponse().noCompress();
        ctx.getResponse().getHeaders().set(HttpHeaderNames.CONTENT_LENGTH, 42);
        ctx.getResponse().sendFile(NON_EXISTING_FILE);
    }
}
