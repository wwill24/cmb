package com.facebook.bolts;

import com.facebook.bolts.Task;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class g implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f37791a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37792b;

    public /* synthetic */ g(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource) {
        this.f37791a = atomicBoolean;
        this.f37792b = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Task.Companion.m100whenAnyResult$lambda3(this.f37791a, this.f37792b, task);
    }
}
