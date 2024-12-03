package com.facebook.bolts;

import com.facebook.bolts.Task;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class m implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f37807a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37808b;

    public /* synthetic */ m(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource) {
        this.f37807a = atomicBoolean;
        this.f37808b = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Task.Companion.m99whenAny$lambda4(this.f37807a, this.f37808b, task);
    }
}
