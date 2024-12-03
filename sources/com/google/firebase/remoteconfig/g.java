package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f21190a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfigSettings f21191b;

    public /* synthetic */ g(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.f21190a = firebaseRemoteConfig;
        this.f21191b = firebaseRemoteConfigSettings;
    }

    public final Object call() {
        return this.f21190a.lambda$setConfigSettingsAsync$5(this.f21191b);
    }
}
