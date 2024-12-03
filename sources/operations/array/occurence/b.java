package operations.array.occurence;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import ml.a;
import operations.array.occurence.OccurrenceCheckOperation;

public final class b implements a, OccurrenceCheckOperation {

    /* renamed from: a  reason: collision with root package name */
    public static final b f33483a = new b();

    private b() {
    }

    public Object b(Object obj, Object obj2, f fVar, Function2<? super ol.a, ? super f, ? extends Object> function2) {
        return OccurrenceCheckOperation.DefaultImpls.f(this, obj, obj2, fVar, function2);
    }

    public ol.a c(List<? extends Object> list, Object obj, f fVar) {
        return OccurrenceCheckOperation.DefaultImpls.c(this, list, obj, fVar);
    }

    public Object d(Object obj, Object obj2, f fVar) {
        j.g(fVar, "evaluator");
        return f(obj, obj2, fVar);
    }

    public List<Object> e(List<? extends Object> list, Object obj, f fVar) {
        return OccurrenceCheckOperation.DefaultImpls.h(this, list, obj, fVar);
    }

    public Object f(Object obj, Object obj2, f fVar) {
        return OccurrenceCheckOperation.DefaultImpls.b(this, obj, obj2, fVar);
    }

    public Object g(c cVar, f fVar) {
        j.g(cVar, "data");
        j.g(fVar, "evaluator");
        Iterator<T> it = cVar.b().iterator();
        while (it.hasNext()) {
            if (f33483a.i(fVar.a(cVar.a(), it.next()))) {
                return Boolean.FALSE;
            }
        }
        return cVar.c();
    }

    /* renamed from: h */
    public Boolean a(Map<String, ? extends Object> map, List<? extends Object> list) {
        j.g(list, "expressionValues");
        return Boolean.TRUE;
    }

    public boolean i(Object obj) {
        return OccurrenceCheckOperation.DefaultImpls.i(this, obj);
    }
}
