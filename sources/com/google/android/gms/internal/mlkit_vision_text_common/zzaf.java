package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class zzaf implements Iterator {
    final Iterator zza;
    Collection zzb;
    final /* synthetic */ zzag zzc;

    zzaf(zzag zzag) {
        this.zzc = zzag;
        this.zza = zzag.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        zzag zzag = this.zzc;
        Object key = entry.getKey();
        return new zzbi(key, zzag.zzb.zzb(key, (Collection) entry.getValue()));
    }

    public final void remove() {
        boolean z10;
        if (this.zzb != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzaa.zzd(z10, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzao.zzg(this.zzc.zzb, this.zzb.size());
        this.zzb.clear();
        this.zzb = null;
    }
}
