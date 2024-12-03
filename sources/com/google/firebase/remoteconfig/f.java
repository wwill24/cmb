package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class f implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Task f21189a;

    public /* synthetic */ f(Task task) {
        this.f21189a = task;
    }

    public final Object then(Task task) {
        return FirebaseRemoteConfig.lambda$ensureInitialized$0(this.f21189a, task);
    }
}
