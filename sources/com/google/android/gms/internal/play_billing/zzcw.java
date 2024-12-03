package com.google.android.gms.internal.play_billing;

final class zzcw implements zzdd {
    private final zzdd[] zza;

    zzcw(zzdd... zzddArr) {
        this.zza = zzddArr;
    }

    public final zzdc zzb(Class cls) {
        zzdd[] zzddArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            zzdd zzdd = zzddArr[i10];
            if (zzdd.zzc(cls)) {
                return zzdd.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzdd[] zzddArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            if (zzddArr[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
