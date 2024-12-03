package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzbp implements Iterator {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzbt zze;

    /* synthetic */ zzbp(zzbt zzbt, zzbo zzbo) {
        this.zze = zzbt;
        this.zzb = zzbt.zzf;
        this.zzc = zzbt.zze();
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    public final Object next() {
        zzb();
        if (hasNext()) {
            int i10 = this.zzc;
            this.zzd = i10;
            Object zza = zza(i10);
            this.zzc = this.zze.zzf(this.zzc);
            return zza;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        boolean z10;
        zzb();
        if (this.zzd >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzaq.zzd(z10, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzbt zzbt = this.zze;
        int i10 = this.zzd;
        Object[] objArr = zzbt.zzb;
        objArr.getClass();
        zzbt.remove(objArr[i10]);
        this.zzc--;
        this.zzd = -1;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(int i10);
}
