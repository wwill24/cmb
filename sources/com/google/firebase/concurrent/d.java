package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f20964a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f20965b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f20966c;

    public /* synthetic */ d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.f20964a = delegatingScheduledExecutorService;
        this.f20965b = callable;
        this.f20966c = completer;
    }

    public final Object call() {
        return this.f20964a.lambda$schedule$4(this.f20965b, this.f20966c);
    }
}
