package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f21133a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21134b;

    public /* synthetic */ q(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f21133a = firebaseMessaging;
        this.f21134b = taskCompletionSource;
    }

    public final void run() {
        this.f21133a.lambda$deleteToken$6(this.f21134b);
    }
}
