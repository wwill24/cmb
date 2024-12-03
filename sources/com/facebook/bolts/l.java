package com.facebook.bolts;

import com.facebook.bolts.Task;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f37805a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37806b;

    public /* synthetic */ l(ScheduledFuture scheduledFuture, TaskCompletionSource taskCompletionSource) {
        this.f37805a = scheduledFuture;
        this.f37806b = taskCompletionSource;
    }

    public final void run() {
        Task.Companion.m98delay$lambda1(this.f37805a, this.f37806b);
    }
}
