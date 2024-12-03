package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;

public final /* synthetic */ class f implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigFetchHandler f21206a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f21207b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f21208c;

    public /* synthetic */ f(ConfigFetchHandler configFetchHandler, long j10, Map map) {
        this.f21206a = configFetchHandler;
        this.f21207b = j10;
        this.f21208c = map;
    }

    public final Object then(Task task) {
        return this.f21206a.lambda$fetch$0(this.f21207b, this.f21208c, task);
    }
}
