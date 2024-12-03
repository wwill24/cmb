package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class d implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f21105a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f21106b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f21107c;

    public /* synthetic */ d(Context context, Intent intent, boolean z10) {
        this.f21105a = context;
        this.f21106b = intent;
        this.f21107c = z10;
    }

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$2(this.f21105a, this.f21106b, this.f21107c, task);
    }
}
