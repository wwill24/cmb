package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f21468a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f21469b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CancellationTokenSource f21470c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Callable f21471d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21472e;

    public /* synthetic */ y(k kVar, CancellationToken cancellationToken, CancellationTokenSource cancellationTokenSource, Callable callable, TaskCompletionSource taskCompletionSource) {
        this.f21468a = kVar;
        this.f21469b = cancellationToken;
        this.f21470c = cancellationTokenSource;
        this.f21471d = callable;
        this.f21472e = taskCompletionSource;
    }

    public final void run() {
        this.f21468a.g(this.f21469b, this.f21470c, this.f21471d, this.f21472e);
    }
}
