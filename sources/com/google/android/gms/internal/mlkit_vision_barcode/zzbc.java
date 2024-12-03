package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.List;
import java.util.ListIterator;

final class zzbc extends zzba implements ListIterator {
    final /* synthetic */ zzbd zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbc(zzbd zzbd) {
        super(zzbd);
        this.zzd = zzbd;
    }

    public final void add(Object obj) {
        boolean isEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzbe zzbe = this.zzd.zzf;
        zzbe.zzb = zzbe.zzb + 1;
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
    public zzbc(zzbd zzbd, int i10) {
        super(zzbd, ((List) zzbd.zzb).listIterator(i10));
        this.zzd = zzbd;
    }
}
