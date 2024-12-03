package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzod implements OnFailureListener {
    public final /* synthetic */ zzoe zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzod(zzoe zzoe, long j10) {
        this.zza = zzoe;
        this.zzb = j10;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzb(this.zzb, exc);
    }
}
