package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzba extends AbstractSet {
    final /* synthetic */ zzbd zza;

    zzba(zzbd zzbd) {
        this.zza = zzbd;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzbd zzbd = this.zza;
        Map zzl = zzbd.zzl();
        if (zzl != null) {
            return zzl.keySet().iterator();
        }
        return new zzav(zzbd);
    }

    public final boolean remove(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.keySet().remove(obj);
        }
        if (this.zza.zzx(obj) == zzbd.zzd) {
            return false;
        }
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
