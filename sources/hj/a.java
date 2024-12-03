package hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import ml.b;

public final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final b f29744a;

    public a(b bVar) {
        j.g(bVar, "operations");
        this.f29744a = bVar;
    }

    private final Object b(Object obj, Object obj2) {
        if (obj instanceof List) {
            Iterable<Object> iterable = (Iterable) obj;
            ArrayList arrayList = new ArrayList(r.t(iterable, 10));
            for (Object b10 : iterable) {
                arrayList.add(b(b10, obj2));
            }
            return arrayList;
        } else if (!(obj instanceof Map)) {
            return obj;
        } else {
            Map map = (Map) obj;
            if (map.isEmpty()) {
                return obj2;
            }
            return c(map, obj2);
        }
    }

    private final Object c(Map<?, ?> map, Object obj) {
        ArrayList arrayList;
        Object O = CollectionsKt___CollectionsKt.O(map.keySet());
        Object obj2 = map.get(O);
        if (CollectionsKt___CollectionsKt.E(this.f29744a.a().keySet(), O)) {
            ml.a aVar = this.f29744a.a().get(O);
            if (aVar != null) {
                return aVar.d(obj2, obj, this);
            }
            return null;
        }
        b d10 = d(this.f29744a.b(), O);
        if (obj2 instanceof List) {
            Iterable<Object> iterable = (Iterable) obj2;
            ArrayList arrayList2 = new ArrayList(r.t(iterable, 10));
            for (Object b10 : iterable) {
                arrayList2.add(b(b10, obj));
            }
            arrayList = arrayList2;
        } else if (obj2 instanceof Map) {
            arrayList = b(obj2, obj);
        } else {
            arrayList = b(obj2, obj);
        }
        return d10.f(arrayList, obj);
    }

    private final b d(Map<String, ? extends b> map, Object obj) {
        b bVar = (b) map.get(obj);
        if (bVar != null) {
            return bVar;
        }
        throw new JsonLogicException("Operation " + obj + " not found.");
    }

    public Object a(Map<String, ? extends Object> map, Object obj) {
        j.g(map, "expression");
        return b(map, obj);
    }
}
