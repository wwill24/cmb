package com.google.firebase.perf.injection.modules;

import com.google.firebase.installations.FirebaseInstallationsApi;
import fj.d;
import fj.g;

public final class FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory implements d<FirebaseInstallationsApi> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(firebasePerformanceModule);
    }

    public static FirebaseInstallationsApi providesFirebaseInstallations(FirebasePerformanceModule firebasePerformanceModule) {
        return (FirebaseInstallationsApi) g.c(firebasePerformanceModule.providesFirebaseInstallations(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public FirebaseInstallationsApi get() {
        return providesFirebaseInstallations(this.module);
    }
}
