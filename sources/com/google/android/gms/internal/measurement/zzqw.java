package com.google.android.gms.internal.measurement;

public final class zzqw implements zzqv {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;
    public static final zzib zzd;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.collection.enable_session_stitching_token.client.dev", true);
        zzb = zza2.zzf("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        zzc = zza2.zzf("measurement.session_stitching_token_enabled", false);
        zzd = zza2.zzf("measurement.link_sst_to_sid", true);
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

    public final boolean zzd() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    public final boolean zze() {
        return ((Boolean) zzd.zzb()).booleanValue();
    }
}
