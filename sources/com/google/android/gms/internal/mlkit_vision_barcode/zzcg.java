package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Set;

public abstract class zzcg extends zzby implements Set {
    private transient zzcd zza;

    zzcg() {
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
        return zzcz.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzdb iterator();

    public final zzcd zzf() {
        zzcd zzcd = this.zza;
        if (zzcd != null) {
            return zzcd;
        }
        zzcd zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    /* access modifiers changed from: package-private */
    public zzcd zzg() {
        Object[] array2 = toArray();
        int i10 = zzcd.zzd;
        return zzcd.zzg(array2, array2.length);
    }
}
