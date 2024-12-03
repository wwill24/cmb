package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class zzjc extends zzjh {
    boolean zza;
    final /* synthetic */ Object zzb;

    zzjc(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return !this.zza;
    }

    public final Object next() {
        if (!this.zza) {
            this.zza = true;
            return this.zzb;
        }
        throw new NoSuchElementException();
    }
}
