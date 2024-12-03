package com.google.android.gms.internal.play_billing;

final class zzbq {
    private static final zzbo zza = new zzbp();
    private static final zzbo zzb;

    static {
        zzbo zzbo;
        try {
            zzbo = (zzbo) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzbo = null;
        }
        zzb = zzbo;
    }

    static zzbo zza() {
        zzbo zzbo = zzb;
        if (zzbo != null) {
            return zzbo;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzbo zzb() {
        return zza;
    }
}
