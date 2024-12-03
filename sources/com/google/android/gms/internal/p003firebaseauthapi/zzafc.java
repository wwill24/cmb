package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafc  reason: invalid package */
public class zzafc {
    zzady zza;
    Executor zzb;

    public final Task zzU(zzafb zzafb) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new zzafa(this, zzafb, taskCompletionSource));
        return taskCompletionSource.getTask();
    }
}
