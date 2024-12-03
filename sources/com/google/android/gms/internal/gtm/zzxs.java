package com.google.android.gms.internal.gtm;

import java.util.Iterator;

final class zzxs implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzxt zzb;

    zzxs(zzxt zzxt) {
        this.zzb = zzxt;
        this.zza = zzxt.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
