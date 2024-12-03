package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.a;

public final class zzdl {
    /* access modifiers changed from: private */
    public zzks zza;
    /* access modifiers changed from: private */
    public Boolean zzb;
    /* access modifiers changed from: private */
    public zzkd zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public Integer zze;

    public final zzdl zza(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzdl zzb(zzkd zzkd) {
        this.zzc = zzkd;
        return this;
    }

    public final zzdl zzc(zzks zzks) {
        this.zza = zzks;
        return this;
    }

    public final zzdl zzd(Boolean bool) {
        this.zzb = bool;
        return this;
    }

    public final zzdl zze(Integer num) {
        this.zze = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzdn zzf() {
        return new zzdn(this, (zzdm) null);
    }
}
