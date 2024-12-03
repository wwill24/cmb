package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.api.a;

public final class zzdw {
    /* access modifiers changed from: private */
    public zzdz zza;
    /* access modifiers changed from: private */
    public Integer zzb;
    /* access modifiers changed from: private */
    public zzmj zzc;

    public final zzdw zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzdw zzb(zzmj zzmj) {
        this.zzc = zzmj;
        return this;
    }

    public final zzdw zzc(zzdz zzdz) {
        this.zza = zzdz;
        return this;
    }

    public final zzeb zze() {
        return new zzeb(this, (zzea) null);
    }
}
