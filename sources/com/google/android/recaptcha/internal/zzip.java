package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzip implements Iterator {
    zzip() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
