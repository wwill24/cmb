package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

final class zzbc extends AbstractCollection {
    final /* synthetic */ zzbd zza;

    zzbc(zzbd zzbd) {
        this.zza = zzbd;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzbd zzbd = this.zza;
        Map zzl = zzbd.zzl();
        if (zzl != null) {
            return zzl.values().iterator();
        }
        return new zzax(zzbd);
    }

    public final int size() {
        return this.zza.size();
    }
}
