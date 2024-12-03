package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.j;

public final class f {
    public static final <T> c<T> a(c<? super T> cVar) {
        j.g(cVar, "completion");
        return cVar;
    }

    public static final void b(c<?> cVar) {
        j.g(cVar, "frame");
    }

    public static final void c(c<?> cVar) {
        j.g(cVar, "frame");
    }
}
