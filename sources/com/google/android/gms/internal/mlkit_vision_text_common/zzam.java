package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.List;
import java.util.ListIterator;

final class zzam extends zzak implements ListIterator {
    final /* synthetic */ zzan zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzam(zzan zzan) {
        super(zzan);
        this.zzd = zzan;
    }

    public final void add(Object obj) {
        boolean isEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzao.zzd(this.zzd.zzf);
        if (isEmpty) {
            this.zzd.zza();
        }
    }

    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzam(zzan zzan, int i10) {
        super(zzan, ((List) zzan.zzb).listIterator(i10));
        this.zzd = zzan;
    }
}
