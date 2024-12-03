package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class zzav implements Iterator {
    final Iterator zza;
    Collection zzb;
    final /* synthetic */ zzaw zzc;

    zzav(zzaw zzaw) {
        this.zzc = zzaw;
        this.zza = zzaw.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        zzaw zzaw = this.zzc;
        Object key = entry.getKey();
        return new zzbz(key, zzaw.zzb.zzb(key, (Collection) entry.getValue()));
    }

    public final void remove() {
        boolean z10;
        if (this.zzb != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzaq.zzd(z10, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzbe zzbe = this.zzc.zzb;
        zzbe.zzb = zzbe.zzb - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
