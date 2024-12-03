package array;

import array.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import ml.b;
import p004do.a;

public final class f implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final f f7667a = new f();

    private f() {
    }

    private final Object a(g gVar, Function0<? extends Object> function0, Function0<? extends Object> function02) {
        if (j.b(gVar, g.b.f7669a)) {
            return function02.invoke();
        }
        if (j.b(gVar, g.a.f7668a)) {
            return function0.invoke();
        }
        if (j.b(gVar, g.c.f7670a)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Object b(List<? extends Object> list, g gVar) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (T next : list) {
                if (next instanceof String) {
                    arrayList.add(next);
                }
            }
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        if (list != null) {
            num2 = Integer.valueOf(list.size());
        } else {
            num2 = null;
        }
        if (j.b(num, num2)) {
            if (!(list instanceof List)) {
                list = null;
            }
            if (list != null) {
                return a(gVar, new Sort$sortComparable$1(list), new Sort$sortComparable$2(list));
            }
            return null;
        }
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (T next2 : list) {
                if (next2 instanceof Boolean) {
                    arrayList2.add(next2);
                }
            }
            num3 = Integer.valueOf(arrayList2.size());
        } else {
            num3 = null;
        }
        if (list != null) {
            num4 = Integer.valueOf(list.size());
        } else {
            num4 = null;
        }
        if (j.b(num3, num4)) {
            if (!(list instanceof List)) {
                list = null;
            }
            if (list != null) {
                return a(gVar, new Sort$sortComparable$1(list), new Sort$sortComparable$2(list));
            }
            return null;
        }
        if (list != null) {
            ArrayList arrayList3 = new ArrayList();
            for (T next3 : list) {
                if (next3 instanceof Number) {
                    arrayList3.add(next3);
                }
            }
            num5 = Integer.valueOf(arrayList3.size());
        } else {
            num5 = null;
        }
        if (list != null) {
            num6 = Integer.valueOf(list.size());
        } else {
            num6 = null;
        }
        if (!j.b(num5, num6)) {
            return null;
        }
        List K = CollectionsKt___CollectionsKt.K(a.b(list));
        return a(gVar, new Sort$sortComparable$1(K), new Sort$sortComparable$2(K));
    }

    private final g c(String str) {
        if (j.b(str, "desc")) {
            return g.b.f7669a;
        }
        if (j.b(str, "asc")) {
            return g.a.f7668a;
        }
        return g.c.f7670a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object f(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.util.List r4 = p004do.a.c(r4)
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.P(r4)
            boolean r0 = r5 instanceof java.util.List
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.util.List r5 = (java.util.List) r5
            goto L_0x0011
        L_0x0010:
            r5 = r1
        L_0x0011:
            if (r5 == 0) goto L_0x0028
            array.f r0 = f7667a
            java.lang.Object r4 = p004do.c.b(r4)
            boolean r2 = r4 instanceof java.lang.String
            if (r2 == 0) goto L_0x0020
            r1 = r4
            java.lang.String r1 = (java.lang.String) r1
        L_0x0020:
            array.g r4 = r0.c(r1)
            java.lang.Object r1 = r0.b(r5, r4)
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: array.f.f(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
