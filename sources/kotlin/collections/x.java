package kotlin.collections;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.j;

class x extends w {
    public static final <T> void C(List<T> list) {
        j.g(list, "<this>");
        Collections.reverse(list);
    }
}
