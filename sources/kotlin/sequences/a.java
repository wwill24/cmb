package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.j;

public final class a<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<Sequence<T>> f32169a;

    public a(Sequence<? extends T> sequence) {
        j.g(sequence, "sequence");
        this.f32169a = new AtomicReference<>(sequence);
    }

    public Iterator<T> iterator() {
        Sequence andSet = this.f32169a.getAndSet((Object) null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
