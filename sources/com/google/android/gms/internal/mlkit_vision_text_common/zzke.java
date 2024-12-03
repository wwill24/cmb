package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.api.a;

public final class zzke {
    /* access modifiers changed from: private */
    public zzkf zza;
    /* access modifiers changed from: private */
    public Integer zzb;

    public final zzke zza(zzkf zzkf) {
        this.zza = zzkf;
        return this;
    }

    public final zzke zzb(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzkh zzd() {
        return new zzkh(this, (zzkg) null);
    }
}
