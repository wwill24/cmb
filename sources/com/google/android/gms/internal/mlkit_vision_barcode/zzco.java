package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

abstract class zzco extends AbstractMap {
    private transient Set zza;
    private transient Set zzb;
    private transient Collection zzc;

    zzco() {
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
        zzcm zzcm = new zzcm(this);
        this.zzb = zzcm;
        return zzcm;
    }

    public final Collection values() {
        Collection collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzcn zzcn = new zzcn(this);
        this.zzc = zzcn;
        return zzcn;
    }

    /* access modifiers changed from: package-private */
    public abstract Set zza();
}
