package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

final class zzbb extends AbstractCollection {
    final /* synthetic */ zzbc zza;

    zzbb(zzbc zzbc) {
        this.zza = zzbc;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzbc zzbc = this.zza;
        Map zzl = zzbc.zzl();
        if (zzl != null) {
            return zzl.values().iterator();
        }
        return new zzaw(zzbc);
    }

    public final int size() {
        return this.zza.size();
    }
}
