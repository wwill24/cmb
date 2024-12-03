package com.google.firebase.database.core;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21068a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DataSnapshot f21069b;

    public /* synthetic */ d(TaskCompletionSource taskCompletionSource, DataSnapshot dataSnapshot) {
        this.f21068a = taskCompletionSource;
        this.f21069b = dataSnapshot;
    }

    public final void run() {
        this.f21068a.trySetResult(this.f21069b);
    }
}
