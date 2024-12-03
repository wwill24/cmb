package kotlin.collections;

import java.util.Iterator;
import qk.a;

public abstract class c0 implements Iterator<Long>, a {
    public /* bridge */ /* synthetic */ Object next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
