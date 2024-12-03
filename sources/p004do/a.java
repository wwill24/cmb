package p004do;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.j;

/* renamed from: do.a  reason: invalid package */
public final class a {
    private static final Comparable<?> a(Object obj) {
        if (obj instanceof Comparable) {
            return (Comparable) obj;
        }
        if (obj instanceof List) {
            return new xn.a((List) obj);
        }
        return null;
    }

    public static final List<Double> b(Object obj) {
        return e(c(obj));
    }

    public static final List<Object> c(Object obj) {
        List list;
        if (obj instanceof List) {
            list = (List) obj;
        } else {
            list = null;
        }
        if (list != null) {
            return new xn.a(list);
        }
        return new xn.a(p.e(obj));
    }

    public static final List<Comparable<?>> d(List<? extends Object> list) {
        j.g(list, "<this>");
        List<Object> c10 = c(list);
        ArrayList arrayList = new ArrayList(r.t(c10, 10));
        Iterator<T> it = c10.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    private static final List<Double> e(List<? extends Object> list) {
        Double d10;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (T next : list) {
            if (next instanceof Number) {
                d10 = Double.valueOf(((Number) next).doubleValue());
            } else if (next instanceof String) {
                d10 = p.i((String) next);
            } else {
                d10 = null;
            }
            arrayList.add(d10);
        }
        return arrayList;
    }

    public static final boolean f(Object obj) {
        Map map;
        boolean z10;
        if (obj instanceof Map) {
            map = (Map) obj;
        } else {
            map = null;
        }
        if (map == null || !(!map.isEmpty())) {
            return false;
        }
        Set keySet = map.keySet();
        if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
            Iterator it = keySet.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!(it.next() instanceof String)) {
                        z10 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z10 = true;
        if (z10) {
            return true;
        }
        return false;
    }

    public static final boolean g(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            return list.size() == 1 && CollectionsKt___CollectionsKt.N(list) == null;
        }
    }

    public static final String h(Object obj) {
        String obj2 = obj != null ? obj.toString() : null;
        return obj2 == null ? "" : obj2;
    }
}
