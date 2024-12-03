package wn;

import gk.g;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.j;
import ml.b;
import p004do.a;
import wn.q;

public final class o implements b, m {

    /* renamed from: a  reason: collision with root package name */
    public static final o f42502a = new o();

    private o() {
    }

    private final String a(p pVar) {
        q b10 = pVar.b();
        if (j.b(b10, q.c.f42508a)) {
            return StringsKt__StringsKt.Z0(pVar.c(), pVar.a());
        } else if (j.b(b10, q.b.f42507a)) {
            return StringsKt__StringsKt.Y0(pVar.c(), pVar.a());
        } else if (j.b(b10, q.a.f42506a)) {
            return StringsKt__StringsKt.X0(pVar.c(), pVar.a());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final p b(List<? extends Object> list) {
        Object obj;
        try {
            Result.a aVar = Result.f32010a;
            Object obj2 = list.get(0);
            j.e(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(1);
            j.e(obj3, "null cannot be cast to non-null type kotlin.String");
            char g12 = t.g1((String) obj3);
            o oVar = f42502a;
            Object obj4 = list.get(2);
            j.e(obj4, "null cannot be cast to non-null type kotlin.String");
            obj = Result.b(new p((String) obj2, g12, oVar.c((String) obj4)));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f32010a;
            obj = Result.b(g.a(th2));
        }
        if (Result.e(obj) == null) {
            return (p) obj;
        }
        return null;
    }

    private final q c(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 100571) {
                if (hashCode != 109757538) {
                    if (hashCode == 2144573977 && str.equals("bothEnds")) {
                        return q.a.f42506a;
                    }
                } else if (str.equals("start")) {
                    return q.c.f42508a;
                }
            } else if (str.equals("end")) {
                return q.b.f42507a;
            }
        }
        throw new IllegalStateException("Invalid TrimMode value");
    }

    public Object f(Object obj, Object obj2) {
        p b10 = b(a.c(obj));
        if (b10 != null) {
            return a(b10);
        }
        return null;
    }
}
