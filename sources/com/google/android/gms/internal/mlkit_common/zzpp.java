package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

public abstract class zzpp {
    public static zzpo zzh() {
        zzpb zzpb = new zzpb();
        zzpb.zzg("NA");
        zzpb.zzf(false);
        zzpb.zze(false);
        zzpb.zzd(ModelType.UNKNOWN);
        zzpb.zzb(zzlc.NO_ERROR);
        zzpb.zza(zzli.UNKNOWN_STATUS);
        zzpb.zzc(0);
        return zzpb;
    }

    public abstract int zza();

    public abstract ModelType zzb();

    public abstract zzlc zzc();

    public abstract zzli zzd();

    public abstract String zze();

    public abstract boolean zzf();

    public abstract boolean zzg();
}
