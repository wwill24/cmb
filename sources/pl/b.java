package pl;

import java.util.List;
import p004do.c;
import p004do.d;

public final class b implements ml.b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f33766a = new b();

    private b() {
    }

    public Object f(Object obj, Object obj2) {
        List list;
        long j10;
        List list2;
        Object obj3;
        List list3;
        boolean z10;
        Object P;
        String obj4;
        boolean z11 = obj instanceof List;
        List<Object> list4 = null;
        if (z11) {
            list = (List) obj;
        } else {
            list = null;
        }
        if (list == null || (P = CollectionsKt___CollectionsKt.P(list)) == null || (obj4 = P.toString()) == null) {
            j10 = 0;
        } else {
            j10 = d.c(obj4);
        }
        if (z11) {
            list2 = (List) obj;
        } else {
            list2 = null;
        }
        if (list2 != null) {
            obj3 = c.b(list2);
        } else {
            obj3 = null;
        }
        if (obj3 instanceof List) {
            list3 = (List) obj3;
        } else {
            list3 = null;
        }
        if (list3 == null) {
            list3 = q.j();
        }
        List<Object> a10 = a.f33765a.f(list3, obj2);
        if (((long) (list3.size() - a10.size())) < j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            list4 = a10;
        }
        if (list4 == null) {
            return q.j();
        }
        return list4;
    }
}
