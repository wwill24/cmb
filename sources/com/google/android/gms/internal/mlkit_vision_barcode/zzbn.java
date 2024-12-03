package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzbn extends AbstractSet {
    final /* synthetic */ zzbt zza;

    zzbn(zzbt zzbt) {
        this.zza = zzbt;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzd = this.zza.zzq(entry.getKey());
            if (zzd != -1) {
                Object[] objArr = this.zza.zzc;
                objArr.getClass();
                if (zzam.zza(objArr[zzd], entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Iterator iterator() {
        zzbt zzbt = this.zza;
        Map zzj = zzbt.zzj();
        if (zzj != null) {
            return zzj.entrySet().iterator();
        }
        return new zzbl(zzbt);
    }

    public final boolean remove(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzbt zzbt = this.zza;
        if (zzbt.zzo()) {
            return false;
        }
        int zzc = zzbt.zzp();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object zzh = zzbt.zzh(this.zza);
        zzbt zzbt2 = this.zza;
        int[] iArr = zzbt2.zza;
        iArr.getClass();
        Object[] objArr = zzbt2.zzb;
        objArr.getClass();
        Object[] objArr2 = zzbt2.zzc;
        objArr2.getClass();
        int zzb = zzbu.zzb(key, value, zzc, zzh, iArr, objArr, objArr2);
        if (zzb == -1) {
            return false;
        }
        this.zza.zzn(zzb, zzc);
        zzbt zzbt3 = this.zza;
        zzbt3.zzg = zzbt3.zzg - 1;
        this.zza.zzl();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
