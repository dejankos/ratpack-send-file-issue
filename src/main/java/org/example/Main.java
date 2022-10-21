package org.example;

import ratpack.guice.Guice;
import ratpack.server.RatpackServer;

public class Main {

    public static void main(String[] args) throws Exception {
        RatpackServer.start(server -> server
            .registry(Guice.registry(b -> b.module(Module.class)))
            .serverConfig(c -> c.port(8080))
            .handlers(chain ->
                chain.path("file", FileHandler.class)
            )
        );
    }
}
