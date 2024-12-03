package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.c;

final class zzbu implements c.a {
    final /* synthetic */ zzbv zza;

    zzbu(zzbv zzbv) {
        this.zza = zzbv;
    }

    public final void onBackgroundStateChanged(boolean z10) {
        if (z10) {
            this.zza.zzc = true;
            this.zza.zzc();
            return;
        }
        this.zza.zzc = false;
        if (this.zza.zzg()) {
            this.zza.zzb.zzc();
        }
    }
}
