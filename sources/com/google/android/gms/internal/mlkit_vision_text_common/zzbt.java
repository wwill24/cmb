package com.google.android.gms.internal.mlkit_vision_text_common;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

final class zzbt extends AbstractList implements RandomAccess, Serializable {
    final List zza;
    final zzu zzb;

    zzbt(List list, zzu zzu) {
        list.getClass();
        this.zza = list;
        zzu.getClass();
        this.zzb = zzu;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Object get(int i10) {
        return this.zzb.zza(this.zza.get(i10));
    }

    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    public final Iterator iterator() {
        return listIterator();
    }

    public final ListIterator listIterator(int i10) {
        return new zzbs(this, this.zza.listIterator(i10));
    }

    public final Object remove(int i10) {
        return this.zzb.zza(this.zza.remove(i10));
    }

    public final int size() {
        return this.zza.size();
    }
}
