package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class i implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f20978a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f20979b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f20980c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f20981d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f20982e;

    public /* synthetic */ i(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        this.f20978a = delegatingScheduledExecutorService;
        this.f20979b = runnable;
        this.f20980c = j10;
        this.f20981d = j11;
        this.f20982e = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f20978a.lambda$scheduleWithFixedDelay$11(this.f20979b, this.f20980c, this.f20981d, this.f20982e, completer);
    }
}
