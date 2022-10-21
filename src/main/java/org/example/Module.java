package org.example;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import ratpack.error.ServerErrorHandler;

public class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(FileHandler.class).in(Scopes.SINGLETON);
        bind(ServerErrorHandler.class).to(GlobalErrorHandler.class);
    }
}
