package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f21188a;

    public /* synthetic */ e(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f21188a = firebaseRemoteConfig;
    }

    public final Object call() {
        return this.f21188a.getInfo();
    }
}
