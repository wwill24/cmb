package io.reactivex.subjects;

import qj.q;
import qj.u;

public abstract class c<T> extends q<T> implements u<T> {
    public final c<T> A0() {
        if (this instanceof b) {
            return this;
        }
        return new b(this);
    }
}
