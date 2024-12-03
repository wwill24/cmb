package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class zzag implements Iterator {
    final Iterator zza;
    Collection zzb;
    final /* synthetic */ zzah zzc;

    zzag(zzah zzah) {
        this.zzc = zzah;
        this.zza = zzah.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        zzah zzah = this.zzc;
        Object key = entry.getKey();
        return new zzbj(key, zzah.zzb.zzb(key, (Collection) entry.getValue()));
    }

    public final void remove() {
        boolean z10;
        if (this.zzb != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzab.zzd(z10, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzap.zzg(this.zzc.zzb, this.zzb.size());
        this.zzb.clear();
        this.zzb = null;
    }
}
