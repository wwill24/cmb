package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class e<T> implements Sequence<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Sequence<T> f32175a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32176b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Function1<T, Boolean> f32177c;

    public static final class a implements Iterator<T>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f32178a;

        /* renamed from: b  reason: collision with root package name */
        private int f32179b = -1;

        /* renamed from: c  reason: collision with root package name */
        private T f32180c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e<T> f32181d;

        a(e<T> eVar) {
            this.f32181d = eVar;
            this.f32178a = eVar.f32175a.iterator();
        }

        private final void a() {
            while (this.f32178a.hasNext()) {
                T next = this.f32178a.next();
                if (((Boolean) this.f32181d.f32177c.invoke(next)).booleanValue() == this.f32181d.f32176b) {
                    this.f32180c = next;
                    this.f32179b = 1;
                    return;
                }
            }
            this.f32179b = 0;
        }

        public boolean hasNext() {
            if (this.f32179b == -1) {
                a();
            }
            if (this.f32179b == 1) {
                return true;
            }
            return false;
        }

        public T next() {
            if (this.f32179b == -1) {
                a();
            }
            if (this.f32179b != 0) {
                T t10 = this.f32180c;
                this.f32180c = null;
                this.f32179b = -1;
                return t10;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(Sequence<? extends T> sequence, boolean z10, Function1<? super T, Boolean> function1) {
        j.g(sequence, "sequence");
        j.g(function1, "predicate");
        this.f32175a = sequence;
        this.f32176b = z10;
        this.f32177c = function1;
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
