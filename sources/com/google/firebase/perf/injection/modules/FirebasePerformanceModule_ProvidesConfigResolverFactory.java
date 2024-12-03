package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.ConfigResolver;
import fj.d;
import fj.g;

public final class FirebasePerformanceModule_ProvidesConfigResolverFactory implements d<ConfigResolver> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesConfigResolverFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesConfigResolverFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesConfigResolverFactory(firebasePerformanceModule);
    }

    public static ConfigResolver providesConfigResolver(FirebasePerformanceModule firebasePerformanceModule) {
        return (ConfigResolver) g.c(firebasePerformanceModule.providesConfigResolver(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public ConfigResolver get() {
        return providesConfigResolver(this.module);
    }
}
