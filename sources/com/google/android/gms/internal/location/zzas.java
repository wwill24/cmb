package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.k;

final class zzas implements zzcs {
    private k zza;

    zzas(k kVar) {
        this.zza = kVar;
    }

    public final synchronized k zza() {
        return this.zza;
    }

    public final void zzb() {
    }

    public final synchronized void zzc(k kVar) {
        k kVar2 = this.zza;
        if (kVar2 != kVar) {
            kVar2.a();
            this.zza = kVar;
        }
    }
}
