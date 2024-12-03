package com.google.android.gms.internal.mlkit_vision_text_common;

public final class zzor {
    private static zzoq zza;

    public static synchronized zzog zza(zznx zznx) {
        zzog zzog;
        synchronized (zzor.class) {
            if (zza == null) {
                zza = new zzoq((zzop) null);
            }
            zzog = (zzog) zza.get(zznx);
        }
        return zzog;
    }

    public static synchronized zzog zzb(String str) {
        zzog zza2;
        synchronized (zzor.class) {
            zza2 = zza(zznx.zzd(str).zzd());
        }
        return zza2;
    }
}
