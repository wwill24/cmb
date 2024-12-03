package com.google.android.gms.internal.mlkit_common;

import java.util.Set;

public abstract class zzav extends zzan implements Set {
    private transient zzar zza;

    zzav() {
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
        return zzbd.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzbe iterator();

    public final zzar zzf() {
        zzar zzar = this.zza;
        if (zzar != null) {
            return zzar;
        }
        zzar zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    /* access modifiers changed from: package-private */
    public zzar zzg() {
        Object[] array2 = toArray();
        int i10 = zzar.zzd;
        return zzar.zzg(array2, array2.length);
    }
}
