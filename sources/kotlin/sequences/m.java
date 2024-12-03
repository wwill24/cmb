package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class m<T, R> implements Sequence<R> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Sequence<T> f32192a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Function1<T, R> f32193b;

    public static final class a implements Iterator<R>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f32194a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m<T, R> f32195b;

        a(m<T, R> mVar) {
            this.f32195b = mVar;
            this.f32194a = mVar.f32192a.iterator();
        }

        public boolean hasNext() {
            return this.f32194a.hasNext();
        }

        public R next() {
            return this.f32195b.f32193b.invoke(this.f32194a.next());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public m(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        j.g(sequence, "sequence");
        j.g(function1, "transformer");
        this.f32192a = sequence;
        this.f32193b = function1;
    }

    public Iterator<R> iterator() {
        return new a(this);
    }
}
