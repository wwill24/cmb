package io.reactivex.processors;

import qj.h;
import qj.l;
import rn.b;

public abstract class a<T> extends h<T> implements b, l<T> {
    public final a<T> A0() {
        if (this instanceof b) {
            return this;
        }
        return new b(this);
    }
}
