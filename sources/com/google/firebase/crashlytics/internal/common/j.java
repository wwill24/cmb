package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class j implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21018a;

    public /* synthetic */ j(TaskCompletionSource taskCompletionSource) {
        this.f21018a = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Utils.lambda$race$1(this.f21018a, task);
    }
}
