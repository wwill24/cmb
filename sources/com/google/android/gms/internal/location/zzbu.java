package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.j;

abstract class zzbu extends d {
    public zzbu(com.google.android.gms.common.api.d dVar) {
        super((a<?>) zzbp.zzb, dVar);
    }

    public final /* bridge */ /* synthetic */ j createFailedResult(Status status) {
        return status;
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((j) obj);
    }
}
