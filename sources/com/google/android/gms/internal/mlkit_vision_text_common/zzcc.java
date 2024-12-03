package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

abstract class zzcc extends AbstractMap {
    private transient Set zza;
    private transient Set zzb;
    private transient Collection zzc;

    zzcc() {
    }

    public final Set entrySet() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set zza2 = zza();
        this.zza = zza2;
        return zza2;
    }

    public Set keySet() {
        Set set = this.zzb;
        if (set != null) {
            return set;
        }
        zzca zzca = new zzca(this);
        this.zzb = zzca;
        return zzca;
    }

    public final Collection values() {
        Collection collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzcb zzcb = new zzcb(this);
        this.zzc = zzcb;
        return zzcb;
    }

    /* access modifiers changed from: package-private */
    public abstract Set zza();
}
