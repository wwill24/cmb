package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Set;

public abstract class zzbq extends zzbi implements Set {
    private transient zzbn zza;

    zzbq() {
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
        return zzcj.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzcl iterator();

    public final zzbn zzf() {
        zzbn zzbn = this.zza;
        if (zzbn != null) {
            return zzbn;
        }
        zzbn zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    /* access modifiers changed from: package-private */
    public zzbn zzg() {
        return zzbn.zzg(toArray());
    }
}
