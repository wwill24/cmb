package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.j;

public final class b<T> implements Sequence<T>, c<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Sequence<T> f32170a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f32171b;

    public static final class a implements Iterator<T>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f32172a;

        /* renamed from: b  reason: collision with root package name */
        private int f32173b;

        a(b<T> bVar) {
            this.f32172a = bVar.f32170a.iterator();
            this.f32173b = bVar.f32171b;
        }

        private final void a() {
            while (this.f32173b > 0 && this.f32172a.hasNext()) {
                this.f32172a.next();
                this.f32173b--;
            }
        }

        public boolean hasNext() {
            a();
            return this.f32172a.hasNext();
        }

        public T next() {
            a();
            return this.f32172a.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(Sequence<? extends T> sequence, int i10) {
        boolean z10;
        j.g(sequence, "sequence");
        this.f32170a = sequence;
        this.f32171b = i10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
        }
    }

    public Sequence<T> a(int i10) {
        int i11 = this.f32171b + i10;
        return i11 < 0 ? new b(this, i10) : new b(this.f32170a, i11);
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
