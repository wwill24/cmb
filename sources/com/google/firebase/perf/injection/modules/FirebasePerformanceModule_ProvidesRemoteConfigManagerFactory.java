package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.RemoteConfigManager;
import fj.d;
import fj.g;

public final class FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory implements d<RemoteConfigManager> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(firebasePerformanceModule);
    }

    public static RemoteConfigManager providesRemoteConfigManager(FirebasePerformanceModule firebasePerformanceModule) {
        return (RemoteConfigManager) g.c(firebasePerformanceModule.providesRemoteConfigManager(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public RemoteConfigManager get() {
        return providesRemoteConfigManager(this.module);
    }
}
