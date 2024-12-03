package com.google.firebase.perf.injection.modules;

import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import fj.d;
import fj.g;

public final class FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory implements d<Provider<RemoteConfigComponent>> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(firebasePerformanceModule);
    }

    public static Provider<RemoteConfigComponent> providesRemoteConfigComponent(FirebasePerformanceModule firebasePerformanceModule) {
        return (Provider) g.c(firebasePerformanceModule.providesRemoteConfigComponent(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Provider<RemoteConfigComponent> get() {
        return providesRemoteConfigComponent(this.module);
    }
}
