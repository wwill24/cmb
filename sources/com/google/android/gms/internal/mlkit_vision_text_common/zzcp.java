package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.ListIterator;

abstract class zzcp extends zzco implements ListIterator {
    zzcp(ListIterator listIterator) {
        super(listIterator);
    }

    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasPrevious() {
        return ((ListIterator) this.zzb).hasPrevious();
    }

    public final int nextIndex() {
        return ((ListIterator) this.zzb).nextIndex();
    }

    public final Object previous() {
        return zza(((ListIterator) this.zzb).previous());
    }

    public final int previousIndex() {
        return ((ListIterator) this.zzb).previousIndex();
    }

    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
