package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.n;

public final class zzkh {
    private final zzkf zza;
    private final Integer zzb;
    private final Integer zzc = null;
    private final Boolean zzd = null;

    /* synthetic */ zzkh(zzke zzke, zzkg zzkg) {
        this.zza = zzke.zza;
        this.zzb = zzke.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkh)) {
            return false;
        }
        zzkh zzkh = (zzkh) obj;
        if (!n.b(this.zza, zzkh.zza) || !n.b(this.zzb, zzkh.zzb) || !n.b((Object) null, (Object) null) || !n.b((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(this.zza, this.zzb, null, null);
    }

    @zzcz(zza = 1)
    public final zzkf zza() {
        return this.zza;
    }

    @zzcz(zza = 2)
    public final Integer zzb() {
        return this.zzb;
    }
}
