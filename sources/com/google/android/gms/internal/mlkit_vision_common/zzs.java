package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Set;

public abstract class zzs extends zzl implements Set {
    private transient zzp zza;

    zzs() {
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
        return zzaa.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzab iterator();

    public final zzp zzf() {
        zzp zzp = this.zza;
        if (zzp != null) {
            return zzp;
        }
        zzp zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    /* access modifiers changed from: package-private */
    public zzp zzg() {
        return zzp.zzg(toArray());
    }
}
