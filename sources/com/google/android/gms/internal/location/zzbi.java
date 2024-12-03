package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.a;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbi implements Continuation {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzbi(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final Object then(Task task) {
        TaskCompletionSource taskCompletionSource = this.zza;
        a aVar = zzbp.zzb;
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult((Location) task.getResult());
            return null;
        }
        Exception exception = task.getException();
        exception.getClass();
        taskCompletionSource.trySetException(exception);
        return null;
    }
}
