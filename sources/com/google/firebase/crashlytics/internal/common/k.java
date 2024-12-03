package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callable f21019a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f21020b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21021c;

    public /* synthetic */ k(Callable callable, Executor executor, TaskCompletionSource taskCompletionSource) {
        this.f21019a = callable;
        this.f21020b = executor;
        this.f21021c = taskCompletionSource;
    }

    public final void run() {
        Utils.lambda$callTask$3(this.f21019a, this.f21020b, this.f21021c);
    }
}
