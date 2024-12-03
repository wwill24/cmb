package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzaz extends AbstractSet {
    final /* synthetic */ zzbc zza;

    zzaz(zzbc zzbc) {
        this.zza = zzbc;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzbc zzbc = this.zza;
        Map zzl = zzbc.zzl();
        if (zzl != null) {
            return zzl.keySet().iterator();
        }
        return new zzau(zzbc);
    }

    public final boolean remove(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.keySet().remove(obj);
        }
        if (this.zza.zzx(obj) == zzbc.zzd) {
            return false;
        }
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
