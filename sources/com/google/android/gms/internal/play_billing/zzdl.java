package com.google.android.gms.internal.play_billing;

final class zzdl {
    private static final zzdk zza;
    private static final zzdk zzb = new zzdk();

    static {
        zzdk zzdk;
        try {
            zzdk = (zzdk) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzdk = null;
        }
        zza = zzdk;
    }

    static zzdk zza() {
        return zza;
    }

    static zzdk zzb() {
        return zzb;
    }
}
