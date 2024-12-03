package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Date;
import java.util.Map;

public final /* synthetic */ class g implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigFetchHandler f21209a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Task f21210b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Task f21211c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Date f21212d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Map f21213e;

    public /* synthetic */ g(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date, Map map) {
        this.f21209a = configFetchHandler;
        this.f21210b = task;
        this.f21211c = task2;
        this.f21212d = date;
        this.f21213e = map;
    }

    public final Object then(Task task) {
        return this.f21209a.lambda$fetchIfCacheExpiredAndNotThrottled$2(this.f21210b, this.f21211c, this.f21212d, this.f21213e, task);
    }
}
