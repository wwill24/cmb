package com.google.android.gms.internal.gtm;

final class zzwg {
    private static final zzwf zza;
    private static final zzwf zzb = new zzwf();

    static {
        zzwf zzwf;
        try {
            zzwf = (zzwf) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzwf = null;
        }
        zza = zzwf;
    }

    static zzwf zza() {
        return zza;
    }

    static zzwf zzb() {
        return zzb;
    }
}
