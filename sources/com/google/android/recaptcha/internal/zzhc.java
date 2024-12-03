package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

final class zzhc implements Iterator {
    private final Iterator zza;

    public zzhc(Iterator it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        if (entry.getValue() instanceof zzhd) {
            return new zzhb(entry, (zzha) null);
        }
        return entry;
    }

    public final void remove() {
        this.zza.remove();
    }
}
