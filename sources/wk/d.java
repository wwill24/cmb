package wk;

import kotlin.jvm.internal.j;

public final class d {
    public static final <T> T a(c<T> cVar, Object obj) {
        j.g(cVar, "<this>");
        if (cVar.isInstance(obj)) {
            j.e(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + cVar.d());
    }
}
