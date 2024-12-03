package rj;

import java.util.concurrent.Callable;
import qj.v;
import vj.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile j<Callable<v>, v> f33800a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile j<v, v> f33801b;

    static <T, R> R a(j<T, R> jVar, T t10) {
        try {
            return jVar.apply(t10);
        } catch (Throwable th2) {
            throw uj.a.a(th2);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [vj.j<java.util.concurrent.Callable<qj.v>, qj.v>, vj.j] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static qj.v b(vj.j<java.util.concurrent.Callable<qj.v>, qj.v> r0, java.util.concurrent.Callable<qj.v> r1) {
        /*
            java.lang.Object r0 = a(r0, r1)
            qj.v r0 = (qj.v) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Scheduler Callable returned null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rj.a.b(vj.j, java.util.concurrent.Callable):qj.v");
    }

    static v c(Callable<v> callable) {
        try {
            v call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th2) {
            throw uj.a.a(th2);
        }
    }

    public static v d(Callable<v> callable) {
        if (callable != null) {
            j<Callable<v>, v> jVar = f33800a;
            if (jVar == null) {
                return c(callable);
            }
            return b(jVar, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static v e(v vVar) {
        if (vVar != null) {
            j jVar = f33801b;
            if (jVar == null) {
                return vVar;
            }
            return (v) a(jVar, vVar);
        }
        throw new NullPointerException("scheduler == null");
    }
}
