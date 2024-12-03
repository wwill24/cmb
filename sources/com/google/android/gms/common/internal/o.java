package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.j;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final o0 f39033a = new l0();

    public interface a<R extends j, T> {
        T a(@NonNull R r10);
    }

    @NonNull
    public static <R extends j, T> Task<T> a(@NonNull f<R> fVar, @NonNull a<R, T> aVar) {
        o0 o0Var = f39033a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        fVar.addStatusListener(new m0(fVar, taskCompletionSource, aVar, o0Var));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public static <R extends j> Task<Void> b(@NonNull f<R> fVar) {
        return a(fVar, new n0());
    }
}
