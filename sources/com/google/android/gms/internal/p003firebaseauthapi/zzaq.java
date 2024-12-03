package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaq  reason: invalid package */
public abstract class zzaq extends zzai implements Set {
    private transient zzam zza;

    zzaq() {
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
        return zzay.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzaz iterator();

    public final zzam zzf() {
        zzam zzam = this.zza;
        if (zzam != null) {
            return zzam;
        }
        zzam zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    /* access modifiers changed from: package-private */
    public zzam zzg() {
        Object[] array2 = toArray();
        int i10 = zzam.zzd;
        return zzam.zzg(array2, array2.length);
    }
}
