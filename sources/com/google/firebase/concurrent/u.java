package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

public final /* synthetic */ class u implements Provider {
    public final Object get() {
        return ExecutorsRegistrar.scheduled(Executors.newCachedThreadPool(ExecutorsRegistrar.factory("Firebase Blocking", 11)));
    }
}
