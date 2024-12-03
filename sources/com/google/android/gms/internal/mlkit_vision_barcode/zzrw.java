package com.google.android.gms.internal.mlkit_vision_barcode;

public final class zzrw {
    private static zzrv zza;

    public static synchronized zzrl zza(zzrd zzrd) {
        zzrl zzrl;
        synchronized (zzrw.class) {
            if (zza == null) {
                zza = new zzrv((zzru) null);
            }
            zzrl = (zzrl) zza.get(zzrd);
        }
        return zzrl;
    }

    public static synchronized zzrl zzb(String str) {
        zzrl zza2;
        synchronized (zzrw.class) {
            zza2 = zza(zzrd.zzd(str).zzd());
        }
        return zza2;
    }
}
