package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f21092a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f21093b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21094c;

    public /* synthetic */ a(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.f21092a = enhancedIntentService;
        this.f21093b = intent;
        this.f21094c = taskCompletionSource;
    }

    public final void run() {
        this.f21092a.lambda$processIntent$0(this.f21093b, this.f21094c);
    }
}
