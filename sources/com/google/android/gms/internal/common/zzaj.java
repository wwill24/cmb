package com.google.android.gms.internal.common;

import java.util.Iterator;
import org.jspecify.nullness.NullMarked;

@NullMarked
public abstract class zzaj implements Iterator {
    protected zzaj() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
