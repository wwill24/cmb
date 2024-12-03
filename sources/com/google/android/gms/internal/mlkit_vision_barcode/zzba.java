package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

class zzba implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzbb zzc;

    zzba(zzbb zzbb) {
        Iterator it;
        this.zzc = zzbb;
        Collection collection = zzbb.zzb;
        this.zzb = collection;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }

    zzba(zzbb zzbb, Iterator it) {
        this.zzc = zzbb;
        this.zzb = zzbb.zzb;
        this.zza = it;
    }

    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    public final Object next() {
        zza();
        return this.zza.next();
    }

    public final void remove() {
        this.zza.remove();
        zzbe zzbe = this.zzc.zze;
        zzbe.zzb = zzbe.zzb - 1;
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
