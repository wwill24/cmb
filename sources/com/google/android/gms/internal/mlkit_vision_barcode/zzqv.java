package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.n;

public final class zzqv {
    private final zzcd zza;

    /* synthetic */ zzqv(zzqt zzqt, zzqu zzqu) {
        this.zza = zzqt.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzqv)) {
            return false;
        }
        return n.b(this.zza, ((zzqv) obj).zza);
    }

    public final int hashCode() {
        return n.c(this.zza);
    }

    @zzdk(zza = 1)
    public final zzcd zza() {
        return this.zza;
    }
}
