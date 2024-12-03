package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

final class f<T> implements Sequence<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Function0<T> f32182a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Function1<T, T> f32183b;

    public static final class a implements Iterator<T>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private T f32184a;

        /* renamed from: b  reason: collision with root package name */
        private int f32185b = -2;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f<T> f32186c;

        a(f<T> fVar) {
            this.f32186c = fVar;
        }

        private final void a() {
            T t10;
            int i10;
            if (this.f32185b == -2) {
                t10 = this.f32186c.f32182a.invoke();
            } else {
                Function1 c10 = this.f32186c.f32183b;
                T t11 = this.f32184a;
                j.d(t11);
                t10 = c10.invoke(t11);
            }
            this.f32184a = t10;
            if (t10 == null) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            this.f32185b = i10;
        }

        public boolean hasNext() {
            if (this.f32185b < 0) {
                a();
            }
            if (this.f32185b == 1) {
                return true;
            }
            return false;
        }

        public T next() {
            if (this.f32185b < 0) {
                a();
            }
            if (this.f32185b != 0) {
                T t10 = this.f32184a;
                j.e(t10, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.f32185b = -1;
                return t10;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public f(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        j.g(function0, "getInitialValue");
        j.g(function1, "getNextValue");
        this.f32182a = function0;
        this.f32183b = function1;
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
