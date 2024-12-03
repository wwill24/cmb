package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.j;

class u extends t {
    public static <T extends Comparable<? super T>> void v(List<T> list) {
        j.g(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static <T> void w(List<T> list, Comparator<? super T> comparator) {
        j.g(list, "<this>");
        j.g(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
