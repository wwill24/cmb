package com.google.android.gms.internal.play_billing;

import java.util.Set;

public abstract class zzy extends zzr implements Set {
    private transient zzu zza;

    zzy() {
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
        return zzag.zza(this);
    }

    public zzu zzd() {
        zzu zzu = this.zza;
        if (zzu != null) {
            return zzu;
        }
        zzu zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* renamed from: zze */
    public abstract zzah iterator();

    /* access modifiers changed from: package-private */
    public zzu zzh() {
        Object[] array2 = toArray();
        int i10 = zzu.zzd;
        return zzu.zzi(array2, array2.length);
    }
}
