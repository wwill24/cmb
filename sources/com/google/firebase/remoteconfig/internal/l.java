package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class l implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigRealtimeHttpClient f21223a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Task f21224b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Task f21225c;

    public /* synthetic */ l(ConfigRealtimeHttpClient configRealtimeHttpClient, Task task, Task task2) {
        this.f21223a = configRealtimeHttpClient;
        this.f21224b = task;
        this.f21225c = task2;
    }

    public final Object then(Task task) {
        return this.f21223a.lambda$createRealtimeConnection$0(this.f21224b, this.f21225c, task);
    }
}
