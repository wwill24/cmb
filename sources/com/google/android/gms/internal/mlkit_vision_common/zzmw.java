package com.google.android.gms.internal.mlkit_vision_common;

public final class zzmw {
    private static zzmw zza;

    private zzmw() {
    }

    public static synchronized zzmw zza() {
        zzmw zzmw;
        synchronized (zzmw.class) {
            if (zza == null) {
                zza = new zzmw();
            }
            zzmw = zza;
        }
        return zzmw;
    }

    public static final boolean zzb() {
        return zzmv.zza("mlkit-dev-profiling");
    }
}
