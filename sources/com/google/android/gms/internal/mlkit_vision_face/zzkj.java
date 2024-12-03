package com.google.android.gms.internal.mlkit_vision_face;

public final class zzkj {
    /* access modifiers changed from: private */
    public Long zza;
    /* access modifiers changed from: private */
    public zzks zzb;
    /* access modifiers changed from: private */
    public Boolean zzc;
    /* access modifiers changed from: private */
    public Boolean zzd;
    /* access modifiers changed from: private */
    public Boolean zze;

    public final zzkj zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzkj zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzkj zzc(Long l10) {
        this.zza = Long.valueOf(l10.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzkj zzd(zzks zzks) {
        this.zzb = zzks;
        return this;
    }

    public final zzkj zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzkl zzf() {
        return new zzkl(this, (zzkk) null);
    }
}
