package com.google.android.gms.internal.mlkit_vision_face;

public final class zzoo {
    private static zzoo zza;

    private zzoo() {
    }

    public static synchronized zzoo zza() {
        zzoo zzoo;
        synchronized (zzoo.class) {
            if (zza == null) {
                zza = new zzoo();
            }
            zzoo = zza;
        }
        return zzoo;
    }
}
