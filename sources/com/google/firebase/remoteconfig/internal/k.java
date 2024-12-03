package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class k implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigRealtimeHttpClient f21221a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Task f21222b;

    public /* synthetic */ k(ConfigRealtimeHttpClient configRealtimeHttpClient, Task task) {
        this.f21221a = configRealtimeHttpClient;
        this.f21222b = task;
    }

    public final Object then(Task task) {
        return this.f21221a.lambda$beginRealtimeHttpStream$1(this.f21222b, task);
    }
}
