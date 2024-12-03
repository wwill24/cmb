package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class i implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f21193a;

    public /* synthetic */ i(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f21193a = firebaseRemoteConfig;
    }

    public final Object then(Task task) {
        return Boolean.valueOf(this.f21193a.processActivatePutTask(task));
    }
}
