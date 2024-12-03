package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.n;

public final class zzee {
    private final zzks zza;
    private final Boolean zzb = null;
    private final Boolean zzc;
    private final zzkh zzd;
    private final zzmq zze;

    /* synthetic */ zzee(zzec zzec, zzed zzed) {
        this.zza = zzec.zza;
        this.zzc = zzec.zzb;
        this.zzd = null;
        this.zze = zzec.zzc;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzee)) {
            return false;
        }
        zzee zzee = (zzee) obj;
        if (!n.b(this.zza, zzee.zza) || !n.b((Object) null, (Object) null) || !n.b(this.zzc, zzee.zzc) || !n.b((Object) null, (Object) null) || !n.b(this.zze, zzee.zze)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(this.zza, null, this.zzc, null, this.zze);
    }

    @zzcz(zza = 1)
    public final zzks zza() {
        return this.zza;
    }

    @zzcz(zza = 5)
    public final zzmq zzb() {
        return this.zze;
    }

    @zzcz(zza = 3)
    public final Boolean zzc() {
        return this.zzc;
    }
}
