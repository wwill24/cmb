package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

abstract class zzby extends AbstractMap {
    private transient Set zza;
    private transient Set zzb;
    private transient Collection zzc;

    zzby() {
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
        zzbw zzbw = new zzbw(this);
        this.zzb = zzbw;
        return zzbw;
    }

    public final Collection values() {
        Collection collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzbx zzbx = new zzbx(this);
        this.zzc = zzbx;
        return zzbx;
    }

    /* access modifiers changed from: package-private */
    public abstract Set zza();
}
