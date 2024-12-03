package io.sentry;

import io.sentry.protocol.o;
import io.sentry.protocol.v;
import org.jetbrains.annotations.ApiStatus;

public interface j0 {
    o a(p3 p3Var, e2 e2Var, w wVar);

    void b(Session session, w wVar);

    @ApiStatus.Internal
    o c(v vVar, p4 p4Var, e2 e2Var, w wVar, z1 z1Var);

    void close();

    void o(long j10);

    o r(w2 w2Var, w wVar);
}
