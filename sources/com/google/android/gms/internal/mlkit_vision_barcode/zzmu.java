package com.google.android.gms.internal.mlkit_vision_barcode;

public final class zzmu {
    /* access modifiers changed from: private */
    public Long zza;
    /* access modifiers changed from: private */
    public zznd zzb;
    /* access modifiers changed from: private */
    public Boolean zzc;
    /* access modifiers changed from: private */
    public Boolean zzd;
    /* access modifiers changed from: private */
    public Boolean zze;

    public final zzmu zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzmu zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzmu zzc(Long l10) {
        this.zza = Long.valueOf(l10.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzmu zzd(zznd zznd) {
        this.zzb = zznd;
        return this;
    }

    public final zzmu zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzmw zzf() {
        return new zzmw(this, (zzmv) null);
    }
}
