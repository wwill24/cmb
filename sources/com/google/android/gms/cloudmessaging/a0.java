package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f38429a;

    public /* synthetic */ a0(TaskCompletionSource taskCompletionSource) {
        this.f38429a = taskCompletionSource;
    }

    public final void run() {
        this.f38429a.trySetException(new IOException("TIMEOUT"));
    }
}
