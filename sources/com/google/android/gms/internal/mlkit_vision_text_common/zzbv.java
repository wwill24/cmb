package com.google.android.gms.internal.mlkit_vision_text_common;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

final class zzbv extends AbstractSequentialList implements Serializable {
    final List zza;
    final zzu zzb;

    zzbv(List list, zzu zzu) {
        list.getClass();
        this.zza = list;
        zzu.getClass();
        this.zzb = zzu;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final ListIterator listIterator(int i10) {
        return new zzbu(this, this.zza.listIterator(i10));
    }

    public final int size() {
        return this.zza.size();
    }
}
