package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.a;

public final class zzlj {
    /* access modifiers changed from: private */
    public zzkl zza;
    /* access modifiers changed from: private */
    public zzkh zzb;
    /* access modifiers changed from: private */
    public zzkd zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public Integer zze;

    public final zzlj zzd(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzlj zze(zzkd zzkd) {
        this.zzc = zzkd;
        return this;
    }

    public final zzlj zzf(zzkh zzkh) {
        this.zzb = zzkh;
        return this;
    }

    public final zzlj zzg(zzkl zzkl) {
        this.zza = zzkl;
        return this;
    }

    public final zzlj zzh(Integer num) {
        this.zze = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzll zzi() {
        return new zzll(this, (zzlk) null);
    }
}
