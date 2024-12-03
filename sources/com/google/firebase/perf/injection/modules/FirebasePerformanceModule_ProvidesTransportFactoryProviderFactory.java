package com.google.firebase.perf.injection.modules;

import cd.f;
import com.google.firebase.inject.Provider;
import fj.d;
import fj.g;

public final class FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory implements d<Provider<f>> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(firebasePerformanceModule);
    }

    public static Provider<f> providesTransportFactoryProvider(FirebasePerformanceModule firebasePerformanceModule) {
        return (Provider) g.c(firebasePerformanceModule.providesTransportFactoryProvider(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Provider<f> get() {
        return providesTransportFactoryProvider(this.module);
    }
}
