package com.google.android.gms.internal.mlkit_common;

import android.content.Context;

public final class zzi {
    public static final zzi zza;
    public static final zzi zzb;
    public static final zzi zzc;
    /* access modifiers changed from: private */
    public final boolean zzd;
    /* access modifiers changed from: private */
    public final boolean zze = false;
    private final zzar zzf;

    static {
        zzg zzg = new zzg((zzf) null);
        zzg.zzb();
        zza = zzg.zzd();
        zzg zzg2 = new zzg((zzf) null);
        zzg2.zzb();
        zzg2.zza(new zze());
        zzb = zzg2.zzd();
        zzg zzg3 = new zzg((zzf) null);
        zzg3.zzc();
        zzc = zzg3.zzd();
    }

    /* synthetic */ zzi(boolean z10, boolean z11, zzar zzar, zzh zzh) {
        this.zzd = z10;
        this.zzf = zzar;
    }

    static /* bridge */ /* synthetic */ int zzc(zzi zzi, Context context, zzr zzr) {
        zzar zzar = zzi.zzf;
        int size = zzar.size();
        int i10 = 0;
        while (i10 < size) {
            int zza2 = ((zzs) zzar.get(i10)).zza(context, zzr, zzi.zzd) - 1;
            i10++;
            if (zza2 == 1) {
                return 2;
            }
        }
        return 3;
    }
}
