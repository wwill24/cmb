package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.session.SessionManager;
import fj.d;
import fj.g;

public final class FirebasePerformanceModule_ProvidesSessionManagerFactory implements d<SessionManager> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesSessionManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesSessionManagerFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesSessionManagerFactory(firebasePerformanceModule);
    }

    public static SessionManager providesSessionManager(FirebasePerformanceModule firebasePerformanceModule) {
        return (SessionManager) g.c(firebasePerformanceModule.providesSessionManager(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public SessionManager get() {
        return providesSessionManager(this.module);
    }
}
