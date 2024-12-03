package kotlin.collections;

import java.util.Iterator;
import qk.a;

public abstract class b0 implements Iterator<Integer>, a {
    public /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public abstract int nextInt();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
