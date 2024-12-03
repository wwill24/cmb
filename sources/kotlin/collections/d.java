package kotlin.collections;

import java.util.AbstractList;
import qk.c;

public abstract class d<E> extends AbstractList<E> implements c {
    protected d() {
    }

    public abstract int b();

    public abstract E d(int i10);

    public final /* bridge */ E remove(int i10) {
        return d(i10);
    }

    public final /* bridge */ int size() {
        return b();
    }
}
