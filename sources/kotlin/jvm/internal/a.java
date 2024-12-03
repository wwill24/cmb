package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<T> implements Iterator<T>, qk.a {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f32125a;

    /* renamed from: b  reason: collision with root package name */
    private int f32126b;

    public a(T[] tArr) {
        j.g(tArr, "array");
        this.f32125a = tArr;
    }

    public boolean hasNext() {
        return this.f32126b < this.f32125a.length;
    }

    public T next() {
        try {
            T[] tArr = this.f32125a;
            int i10 = this.f32126b;
            this.f32126b = i10 + 1;
            return tArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f32126b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
