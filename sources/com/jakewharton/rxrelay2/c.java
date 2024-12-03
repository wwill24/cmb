package com.jakewharton.rxrelay2;

import qj.q;
import vj.f;

public abstract class c<T> extends q<T> implements f<T> {
    public final c<T> A0() {
        if (this instanceof d) {
            return this;
        }
        return new d(this);
    }

    public abstract void accept(T t10);
}
