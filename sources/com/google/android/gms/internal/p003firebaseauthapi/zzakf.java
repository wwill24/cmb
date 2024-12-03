package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakf  reason: invalid package */
final class zzakf implements zzaln {
    private static final zzakf zza = new zzakf();

    private zzakf() {
    }

    public static zzakf zza() {
        return zza;
    }

    public final zzalm zzb(Class cls) {
        Class<zzakk> cls2 = zzakk.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzalm) zzakk.zzv(cls.asSubclass(cls2)).zzj(3, (Object) null, (Object) null);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzakk.class.isAssignableFrom(cls);
    }
}
