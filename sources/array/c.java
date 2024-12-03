package array;

import gk.g;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ml.b;
import p004do.a;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final c f7659a = new c();

    private c() {
    }

    private final Integer a(List<? extends Object> list) {
        boolean z10;
        Object obj = list.get(4);
        j.e(obj, "null cannot be cast to non-null type kotlin.Number");
        Number number = (Number) obj;
        if (number.doubleValue() == ((double) number.intValue())) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            number = null;
        }
        if (number != null) {
            return Integer.valueOf(number.intValue());
        }
        return null;
    }

    private final String b(d dVar) {
        return CollectionsKt___CollectionsKt.W(dVar.a(), dVar.e(), dVar.d(), dVar.c(), dVar.b(), dVar.f(), (Function1) null, 32, (Object) null);
    }

    private final d c(List<? extends Object> list) {
        Object obj;
        d dVar;
        try {
            Result.a aVar = Result.f32010a;
            Integer a10 = f7659a.a(list);
            if (a10 != null) {
                int intValue = a10.intValue();
                List<Object> c10 = a.c(list.get(0));
                Object obj2 = list.get(1);
                j.e(obj2, "null cannot be cast to non-null type kotlin.String");
                Object obj3 = list.get(2);
                j.e(obj3, "null cannot be cast to non-null type kotlin.String");
                Object obj4 = list.get(3);
                j.e(obj4, "null cannot be cast to non-null type kotlin.String");
                Object obj5 = list.get(5);
                j.e(obj5, "null cannot be cast to non-null type kotlin.String");
                dVar = new d(c10, (String) obj2, (String) obj3, (String) obj4, intValue, (String) obj5);
            } else {
                dVar = null;
            }
            obj = Result.b(dVar);
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f32010a;
            obj = Result.b(g.a(th2));
        }
        if (Result.e(obj) == null) {
            return (d) obj;
        }
        return null;
    }

    public Object f(Object obj, Object obj2) {
        d c10 = c(a.c(obj));
        if (c10 != null) {
            return b(c10);
        }
        return null;
    }
}
