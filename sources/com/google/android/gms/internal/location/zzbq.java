package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzbq implements OnCompleteListener {
    public final /* synthetic */ e zza;

    public /* synthetic */ zzbq(e eVar) {
        this.zza = eVar;
    }

    public final void onComplete(Task task) {
        e eVar = this.zza;
        if (task.isSuccessful()) {
            eVar.setResult(Status.f38500g);
        } else if (task.isCanceled()) {
            eVar.setFailedResult(Status.f38504l);
        } else {
            Exception exception = task.getException();
            if (exception instanceof ApiException) {
                eVar.setFailedResult(((ApiException) exception).getStatus());
            } else {
                eVar.setFailedResult(Status.f38502j);
            }
        }
    }
}
