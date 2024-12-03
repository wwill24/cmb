package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

public final /* synthetic */ class x implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executor f21464a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f21465b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CancellationTokenSource f21466c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21467d;

    public /* synthetic */ x(Executor executor, CancellationToken cancellationToken, CancellationTokenSource cancellationTokenSource, TaskCompletionSource taskCompletionSource) {
        this.f21464a = executor;
        this.f21465b = cancellationToken;
        this.f21466c = cancellationTokenSource;
        this.f21467d = taskCompletionSource;
    }

    public final void execute(Runnable runnable) {
        Executor executor = this.f21464a;
        CancellationToken cancellationToken = this.f21465b;
        CancellationTokenSource cancellationTokenSource = this.f21466c;
        TaskCompletionSource taskCompletionSource = this.f21467d;
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            if (cancellationToken.isCancellationRequested()) {
                cancellationTokenSource.cancel();
            } else {
                taskCompletionSource.setException(e10);
            }
            throw e10;
        }
    }
}
