package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callable f21457a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21458b;

    public /* synthetic */ s(Callable callable, TaskCompletionSource taskCompletionSource) {
        this.f21457a = callable;
        this.f21458b = taskCompletionSource;
    }

    public final void run() {
        Callable callable = this.f21457a;
        TaskCompletionSource taskCompletionSource = this.f21458b;
        try {
            taskCompletionSource.setResult(callable.call());
        } catch (MlKitException e10) {
            taskCompletionSource.setException(e10);
        } catch (Exception e11) {
            taskCompletionSource.setException(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e11));
        }
    }
}
