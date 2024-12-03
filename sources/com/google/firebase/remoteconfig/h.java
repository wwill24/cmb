package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class h implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f21192a;

    public /* synthetic */ h(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f21192a = firebaseRemoteConfig;
    }

    public final Task then(Object obj) {
        return this.f21192a.lambda$fetchAndActivate$1((Void) obj);
    }
}
