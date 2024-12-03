package com.google.android.gms.internal.gtm;

import java.util.NoSuchElementException;

final class zzst extends zzsw {
    final /* synthetic */ zztd zza;
    private int zzb = 0;
    private final int zzc;

    zzst(zztd zztd) {
        this.zza = zztd;
        this.zzc = zztd.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i10 = this.zzb;
        if (i10 < this.zzc) {
            this.zzb = i10 + 1;
            return this.zza.zzb(i10);
        }
        throw new NoSuchElementException();
    }
}
