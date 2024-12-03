package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzaf implements e {
    private final TaskCompletionSource zza;

    public zzaf(TaskCompletionSource taskCompletionSource) {
        p.k(taskCompletionSource);
        this.zza = taskCompletionSource;
    }

    public final void setFailedResult(Status status) {
        if (status != null) {
            this.zza.setException(new ApiException(status));
        }
    }

    public final /* synthetic */ void setResult(Object obj) {
        w.b((Status) obj, null, this.zza);
    }
}
