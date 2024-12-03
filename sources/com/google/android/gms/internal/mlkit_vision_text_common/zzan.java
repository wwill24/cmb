package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class zzan extends zzal implements List {
    final /* synthetic */ zzao zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzan(zzao zzao, Object obj, List list, zzal zzal) {
        super(zzao, obj, list, zzal);
        this.zzf = zzao;
    }

    public final void add(int i10, Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i10, obj);
        zzao.zzd(this.zzf);
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
        zzao.zzf(this.zzf, this.zzb.size() - size);
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
        return new zzam(this);
    }

    public final Object remove(int i10) {
        zzb();
        Object remove = ((List) this.zzb).remove(i10);
        zzao.zze(this.zzf);
        zzc();
        return remove;
    }

    public final Object set(int i10, Object obj) {
        zzb();
        return ((List) this.zzb).set(i10, obj);
    }

    public final List subList(int i10, int i11) {
        zzb();
        zzao zzao = this.zzf;
        Object obj = this.zza;
        List subList = ((List) this.zzb).subList(i10, i11);
        zzal zzal = this.zzc;
        if (zzal == null) {
            zzal = this;
        }
        return zzao.zzi(obj, subList, zzal);
    }

    public final ListIterator listIterator(int i10) {
        zzb();
        return new zzam(this, i10);
    }
}
