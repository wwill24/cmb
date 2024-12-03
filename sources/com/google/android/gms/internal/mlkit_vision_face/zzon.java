package com.google.android.gms.internal.mlkit_vision_face;

public final class zzon {
    private static zzom zza;

    public static synchronized zzoc zza(zznt zznt) {
        zzoc zzoc;
        synchronized (zzon.class) {
            if (zza == null) {
                zza = new zzom((zzol) null);
            }
            zzoc = (zzoc) zza.get(zznt);
        }
        return zzoc;
    }

    public static synchronized zzoc zzb(String str) {
        zzoc zza2;
        synchronized (zzon.class) {
            zza2 = zza(zznt.zzd(str).zzd());
        }
        return zza2;
    }
}
