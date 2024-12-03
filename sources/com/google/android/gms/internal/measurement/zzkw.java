package com.google.android.gms.internal.measurement;

final class zzkw implements zzmg {
    private static final zzkw zza = new zzkw();

    private zzkw() {
    }

    public static zzkw zza() {
        return zza;
    }

    public final zzmf zzb(Class cls) {
        Class<zzlb> cls2 = zzlb.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzmf) zzlb.zzbC(cls.asSubclass(cls2)).zzl(3, (Object) null, (Object) null);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzlb.class.isAssignableFrom(cls);
    }
}
