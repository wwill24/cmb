package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.n;

public final class zzmq {
    private final zzmo zza;
    private final Integer zzb;
    private final Integer zzc = null;
    private final Boolean zzd = null;

    /* synthetic */ zzmq(zzmn zzmn, zzmp zzmp) {
        this.zza = zzmn.zza;
        this.zzb = zzmn.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzmq)) {
            return false;
        }
        zzmq zzmq = (zzmq) obj;
        if (!n.b(this.zza, zzmq.zza) || !n.b(this.zzb, zzmq.zzb) || !n.b((Object) null, (Object) null) || !n.b((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(this.zza, this.zzb, null, null);
    }

    @zzdk(zza = 1)
    public final zzmo zza() {
        return this.zza;
    }

    @zzdk(zza = 2)
    public final Integer zzb() {
        return this.zzb;
    }
}
