package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class p implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f20519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f20520b;

    public /* synthetic */ p(z zVar, TaskCompletionSource taskCompletionSource) {
        this.f20519a = zVar;
        this.f20520b = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.f20519a.q(this.f20520b, task);
    }
}
