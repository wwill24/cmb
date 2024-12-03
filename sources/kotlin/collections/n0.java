package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.j;

class n0 extends m0 {
    public static <T> Set<T> e() {
        return EmptySet.f32018a;
    }

    public static <T> HashSet<T> f(T... tArr) {
        j.g(tArr, "elements");
        return (HashSet) l.i0(tArr, new HashSet(g0.e(tArr.length)));
    }

    public static <T> Set<T> g(T... tArr) {
        j.g(tArr, "elements");
        return (Set) l.i0(tArr, new LinkedHashSet(g0.e(tArr.length)));
    }

    public static <T> Set<T> h(Set<? extends T> set) {
        j.g(set, "<this>");
        int size = set.size();
        if (size == 0) {
            return e();
        }
        if (size != 1) {
            return set;
        }
        return m0.d(set.iterator().next());
    }

    public static <T> Set<T> i(T... tArr) {
        j.g(tArr, "elements");
        return tArr.length > 0 ? l.y0(tArr) : e();
    }
}
