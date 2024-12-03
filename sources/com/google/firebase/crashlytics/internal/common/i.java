package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class i implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f21017a;

    public /* synthetic */ i(CountDownLatch countDownLatch) {
        this.f21017a = countDownLatch;
    }

    public final Object then(Task task) {
        return this.f21017a.countDown();
    }
}
