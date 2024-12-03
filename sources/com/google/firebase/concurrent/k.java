package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class k implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f20986a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f20987b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f20988c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f20989d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f20990e;

    public /* synthetic */ k(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        this.f20986a = delegatingScheduledExecutorService;
        this.f20987b = runnable;
        this.f20988c = j10;
        this.f20989d = j11;
        this.f20990e = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f20986a.lambda$scheduleAtFixedRate$8(this.f20987b, this.f20988c, this.f20989d, this.f20990e, completer);
    }
}
