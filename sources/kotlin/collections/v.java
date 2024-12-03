package kotlin.collections;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

class v extends u {
    public static <T> boolean A(Collection<? super T> collection, Iterable<? extends T> iterable) {
        j.g(collection, "<this>");
        j.g(iterable, "elements");
        return collection.removeAll(z(iterable));
    }

    public static <T> T B(List<T> list) {
        j.g(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(q.l(list));
    }

    public static <T> boolean x(Collection<? super T> collection, Iterable<? extends T> iterable) {
        j.g(collection, "<this>");
        j.g(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z10 = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean y(Collection<? super T> collection, T[] tArr) {
        j.g(collection, "<this>");
        j.g(tArr, "elements");
        return collection.addAll(k.e(tArr));
    }

    public static final <T> Collection<T> z(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : CollectionsKt___CollectionsKt.x0(iterable);
    }
}
