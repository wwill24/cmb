package io.sentry;

import io.sentry.protocol.o;
import io.sentry.protocol.v;
import io.sentry.protocol.x;
import org.jetbrains.annotations.ApiStatus;

public interface g0 {
    o A(Throwable th2, w wVar);

    @ApiStatus.Internal
    o B(v vVar, p4 p4Var, w wVar, z1 z1Var);

    void C();

    void a(String str, String str2);

    g0 clone();

    void close();

    SentryOptions getOptions();

    boolean isEnabled();

    void o(long j10);

    void p(x xVar);

    void q(d dVar) {
        t(dVar, new w());
    }

    o r(w2 w2Var, w wVar);

    @ApiStatus.Internal
    o s(v vVar, p4 p4Var, w wVar) {
        return B(vVar, p4Var, wVar, (z1) null);
    }

    void t(d dVar, w wVar);

    void u(f2 f2Var);

    @ApiStatus.Internal
    void v(Throwable th2, m0 m0Var, String str);

    void w();

    o x(p3 p3Var, w wVar);

    @ApiStatus.Internal
    n0 y(s4 s4Var, u4 u4Var);

    o z(Throwable th2) {
        return A(th2, new w());
    }
}
