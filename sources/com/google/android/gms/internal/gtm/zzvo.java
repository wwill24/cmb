package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

final class zzvo<K> implements Iterator<Map.Entry<K, Object>> {
    private final Iterator<Map.Entry<K, Object>> zza;

    public zzvo(Iterator<Map.Entry<K, Object>> it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        if (next.getValue() instanceof zzvp) {
            return new zzvn(next, (zzvm) null);
        }
        return next;
    }

    public final void remove() {
        this.zza.remove();
    }
}
