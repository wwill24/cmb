package com.google.android.gms.internal.location;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzcg implements OnCompleteListener {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzcg(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        TaskCompletionSource taskCompletionSource = this.zza;
        int i10 = zzda.zze;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            exception.getClass();
            taskCompletionSource.trySetException(exception);
        }
    }
}
