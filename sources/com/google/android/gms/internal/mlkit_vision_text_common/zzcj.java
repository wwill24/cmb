package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Iterator;

final class zzcj extends zzbp {
    private final transient zzbo zza;
    private final transient zzbm zzb;

    zzcj(zzbo zzbo, zzbm zzbm) {
        this.zza = zzbo;
        this.zzb = zzbm;
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

    public final zzcq zzd() {
        return this.zzb.listIterator(0);
    }
}
