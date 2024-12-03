package com.google.android.gms.internal.mlkit_common;

public final class zzg {
    private final zzao zza = new zzao();
    private Boolean zzb;

    private zzg() {
    }

    public final zzg zza(zzs zzs) {
        zzaf.zzc(this.zzb, "Must call internal() or external() before appending rules.");
        this.zza.zzb(zzs);
        return this;
    }

    public final zzg zzb() {
        boolean z10;
        if (this.zzb == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzaf.zze(z10, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = Boolean.FALSE;
        return this;
    }

    public final zzg zzc() {
        boolean z10;
        if (this.zzb == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzaf.zze(z10, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = Boolean.TRUE;
        return this;
    }

    public final zzi zzd() {
        zzaf.zzc(this.zzb, "Must call internal() or external() when building a SourcePolicy.");
        return new zzi(this.zzb.booleanValue(), false, this.zza.zzc(), (zzh) null);
    }

    /* synthetic */ zzg(zzf zzf) {
    }
}
