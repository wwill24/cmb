package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;

public abstract class zzbe implements Iterator {
    protected zzbe() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
