package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class b implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f20958a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f20959b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f20960c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f20961d;

    public /* synthetic */ b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, long j10, TimeUnit timeUnit) {
        this.f20958a = delegatingScheduledExecutorService;
        this.f20959b = callable;
        this.f20960c = j10;
        this.f20961d = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f20958a.lambda$schedule$5(this.f20959b, this.f20960c, this.f20961d, completer);
    }
}
