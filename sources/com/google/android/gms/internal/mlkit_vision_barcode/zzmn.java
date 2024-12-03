package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.api.a;

public final class zzmn {
    /* access modifiers changed from: private */
    public zzmo zza;
    /* access modifiers changed from: private */
    public Integer zzb;

    public final zzmn zza(zzmo zzmo) {
        this.zza = zzmo;
        return this;
    }

    public final zzmn zzb(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzmq zzd() {
        return new zzmq(this, (zzmp) null);
    }
}
