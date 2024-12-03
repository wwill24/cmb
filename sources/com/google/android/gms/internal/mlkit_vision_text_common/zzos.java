package com.google.android.gms.internal.mlkit_vision_text_common;

public final class zzos {
    private static zzos zza;

    private zzos() {
    }

    public static synchronized zzos zza() {
        zzos zzos;
        synchronized (zzos.class) {
            if (zza == null) {
                zza = new zzos();
            }
            zzos = zza;
        }
        return zzos;
    }
}
