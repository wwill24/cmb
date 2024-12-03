package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class j implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f21226a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Task f21227b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Task f21228c;

    public /* synthetic */ j(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        this.f21226a = firebaseRemoteConfig;
        this.f21227b = task;
        this.f21228c = task2;
    }

    public final Object then(Task task) {
        return this.f21226a.lambda$activate$2(this.f21227b, this.f21228c, task);
    }
}
