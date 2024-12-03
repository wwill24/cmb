package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;

class r extends q {
    public static <T> int t(Iterable<? extends T> iterable, int i10) {
        j.g(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }

    public static <T> List<T> u(Iterable<? extends Iterable<? extends T>> iterable) {
        j.g(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Iterable x10 : iterable) {
            boolean unused = v.x(arrayList, x10);
        }
        return arrayList;
    }
}
