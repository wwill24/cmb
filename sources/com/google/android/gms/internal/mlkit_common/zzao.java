package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;

public final class zzao extends zzal {
    public zzao() {
        super(4);
    }

    public final zzao zzb(Object obj) {
        obj.getClass();
        int i10 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i10) {
            this.zza = Arrays.copyOf(objArr, zzam.zza(length, i10));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i11 = this.zzb;
        this.zzb = i11 + 1;
        objArr2[i11] = obj;
        return this;
    }

    public final zzar zzc() {
        this.zzc = true;
        return zzar.zzg(this.zza, this.zzb);
    }
}
