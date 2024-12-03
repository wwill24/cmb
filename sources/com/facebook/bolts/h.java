package com.facebook.bolts;

import com.facebook.bolts.Task;
import java.util.concurrent.Callable;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f37793a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37794b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callable f37795c;

    public /* synthetic */ h(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Callable callable) {
        this.f37793a = cancellationToken;
        this.f37794b = taskCompletionSource;
        this.f37795c = callable;
    }

    public final void run() {
        Task.Companion.m93call$lambda2(this.f37793a, this.f37794b, this.f37795c);
    }
}
