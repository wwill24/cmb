package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class h implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f20974a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f20975b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f20976c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f20977d;

    public /* synthetic */ h(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j10, TimeUnit timeUnit) {
        this.f20974a = delegatingScheduledExecutorService;
        this.f20975b = runnable;
        this.f20976c = j10;
        this.f20977d = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f20974a.lambda$schedule$2(this.f20975b, this.f20976c, this.f20977d, completer);
    }
}
