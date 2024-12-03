package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;

final class zzcf extends zzbq {
    private final transient zzbp zza;
    private final transient zzbn zzb;

    zzcf(zzbp zzbp, zzbn zzbn) {
        this.zza = zzbp;
        this.zzb = zzbn;
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

    public final zzcl zzd() {
        return this.zzb.listIterator(0);
    }
}
