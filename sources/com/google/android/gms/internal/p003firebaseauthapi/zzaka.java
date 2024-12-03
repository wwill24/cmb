package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaka  reason: invalid package */
final class zzaka {
    private static final zzajy zza = new zzajz();
    private static final zzajy zzb;

    static {
        zzajy zzajy;
        try {
            zzajy = (zzajy) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzajy = null;
        }
        zzb = zzajy;
    }

    static zzajy zza() {
        zzajy zzajy = zzb;
        if (zzajy != null) {
            return zzajy;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzajy zzb() {
        return zza;
    }
}
