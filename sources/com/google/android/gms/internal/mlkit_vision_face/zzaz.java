package com.google.android.gms.internal.mlkit_vision_face;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzaz implements Iterator {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzbd zze;

    /* synthetic */ zzaz(zzbd zzbd, zzav zzav) {
        this.zze = zzbd;
        this.zzb = zzbd.zzf;
        this.zzc = zzbd.zze();
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
        zzab.zzd(z10, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzbd zzbd = this.zze;
        zzbd.remove(zzbd.zzg(zzbd, this.zzd));
        this.zzc--;
        this.zzd = -1;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(int i10);
}
