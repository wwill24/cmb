package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Date;

public final /* synthetic */ class h implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigFetchHandler f21214a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Date f21215b;

    public /* synthetic */ h(ConfigFetchHandler configFetchHandler, Date date) {
        this.f21214a = configFetchHandler;
        this.f21215b = date;
    }

    public final Object then(Task task) {
        return this.f21214a.lambda$fetchIfCacheExpiredAndNotThrottled$3(this.f21215b, task);
    }
}
