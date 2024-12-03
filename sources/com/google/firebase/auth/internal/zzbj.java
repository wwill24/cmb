package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzbj implements Continuation {
    public final /* synthetic */ zzbl zza;

    public /* synthetic */ zzbj(zzbl zzbl) {
        this.zza = zzbl;
    }

    public final Object then(Task task) {
        zzbl zzbl = this.zza;
        if (task.isSuccessful()) {
            return zzbl.zza((String) task.getResult());
        }
        String message = ((Exception) p.k(task.getException())).getMessage();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to get Recaptcha token, error - ");
        sb2.append(message);
        sb2.append("\n\n Failing open with a fake token.");
        return zzbl.zza("NO_RECAPTCHA");
    }
}
