package operations.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import ml.a;
import operations.array.b;
import tl.d;

public final class Filter implements a, b, d {

    /* renamed from: a  reason: collision with root package name */
    public static final Filter f33479a = new Filter();

    private Filter() {
    }

    /* access modifiers changed from: private */
    public final List<Object> h(ol.a aVar, f fVar) {
        List<Object> b10 = aVar.b();
        if (b10 == null) {
            b10 = q.j();
        }
        ArrayList arrayList = new ArrayList();
        for (T next : b10) {
            if (f33479a.i(fVar, next, aVar.a(), aVar.c())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private final boolean i(f fVar, Object obj, Map<String, ? extends Object> map, Object obj2) {
        Object a10;
        if (!(map == null || (a10 = fVar.a(map, obj)) == null)) {
            obj2 = a10;
        }
        return j(obj2);
    }

    public Object a(Map<String, ? extends Object> map, List<? extends Object> list) {
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
        return b(obj, obj2, fVar, new Filter$evaluateLogic$1(this));
    }

    public List<Object> e(List<? extends Object> list, Object obj, f fVar) {
        return b.a.d(this, list, obj, fVar);
    }

    public boolean j(Object obj) {
        return d.a.a(this, obj);
    }
}
