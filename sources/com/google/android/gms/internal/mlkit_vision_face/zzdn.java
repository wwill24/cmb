package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.n;

public final class zzdn {
    private final zzks zza;
    private final Boolean zzb;
    private final zzkh zzc = null;
    private final zzkd zzd;
    private final Integer zze;
    private final Integer zzf;

    /* synthetic */ zzdn(zzdl zzdl, zzdm zzdm) {
        this.zza = zzdl.zza;
        this.zzb = zzdl.zzb;
        this.zzd = zzdl.zzc;
        this.zze = zzdl.zzd;
        this.zzf = zzdl.zze;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdn)) {
            return false;
        }
        zzdn zzdn = (zzdn) obj;
        if (!n.b(this.zza, zzdn.zza) || !n.b(this.zzb, zzdn.zzb) || !n.b((Object) null, (Object) null) || !n.b(this.zzd, zzdn.zzd) || !n.b(this.zze, zzdn.zze) || !n.b(this.zzf, zzdn.zzf)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(this.zza, this.zzb, null, this.zzd, this.zze, this.zzf);
    }

    @zzcu(zza = 4)
    public final zzkd zza() {
        return this.zzd;
    }

    @zzcu(zza = 1)
    public final zzks zzb() {
        return this.zza;
    }

    @zzcu(zza = 2)
    public final Boolean zzc() {
        return this.zzb;
    }

    @zzcu(zza = 5)
    public final Integer zzd() {
        return this.zze;
    }

    @zzcu(zza = 6)
    public final Integer zze() {
        return this.zzf;
    }
}
