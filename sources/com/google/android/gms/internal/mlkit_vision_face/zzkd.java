package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.n;

public final class zzkd {
    private final zzka zza;
    private final zzjy zzb;
    private final zzkb zzc;
    private final zzjz zzd;
    private final Boolean zze;
    private final Float zzf;

    /* synthetic */ zzkd(zzjx zzjx, zzkc zzkc) {
        this.zza = zzjx.zza;
        this.zzb = zzjx.zzb;
        this.zzc = zzjx.zzc;
        this.zzd = zzjx.zzd;
        this.zze = zzjx.zze;
        this.zzf = zzjx.zzf;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkd)) {
            return false;
        }
        zzkd zzkd = (zzkd) obj;
        if (!n.b(this.zza, zzkd.zza) || !n.b(this.zzb, zzkd.zzb) || !n.b(this.zzc, zzkd.zzc) || !n.b(this.zzd, zzkd.zzd) || !n.b(this.zze, zzkd.zze) || !n.b(this.zzf, zzkd.zzf)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    @zzcu(zza = 2)
    public final zzjy zza() {
        return this.zzb;
    }

    @zzcu(zza = 4)
    public final zzjz zzb() {
        return this.zzd;
    }

    @zzcu(zza = 1)
    public final zzka zzc() {
        return this.zza;
    }

    @zzcu(zza = 3)
    public final zzkb zzd() {
        return this.zzc;
    }

    @zzcu(zza = 5)
    public final Boolean zze() {
        return this.zze;
    }

    @zzcu(zza = 6)
    public final Float zzf() {
        return this.zzf;
    }
}
