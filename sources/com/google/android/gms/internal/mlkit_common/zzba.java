package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;

final class zzba extends zzav {
    private final transient zzau zza;
    private final transient zzar zzb;

    zzba(zzau zzau, zzar zzar) {
        this.zza = zzau;
        this.zzb = zzar;
    }

    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i10) {
        return this.zzb.zza(objArr, 0);
    }

    public final zzbe zzd() {
        return this.zzb.listIterator(0);
    }
}
