package p004do;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;

/* renamed from: do.c  reason: invalid package */
public final class c {
    public static final Map<String, Object> a(List<? extends Object> list) {
        j.g(list, "<this>");
        Object b10 = b(list);
        if (!a.f(b10)) {
            b10 = null;
        }
        if (b10 instanceof Map) {
            return (Map) b10;
        }
        return null;
    }

    public static final <T> T b(List<? extends T> list) {
        j.g(list, "<this>");
        return CollectionsKt___CollectionsKt.Q(list, 1);
    }

    public static final <T> T c(List<? extends T> list) {
        j.g(list, "<this>");
        return CollectionsKt___CollectionsKt.Q(list, 2);
    }
}
