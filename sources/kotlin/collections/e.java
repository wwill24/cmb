package kotlin.collections;

import java.util.AbstractSet;
import qk.b;

public abstract class e<E> extends AbstractSet<E> implements b {
    protected e() {
    }

    public abstract int b();

    public final /* bridge */ int size() {
        return b();
    }
}
