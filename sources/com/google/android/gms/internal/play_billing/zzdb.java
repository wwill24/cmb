package com.google.android.gms.internal.play_billing;

final class zzdb {
    private static final zzda zza;
    private static final zzda zzb = new zzda();

    static {
        zzda zzda;
        try {
            zzda = (zzda) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzda = null;
        }
        zza = zzda;
    }

    static zzda zza() {
        return zza;
    }

    static zzda zzb() {
        return zzb;
    }
}
