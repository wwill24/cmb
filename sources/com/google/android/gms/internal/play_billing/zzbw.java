package com.google.android.gms.internal.play_billing;

final class zzbw implements zzdd {
    private static final zzbw zza = new zzbw();

    private zzbw() {
    }

    public static zzbw zza() {
        return zza;
    }

    public final zzdc zzb(Class cls) {
        Class<zzcb> cls2 = zzcb.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzdc) zzcb.zzg(cls.asSubclass(cls2)).zzt(3, (Object) null, (Object) null);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzcb.class.isAssignableFrom(cls);
    }
}
