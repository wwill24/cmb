package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class d<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f3588a;

    /* renamed from: b  reason: collision with root package name */
    private int f3589b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3590c;

    d(int i10) {
        this.f3588a = i10;
    }

    /* access modifiers changed from: protected */
    public abstract T a(int i10);

    /* access modifiers changed from: protected */
    public abstract void c(int i10);

    public final boolean hasNext() {
        return this.f3589b < this.f3588a;
    }

    public T next() {
        if (hasNext()) {
            T a10 = a(this.f3589b);
            this.f3589b++;
            this.f3590c = true;
            return a10;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.f3590c) {
            int i10 = this.f3589b - 1;
            this.f3589b = i10;
            c(i10);
            this.f3588a--;
            this.f3590c = false;
            return;
        }
        throw new IllegalStateException();
    }
}
