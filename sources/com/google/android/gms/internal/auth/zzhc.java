package com.google.android.gms.internal.auth;

import java.util.Iterator;

final class zzhc implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzhd zzb;

    zzhc(zzhd zzhd) {
        this.zzb = zzhd;
        this.zza = zzhd.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
