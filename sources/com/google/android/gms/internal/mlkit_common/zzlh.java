package com.google.android.gms.internal.mlkit_common;

public final class zzlh {
    /* access modifiers changed from: private */
    public zzlt zza;
    /* access modifiers changed from: private */
    public Long zzb;
    /* access modifiers changed from: private */
    public zzlc zzc;
    /* access modifiers changed from: private */
    public Long zzd;
    /* access modifiers changed from: private */
    public zzli zze;
    /* access modifiers changed from: private */
    public Long zzf;

    public final zzlh zzb(Long l10) {
        this.zzf = l10;
        return this;
    }

    public final zzlh zzc(zzli zzli) {
        this.zze = zzli;
        return this;
    }

    public final zzlh zzd(zzlc zzlc) {
        this.zzc = zzlc;
        return this;
    }

    public final zzlh zze(Long l10) {
        this.zzd = Long.valueOf(l10.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzlh zzf(zzlt zzlt) {
        this.zza = zzlt;
        return this;
    }

    public final zzlh zzg(Long l10) {
        this.zzb = Long.valueOf(l10.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzlk zzi() {
        return new zzlk(this, (zzlj) null);
    }
}
