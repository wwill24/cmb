package com.facebook.bolts;

import com.facebook.bolts.Task;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37804a;

    public /* synthetic */ k(TaskCompletionSource taskCompletionSource) {
        this.f37804a = taskCompletionSource;
    }

    public final void run() {
        Task.Companion.m97delay$lambda0(this.f37804a);
    }
}
