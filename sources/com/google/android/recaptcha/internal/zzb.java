package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlinx.coroutines.p0;

public final class zzb {
    public static final Task zza(p0 p0Var) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(new CancellationTokenSource().getToken());
        p0Var.y(new zza(taskCompletionSource, p0Var));
        return taskCompletionSource.getTask();
    }
}
