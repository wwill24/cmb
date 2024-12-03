package kotlin.collections;

import java.util.Iterator;
import qk.a;

public abstract class n implements Iterator<Character>, a {
    public abstract char a();

    public /* bridge */ /* synthetic */ Object next() {
        return Character.valueOf(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
