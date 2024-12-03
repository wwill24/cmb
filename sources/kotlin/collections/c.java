package kotlin.collections;

import java.util.AbstractCollection;
import qk.b;

public abstract class c<E> extends AbstractCollection<E> implements b {
    protected c() {
    }

    public abstract int b();

    public final /* bridge */ int size() {
        return b();
    }
}
