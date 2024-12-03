package pl;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import ml.b;
import p004do.d;
import ql.a;

public final class c implements b, a {

    /* renamed from: a  reason: collision with root package name */
    public static final c f33767a = new c();

    private c() {
    }

    private final Object a(List<String> list, Object obj, Object obj2) {
        List list2;
        if (!list.isEmpty()) {
            obj2 = b(obj2, list);
        }
        if (!d(obj2, obj)) {
            return obj2;
        }
        if (obj instanceof List) {
            list2 = (List) obj;
        } else {
            list2 = null;
        }
        if (list2 != null) {
            return p004do.c.b(list2);
        }
        return null;
    }

    private final Object b(Object obj, List<String> list) {
        Map map;
        if (obj instanceof List) {
            if (list.size() == 1) {
                return ((List) obj).get(d.b((String) CollectionsKt___CollectionsKt.N(list)));
            }
            return c(list, (List) obj);
        } else if (!(obj instanceof Map)) {
            return obj;
        } else {
            Object obj2 = ((Map) obj).get(CollectionsKt___CollectionsKt.N(list));
            for (String str : CollectionsKt___CollectionsKt.G(list, 1)) {
                if (obj2 instanceof Map) {
                    map = (Map) obj2;
                } else {
                    map = null;
                }
                if (map != null) {
                    obj2 = map.get(str);
                } else {
                    obj2 = null;
                }
            }
            return obj2;
        }
    }

    private final Object c(List<String> list, List<? extends Object> list2) {
        String str = (String) CollectionsKt___CollectionsKt.P(list);
        if (str == null) {
            return null;
        }
        Object Q = CollectionsKt___CollectionsKt.Q(list2, d.b(str));
        if (Q instanceof List) {
            return f33767a.c(list.subList(1, list.size()), (List) Q);
        }
        return CollectionsKt___CollectionsKt.Q(list2, d.b(str));
    }

    private final boolean d(Object obj, Object obj2) {
        if ((j.b(obj, obj2) || obj == null) && (obj2 instanceof List) && ((List) obj2).size() > 1) {
            return true;
        }
        return false;
    }

    public List<String> e(Object obj) {
        return a.C0395a.b(this, obj);
    }

    public Object f(Object obj, Object obj2) {
        List<String> e10 = e(p004do.a.c(obj));
        if (e10 != null) {
            return a(e10, obj, obj2);
        }
        return null;
    }
}
