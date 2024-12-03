package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.j;

class o0 extends n0 {
    public static <T> Set<T> j(Set<? extends T> set, Iterable<? extends T> iterable) {
        j.g(set, "<this>");
        j.g(iterable, "elements");
        Collection<? extends T> z10 = v.z(iterable);
        if (z10.isEmpty()) {
            return CollectionsKt___CollectionsKt.B0(set);
        }
        if (z10 instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T next : set) {
                if (!z10.contains(next)) {
                    linkedHashSet.add(next);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(z10);
        return linkedHashSet2;
    }

    public static <T> Set<T> k(Set<? extends T> set, T t10) {
        j.g(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(g0.e(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t10);
        return linkedHashSet;
    }
}
