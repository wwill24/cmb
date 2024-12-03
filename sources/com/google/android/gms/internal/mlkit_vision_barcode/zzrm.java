package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzrm implements OnFailureListener {
    public final /* synthetic */ zzrn zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzrm(zzrn zzrn, long j10) {
        this.zza = zzrn;
        this.zzb = j10;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzb(this.zzb, exc);
    }
}
