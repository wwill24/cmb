package com.google.android.gms.internal.measurement;

public final class zzqb implements zzqa {
    public static final zzib zza;
    public static final zzib zzb;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.collection.client.log_target_api_version", true);
        zzb = zza2.zzf("measurement.collection.service.log_target_api_version", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    public final boolean zzc() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }
}
