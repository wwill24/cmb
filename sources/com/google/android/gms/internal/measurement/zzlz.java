package com.google.android.gms.internal.measurement;

final class zzlz implements zzmg {
    private final zzmg[] zza;

    zzlz(zzmg... zzmgArr) {
        this.zza = zzmgArr;
    }

    public final zzmf zzb(Class cls) {
        zzmg[] zzmgArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            zzmg zzmg = zzmgArr[i10];
            if (zzmg.zzc(cls)) {
                return zzmg.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzmg[] zzmgArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            if (zzmgArr[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
