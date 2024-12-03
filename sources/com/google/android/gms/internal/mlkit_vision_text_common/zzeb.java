package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.api.a;

public final class zzeb {
    /* access modifiers changed from: private */
    public zzee zza;
    /* access modifiers changed from: private */
    public Integer zzb;
    /* access modifiers changed from: private */
    public zzkb zzc;

    public final zzeb zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzeb zzb(zzkb zzkb) {
        this.zzc = zzkb;
        return this;
    }

    public final zzeb zzc(zzee zzee) {
        this.zza = zzee;
        return this;
    }

    public final zzeg zze() {
        return new zzeg(this, (zzef) null);
    }
}
