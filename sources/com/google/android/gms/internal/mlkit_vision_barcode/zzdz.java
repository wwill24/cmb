package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.n;

public final class zzdz {
    private final zznd zza;
    private final Boolean zzb = null;
    private final Boolean zzc;
    private final zzmq zzd;
    private final zzqv zze;
    private final zzcd zzf;
    private final zzcd zzg;

    /* synthetic */ zzdz(zzdx zzdx, zzdy zzdy) {
        this.zza = zzdx.zza;
        this.zzc = zzdx.zzb;
        this.zzd = null;
        this.zze = zzdx.zzc;
        this.zzf = zzdx.zzd;
        this.zzg = zzdx.zze;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdz)) {
            return false;
        }
        zzdz zzdz = (zzdz) obj;
        if (!n.b(this.zza, zzdz.zza) || !n.b((Object) null, (Object) null) || !n.b(this.zzc, zzdz.zzc) || !n.b((Object) null, (Object) null) || !n.b(this.zze, zzdz.zze) || !n.b(this.zzf, zzdz.zzf) || !n.b(this.zzg, zzdz.zzg)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(this.zza, null, this.zzc, null, this.zze, this.zzf, this.zzg);
    }

    @zzdk(zza = 6)
    public final zzcd zza() {
        return this.zzf;
    }

    @zzdk(zza = 7)
    public final zzcd zzb() {
        return this.zzg;
    }

    @zzdk(zza = 1)
    public final zznd zzc() {
        return this.zza;
    }

    @zzdk(zza = 5)
    public final zzqv zzd() {
        return this.zze;
    }

    @zzdk(zza = 3)
    public final Boolean zze() {
        return this.zzc;
    }
}
