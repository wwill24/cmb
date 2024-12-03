package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.j;

class p {
    public static <E> List<E> a(List<E> list) {
        j.g(list, "builder");
        return ((ListBuilder) list).o();
    }

    public static final <T> Object[] b(T[] tArr, boolean z10) {
        Class<Object[]> cls = Object[].class;
        j.g(tArr, "<this>");
        if (z10 && j.b(tArr.getClass(), cls)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, cls);
        j.f(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public static <E> List<E> c() {
        return new ListBuilder();
    }

    public static <E> List<E> d(int i10) {
        return new ListBuilder(i10);
    }

    public static <T> List<T> e(T t10) {
        List<T> singletonList = Collections.singletonList(t10);
        j.f(singletonList, "singletonList(element)");
        return singletonList;
    }
}
