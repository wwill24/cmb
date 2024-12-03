package wn;

import gk.g;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.j;
import ml.b;
import p004do.a;
import wn.k;

public final class i implements b, m {

    /* renamed from: a  reason: collision with root package name */
    public static final i f42496a = new i();

    private i() {
    }

    public Object f(Object obj, Object obj2) {
        Object obj3;
        List<Object> c10 = a.c(obj);
        try {
            Result.a aVar = Result.f32010a;
            Object obj4 = c10.get(0);
            j.e(obj4, "null cannot be cast to non-null type kotlin.String");
            Object obj5 = c10.get(1);
            j.e(obj5, "null cannot be cast to non-null type kotlin.String");
            Object obj6 = c10.get(2);
            j.e(obj6, "null cannot be cast to non-null type kotlin.String");
            j jVar = new j((String) obj4, (String) obj5, (String) obj6);
            k.a aVar2 = k.f42500a;
            Object obj7 = c10.get(3);
            j.e(obj7, "null cannot be cast to non-null type kotlin.String");
            obj3 = Result.b(aVar2.a((String) obj7, jVar).invoke());
        } catch (Throwable th2) {
            Result.a aVar3 = Result.f32010a;
            obj3 = Result.b(g.a(th2));
        }
        if (Result.e(obj3) == null) {
            return obj3;
        }
        return null;
    }
}
