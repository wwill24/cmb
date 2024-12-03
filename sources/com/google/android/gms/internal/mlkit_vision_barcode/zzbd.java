package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class zzbd extends zzbb implements List {
    final /* synthetic */ zzbe zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbd(zzbe zzbe, Object obj, List list, zzbb zzbb) {
        super(zzbe, obj, list, zzbb);
        this.zzf = zzbe;
    }

    public final void add(int i10, Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i10, obj);
        zzbe zzbe = this.zzf;
        zzbe.zzb = zzbe.zzb + 1;
        if (isEmpty) {
            zza();
        }
    }

    public final boolean addAll(int i10, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i10, collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzbe zzbe = this.zzf;
        zzbe.zzb = zzbe.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final Object get(int i10) {
        zzb();
        return ((List) this.zzb).get(i10);
    }

    public final int indexOf(Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        zzb();
        return new zzbc(this);
    }

    public final Object remove(int i10) {
        zzb();
        Object remove = ((List) this.zzb).remove(i10);
        zzbe zzbe = this.zzf;
        zzbe.zzb = zzbe.zzb - 1;
        zzc();
        return remove;
    }

    public final Object set(int i10, Object obj) {
        zzb();
        return ((List) this.zzb).set(i10, obj);
    }

    public final List subList(int i10, int i11) {
        zzb();
        zzbe zzbe = this.zzf;
        Object obj = this.zza;
        List subList = ((List) this.zzb).subList(i10, i11);
        zzbb zzbb = this.zzc;
        if (zzbb == null) {
            zzbb = this;
        }
        return zzbe.zzf(obj, subList, zzbb);
    }

    public final ListIterator listIterator(int i10) {
        zzb();
        return new zzbc(this, i10);
    }
}
