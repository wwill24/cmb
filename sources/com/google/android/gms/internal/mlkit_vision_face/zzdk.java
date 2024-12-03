package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.a;

public final class zzdk {
    /* access modifiers changed from: private */
    public zzdn zza;
    /* access modifiers changed from: private */
    public Integer zzb;
    /* access modifiers changed from: private */
    public zzjv zzc;

    public final zzdk zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzdk zzb(zzjv zzjv) {
        this.zzc = zzjv;
        return this;
    }

    public final zzdk zzc(zzdn zzdn) {
        this.zza = zzdn;
        return this;
    }

    public final zzdp zze() {
        return new zzdp(this, (zzdo) null);
    }
}
