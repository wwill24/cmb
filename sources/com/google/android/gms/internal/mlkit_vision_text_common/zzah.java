package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class zzah implements Iterator {
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzai zzc;

    zzah(zzai zzai, Iterator it) {
        this.zzc = zzai;
        this.zzb = it;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    public final void remove() {
        boolean z10;
        if (this.zza != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzaa.zzd(z10, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzao.zzg(this.zzc.zza, collection.size());
        collection.clear();
        this.zza = null;
    }
}
