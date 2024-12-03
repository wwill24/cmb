package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Map;
import java.util.Set;

abstract class zzaq implements zzce {
    private transient Set zza;
    private transient Map zzb;

    zzaq() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzce)) {
            return false;
        }
        return zzp().equals(((zzce) obj).zzp());
    }

    public final int hashCode() {
        return zzp().hashCode();
    }

    public final String toString() {
        return ((zzag) zzp()).zza.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract Map zzk();

    /* access modifiers changed from: package-private */
    public abstract Set zzl();

    public boolean zzo(Object obj, Object obj2) {
        throw null;
    }

    public final Map zzp() {
        Map map = this.zzb;
        if (map != null) {
            return map;
        }
        Map zzk = zzk();
        this.zzb = zzk;
        return zzk;
    }

    public final Set zzq() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set zzl = zzl();
        this.zza = zzl;
        return zzl;
    }
}
