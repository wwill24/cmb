package com.google.android.gms.internal.play_billing;

import com.google.android.gms.common.api.a;
import java.util.Arrays;

public final class zzw {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzv zzc;

    public final zzw zza(Object obj, Object obj2) {
        int i10 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i11 = i10 + i10;
        if (i11 > length) {
            int i12 = length + (length >> 1) + 1;
            if (i12 < i11) {
                int highestOneBit = Integer.highestOneBit(i11 - 1);
                i12 = highestOneBit + highestOneBit;
            }
            if (i12 < 0) {
                i12 = a.e.API_PRIORITY_OTHER;
            }
            this.zza = Arrays.copyOf(objArr, i12);
        }
        zzp.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i13 = this.zzb;
        int i14 = i13 + i13;
        objArr2[i14] = obj;
        objArr2[i14 + 1] = obj2;
        this.zzb = i13 + 1;
        return this;
    }

    public final zzx zzb() {
        zzv zzv = this.zzc;
        if (zzv == null) {
            zzaf zzf = zzaf.zzf(this.zzb, this.zza, this);
            zzv zzv2 = this.zzc;
            if (zzv2 == null) {
                return zzf;
            }
            throw zzv2.zza();
        }
        throw zzv.zza();
    }
}
