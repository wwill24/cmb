package com.google.android.gms.internal.mlkit_vision_barcode;

public final class zzrx {
    private static zzrx zza;

    private zzrx() {
    }

    public static synchronized zzrx zza() {
        zzrx zzrx;
        synchronized (zzrx.class) {
            if (zza == null) {
                zza = new zzrx();
            }
            zzrx = zza;
        }
        return zzrx;
    }
}
