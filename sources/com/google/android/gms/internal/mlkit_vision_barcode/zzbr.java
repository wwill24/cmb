package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;

final class zzbr extends zzbf {
    final /* synthetic */ zzbt zza;
    private final Object zzb;
    private int zzc;

    zzbr(zzbt zzbt, int i10) {
        this.zza = zzbt;
        Object[] objArr = zzbt.zzb;
        objArr.getClass();
        this.zzb = objArr[i10];
        this.zzc = i10;
    }

    private final void zza() {
        int i10 = this.zzc;
        if (i10 != -1 && i10 < this.zza.size()) {
            Object obj = this.zzb;
            zzbt zzbt = this.zza;
            int i11 = this.zzc;
            Object[] objArr = zzbt.zzb;
            objArr.getClass();
            if (zzam.zza(obj, objArr[i11])) {
                return;
            }
        }
        this.zzc = this.zza.zzq(this.zzb);
    }

    public final Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.get(this.zzb);
        }
        zza();
        int i10 = this.zzc;
        if (i10 == -1) {
            return null;
        }
        Object[] objArr = this.zza.zzc;
        objArr.getClass();
        return objArr[i10];
    }

    public final Object setValue(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.put(this.zzb, obj);
        }
        zza();
        int i10 = this.zzc;
        if (i10 == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        Object[] objArr = this.zza.zzc;
        objArr.getClass();
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }
}
