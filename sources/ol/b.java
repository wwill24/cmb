package ol;

import java.util.ArrayList;
import java.util.List;
import p004do.a;

public final class b implements ml.b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f33474a = new b();

    private b() {
    }

    private final List<Object> a(List<? extends Object> list) {
        List list2;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (next instanceof List) {
                list2 = (List) next;
            } else {
                list2 = p.e(next);
            }
            boolean unused = v.x(arrayList, list2);
        }
        return arrayList;
    }

    public Object f(Object obj, Object obj2) {
        return a(a.c(obj));
    }
}
