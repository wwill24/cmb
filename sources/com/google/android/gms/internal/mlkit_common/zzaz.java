package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Map;

final class zzaz extends zzav {
    private final transient zzau zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    zzaz(zzau zzau, Object[] objArr, int i10, int i11) {
        this.zza = zzau;
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

    public final zzbe zzd() {
        return zzf().listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final zzar zzg() {
        return new zzay(this);
    }
}
