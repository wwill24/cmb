package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.c;

public abstract class h<T> {
    public abstract Object c(T t10, c<? super Unit> cVar);

    public abstract Object e(Iterator<? extends T> it, c<? super Unit> cVar);

    public final Object f(Sequence<? extends T> sequence, c<? super Unit> cVar) {
        Object e10 = e(sequence.iterator(), cVar);
        return e10 == b.d() ? e10 : Unit.f32013a;
    }
}
