package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzbq extends AbstractSet {
    final /* synthetic */ zzbt zza;

    zzbq(zzbt zzbt) {
        this.zza = zzbt;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzbt zzbt = this.zza;
        Map zzj = zzbt.zzj();
        if (zzj != null) {
            return zzj.keySet().iterator();
        }
        return new zzbk(zzbt);
    }

    public final boolean remove(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.keySet().remove(obj);
        }
        if (this.zza.zzs(obj) == zzbt.zzd) {
            return false;
        }
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
