package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.n;

public final class zzmq {
    private final zzmo zza;
    private final Boolean zzb = null;
    private final String zzc = null;

    /* synthetic */ zzmq(zzmn zzmn, zzmp zzmp) {
        this.zza = zzmn.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzmq) && n.b(this.zza, ((zzmq) obj).zza) && n.b((Object) null, (Object) null) && n.b((Object) null, (Object) null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return n.c(this.zza, null, null);
    }

    @zzcz(zza = 3)
    public final zzmo zza() {
        return this.zza;
    }
}
