package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f21095a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21096b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21097c;

    public /* synthetic */ a0(Context context, boolean z10, TaskCompletionSource taskCompletionSource) {
        this.f21095a = context;
        this.f21096b = z10;
        this.f21097c = taskCompletionSource;
    }

    public final void run() {
        ProxyNotificationInitializer.lambda$setEnableProxyNotification$0(this.f21095a, this.f21096b, this.f21097c);
    }
}
