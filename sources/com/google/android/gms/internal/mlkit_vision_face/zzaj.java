package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class zzaj extends zzbw {
    final /* synthetic */ zzap zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaj(zzap zzap, Map map) {
        super(map);
        this.zza = zzap;
    }

    public final void clear() {
        zzbr.zza(iterator());
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
        return new zzai(this, this.zzb.entrySet().iterator());
    }

    public final boolean remove(Object obj) {
        Collection collection = (Collection) this.zzb.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        zzap.zzg(this.zza, size);
        if (size > 0) {
            return true;
        }
        return false;
    }
}
