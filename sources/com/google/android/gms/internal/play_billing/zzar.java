package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

final class zzar extends zzat {
    final /* synthetic */ zzba zza;
    private int zzb = 0;
    private final int zzc;

    zzar(zzba zzba) {
        this.zza = zzba;
        this.zzc = zzba.zzd();
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
