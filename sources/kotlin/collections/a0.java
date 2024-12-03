package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.j;
import qk.a;

public final class a0<T> implements Iterator<IndexedValue<? extends T>>, a {

    /* renamed from: a  reason: collision with root package name */
    private final Iterator<T> f32029a;

    /* renamed from: b  reason: collision with root package name */
    private int f32030b;

    public a0(Iterator<? extends T> it) {
        j.g(it, "iterator");
        this.f32029a = it;
    }

    /* renamed from: a */
    public final IndexedValue<T> next() {
        int i10 = this.f32030b;
        this.f32030b = i10 + 1;
        if (i10 < 0) {
            q.s();
        }
        return new IndexedValue<>(i10, this.f32029a.next());
    }

    public final boolean hasNext() {
        return this.f32029a.hasNext();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
