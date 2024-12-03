package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.Map;

final class zzw extends zzs {
    private final transient zzr zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    zzw(zzr zzr, Object[] objArr, int i10, int i11) {
        this.zza = zzr;
        this.zzb = objArr;
        this.zzc = i11;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i10) {
        return zzf().zza(objArr, 0);
    }

    public final zzab zzd() {
        return zzf().listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final zzp zzg() {
        return new zzv(this);
    }
}
