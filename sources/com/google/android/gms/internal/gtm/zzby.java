package com.google.android.gms.internal.gtm;

import rd.u;

final class zzby extends zzcw {
    final /* synthetic */ zzcc zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzby(zzcc zzcc, zzbv zzbv) {
        super(zzbv);
        this.zza = zzcc;
    }

    public final void zza() {
        zzcc zzcc = this.zza;
        u.h();
        if (zzcc.zzg()) {
            zzcc.zzO("Inactivity, disconnecting from device AnalyticsService");
            zzcc.zzc();
        }
    }
}
