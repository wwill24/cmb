package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class a implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigAutoFetch f21194a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Task f21195b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Task f21196c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f21197d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f21198e;

    public /* synthetic */ a(ConfigAutoFetch configAutoFetch, Task task, Task task2, long j10, int i10) {
        this.f21194a = configAutoFetch;
        this.f21195b = task;
        this.f21196c = task2;
        this.f21197d = j10;
        this.f21198e = i10;
    }

    public final Object then(Task task) {
        return this.f21194a.lambda$fetchLatestConfig$0(this.f21195b, this.f21196c, this.f21197d, this.f21198e, task);
    }
}
