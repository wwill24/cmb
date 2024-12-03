package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.ranges.IntRange;

class q extends p {
    public static <T> ArrayList<T> f(T... tArr) {
        j.g(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new f(tArr, true));
    }

    public static final <T> Collection<T> g(T[] tArr) {
        j.g(tArr, "<this>");
        return new f(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int h(List<? extends T> list, T t10, int i10, int i11) {
        j.g(list, "<this>");
        r(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int a10 = b.a((Comparable) list.get(i13), t10);
            if (a10 < 0) {
                i10 = i13 + 1;
            } else if (a10 <= 0) {
                return i13;
            } else {
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int i(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return h(list, comparable, i10, i11);
    }

    public static <T> List<T> j() {
        return EmptyList.f32016a;
    }

    public static IntRange k(Collection<?> collection) {
        j.g(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static <T> int l(List<? extends T> list) {
        j.g(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> m(T... tArr) {
        j.g(tArr, "elements");
        return tArr.length > 0 ? k.e(tArr) : j();
    }

    public static <T> List<T> n(T t10) {
        return t10 != null ? p.e(t10) : j();
    }

    public static <T> List<T> o(T... tArr) {
        j.g(tArr, "elements");
        return l.y(tArr);
    }

    public static <T> List<T> p(T... tArr) {
        j.g(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new f(tArr, true));
    }

    public static <T> List<T> q(List<? extends T> list) {
        j.g(list, "<this>");
        int size = list.size();
        if (size == 0) {
            return j();
        }
        if (size != 1) {
            return list;
        }
        return p.e(list.get(0));
    }

    private static final void r(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        } else if (i11 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i11 + ") is less than zero.");
        } else if (i12 > i10) {
            throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
        }
    }

    public static void s() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
