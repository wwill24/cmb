package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;

public final class zzat {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzas zzc;

    public final zzat zza(Object obj, Object obj2) {
        int i10 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i11 = i10 + i10;
        if (i11 > length) {
            this.zza = Arrays.copyOf(objArr, zzam.zza(length, i11));
        }
        zzai.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i12 = this.zzb;
        int i13 = i12 + i12;
        objArr2[i13] = obj;
        objArr2[i13 + 1] = obj2;
        this.zzb = i12 + 1;
        return this;
    }

    public final zzau zzb() {
        zzas zzas = this.zzc;
        if (zzas == null) {
            zzbc zzg = zzbc.zzg(this.zzb, this.zza, this);
            zzas zzas2 = this.zzc;
            if (zzas2 == null) {
                return zzg;
            }
            throw zzas2.zza();
        }
        throw zzas.zza();
    }
}
