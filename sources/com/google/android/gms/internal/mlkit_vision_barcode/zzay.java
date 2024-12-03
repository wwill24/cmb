package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class zzay extends zzcm {
    final /* synthetic */ zzbe zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzay(zzbe zzbe, Map map) {
        super(map);
        this.zza = zzbe;
    }

    public final void clear() {
        zzch.zza(iterator());
    }

    public final boolean containsAll(Collection collection) {
        return this.zzb.keySet().containsAll(collection);
    }

    public final boolean equals(Object obj) {
        return this == obj || this.zzb.keySet().equals(obj);
    }

    public final int hashCode() {
        return this.zzb.keySet().hashCode();
    }

    public final Iterator iterator() {
        return new zzax(this, this.zzb.entrySet().iterator());
    }

    public final boolean remove(Object obj) {
        Collection collection = (Collection) this.zzb.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        zzbe zzbe = this.zza;
        zzbe.zzb = zzbe.zzb - size;
        if (size > 0) {
            return true;
        }
        return false;
    }
}
