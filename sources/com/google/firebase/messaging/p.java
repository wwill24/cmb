package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f21131a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21132b;

    public /* synthetic */ p(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f21131a = firebaseMessaging;
        this.f21132b = taskCompletionSource;
    }

    public final void run() {
        this.f21131a.lambda$deleteToken$5(this.f21132b);
    }
}
