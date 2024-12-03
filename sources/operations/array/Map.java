package operations.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import ml.a;
import operations.array.b;

public final class Map implements a, b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f33480a = new Map();

    private Map() {
    }

    /* access modifiers changed from: private */
    public final List<Object> h(ol.a aVar, f fVar) {
        List<Object> b10 = aVar.b();
        if (b10 == null) {
            b10 = q.j();
        }
        ArrayList arrayList = new ArrayList(r.t(b10, 10));
        Iterator<T> it = b10.iterator();
        while (it.hasNext()) {
            arrayList.add(f33480a.i(fVar, it.next(), aVar.a(), aVar.c()));
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.a(r3, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object i(defpackage.f r1, java.lang.Object r2, java.util.Map<java.lang.String, ? extends java.lang.Object> r3, java.lang.Object r4) {
        /*
            r0 = this;
            if (r3 == 0) goto L_0x000a
            java.lang.Object r1 = r1.a(r3, r2)
            if (r1 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            r4 = r1
        L_0x000a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: operations.array.Map.i(f, java.lang.Object, java.util.Map, java.lang.Object):java.lang.Object");
    }

    public Object a(java.util.Map<String, ? extends Object> map, List<? extends Object> list) {
        return b.a.b(this, map, list);
    }

    public Object b(Object obj, Object obj2, f fVar, Function2<? super ol.a, ? super f, ? extends Object> function2) {
        return b.a.c(this, obj, obj2, fVar, function2);
    }

    public ol.a c(List<? extends Object> list, Object obj, f fVar) {
        return b.a.a(this, list, obj, fVar);
    }

    public Object d(Object obj, Object obj2, f fVar) {
        j.g(fVar, "evaluator");
        return b(obj, obj2, fVar, new Map$evaluateLogic$1(this));
    }

    public List<Object> e(List<? extends Object> list, Object obj, f fVar) {
        return b.a.d(this, list, obj, fVar);
    }
}
