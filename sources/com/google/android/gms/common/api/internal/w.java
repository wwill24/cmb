package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.tasks.TaskCompletionSource;

public class w {
    public static void a(@NonNull Status status, @NonNull TaskCompletionSource<Void> taskCompletionSource) {
        b(status, (Object) null, taskCompletionSource);
    }

    public static <ResultT> void b(@NonNull Status status, ResultT resultt, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.i0()) {
            taskCompletionSource.setResult(resultt);
        } else {
            taskCompletionSource.setException(b.a(status));
        }
    }

    public static <ResultT> boolean c(@NonNull Status status, ResultT resultt, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.i0()) {
            return taskCompletionSource.trySetResult(resultt);
        }
        return taskCompletionSource.trySetException(b.a(status));
    }
}
