package com.google.mlkit.common.sdkinternal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_common.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class g {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f21401b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static g f21402c;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Handler f21403a;

    private g(Looper looper) {
        this.f21403a = new zza(looper);
    }

    @NonNull
    public static g a() {
        g gVar;
        synchronized (f21401b) {
            if (f21402c == null) {
                HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                handlerThread.start();
                f21402c = new g(handlerThread.getLooper());
            }
            gVar = f21402c;
        }
        return gVar;
    }

    @NonNull
    public static Executor d() {
        return zzh.INSTANCE;
    }

    @NonNull
    public <ResultT> Task<ResultT> b(@NonNull Callable<ResultT> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        c(new s(callable, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public void c(@NonNull Runnable runnable) {
        d().execute(runnable);
    }
}
