package com.google.android.gms.internal.play_billing;

final class zzbm {
    private final Object zza;
    private final int zzb;

    zzbm(Object obj, int i10) {
        this.zza = obj;
        this.zzb = i10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbm)) {
            return false;
        }
        zzbm zzbm = (zzbm) obj;
        if (this.zza == zzbm.zza && this.zzb == zzbm.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
