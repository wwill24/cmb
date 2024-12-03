package defpackage;

import defpackage.e;
import gk.g;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.internal.j;

/* renamed from: a  reason: default package */
public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final f f5a;

    public a(f fVar) {
        j.g(fVar, "evaluator");
        this.f5a = fVar;
    }

    private final e b(Map<String, ? extends Object> map, Object obj) {
        Object obj2;
        try {
            Result.a aVar = Result.f32010a;
            obj2 = Result.b(this.f5a.a(map, obj));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f32010a;
            obj2 = Result.b(g.a(th2));
        }
        if (Result.e(obj2) == null) {
            return c(obj2);
        }
        return e.a.b.f29579a;
    }

    private final e c(Object obj) {
        if (obj != null) {
            return new e.b(d(obj));
        }
        return e.a.c.f29580a;
    }

    private final Object d(Object obj) {
        boolean z10;
        boolean z11;
        if (!(obj instanceof Double)) {
            return obj;
        }
        Number number = (Number) obj;
        double doubleValue = number.doubleValue() % 1.0d;
        boolean z12 = true;
        if (doubleValue == 0.0d) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (Math.signum(doubleValue) == Math.signum(1.0d)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                doubleValue += 1.0d;
            }
        }
        if (doubleValue != 0.0d) {
            z12 = false;
        }
        if (z12) {
            return Long.valueOf((long) number.doubleValue());
        }
        return obj;
    }

    public e a(Map<String, ? extends Object> map, Object obj) {
        Map<String, ? extends Object> map2;
        e b10;
        j.g(map, "expression");
        if (!map.isEmpty()) {
            map2 = map;
        } else {
            map2 = null;
        }
        if (map2 == null || (b10 = b(map, obj)) == null) {
            return e.a.C0340a.f29578a;
        }
        return b10;
    }
}
