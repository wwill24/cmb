package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f21462a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21463b;

    public /* synthetic */ w(k kVar, TaskCompletionSource taskCompletionSource) {
        this.f21462a = kVar;
        this.f21463b = taskCompletionSource;
    }

    public final void run() {
        this.f21462a.h(this.f21463b);
    }
}
