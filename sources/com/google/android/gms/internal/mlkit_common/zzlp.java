package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.n;

public final class zzlp {
    private final String zza;
    private final String zzb = null;
    private final zzln zzc;
    private final String zzd;
    private final String zze;
    private final zzlm zzf;
    private final Long zzg;
    private final Boolean zzh;
    private final Boolean zzi;

    /* synthetic */ zzlp(zzll zzll, zzlo zzlo) {
        this.zza = zzll.zza;
        this.zzc = zzll.zzb;
        this.zzd = null;
        this.zze = zzll.zzc;
        this.zzf = zzll.zzd;
        this.zzg = null;
        this.zzh = null;
        this.zzi = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlp)) {
            return false;
        }
        zzlp zzlp = (zzlp) obj;
        if (!n.b(this.zza, zzlp.zza) || !n.b((Object) null, (Object) null) || !n.b(this.zzc, zzlp.zzc) || !n.b((Object) null, (Object) null) || !n.b(this.zze, zzlp.zze) || !n.b(this.zzf, zzlp.zzf) || !n.b((Object) null, (Object) null) || !n.b((Object) null, (Object) null) || !n.b((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(this.zza, null, this.zzc, null, this.zze, this.zzf, null, null, null);
    }

    @zzbo(zza = 6)
    public final zzlm zza() {
        return this.zzf;
    }

    @zzbo(zza = 3)
    public final zzln zzb() {
        return this.zzc;
    }

    @zzbo(zza = 5)
    public final String zzc() {
        return this.zze;
    }

    @zzbo(zza = 1)
    public final String zzd() {
        return this.zza;
    }
}
