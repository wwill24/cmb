package com.google.android.gms.internal.mlkit_common;

public final class zzpy {
    private static zzpx zza;

    public static synchronized zzpn zza(zzph zzph) {
        zzpn zzpn;
        synchronized (zzpy.class) {
            if (zza == null) {
                zza = new zzpx((zzpw) null);
            }
            zzpn = (zzpn) zza.get(zzph);
        }
        return zzpn;
    }

    public static synchronized zzpn zzb(String str) {
        zzpn zza2;
        synchronized (zzpy.class) {
            zza2 = zza(zzph.zzd("common").zzd());
        }
        return zza2;
    }
}
