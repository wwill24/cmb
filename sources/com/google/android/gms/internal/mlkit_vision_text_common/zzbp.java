package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Set;

public abstract class zzbp extends zzbh implements Set {
    private transient zzbm zza;

    zzbp() {
    }

    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzcn.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzcq iterator();

    public final zzbm zzf() {
        zzbm zzbm = this.zza;
        if (zzbm != null) {
            return zzbm;
        }
        zzbm zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    /* access modifiers changed from: package-private */
    public zzbm zzg() {
        return zzbm.zzh(toArray());
    }
}
