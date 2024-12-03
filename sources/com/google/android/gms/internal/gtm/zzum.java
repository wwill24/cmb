package com.google.android.gms.internal.gtm;

final class zzum {
    private static final zzuk<?> zza = new zzul();
    private static final zzuk<?> zzb;

    static {
        zzuk<?> zzuk;
        try {
            zzuk = (zzuk) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzuk = null;
        }
        zzb = zzuk;
    }

    static zzuk<?> zza() {
        zzuk<?> zzuk = zzb;
        if (zzuk != null) {
            return zzuk;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzuk<?> zzb() {
        return zza;
    }
}
