package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzoh implements OnFailureListener {
    public final /* synthetic */ zzoi zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzoh(zzoi zzoi, long j10) {
        this.zza = zzoi;
        this.zzb = j10;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzb(this.zzb, exc);
    }
}
