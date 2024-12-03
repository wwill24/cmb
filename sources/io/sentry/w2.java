package io.sentry;

import io.sentry.protocol.m;
import io.sentry.protocol.o;
import io.sentry.util.l;
import java.io.IOException;
import java.util.ArrayList;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class w2 {

    /* renamed from: a  reason: collision with root package name */
    private final x2 f31782a;

    /* renamed from: b  reason: collision with root package name */
    private final Iterable<n3> f31783b;

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Iterable<io.sentry.n3>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public w2(io.sentry.x2 r2, java.lang.Iterable<io.sentry.n3> r3) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "SentryEnvelopeHeader is required."
            java.lang.Object r2 = io.sentry.util.l.c(r2, r0)
            io.sentry.x2 r2 = (io.sentry.x2) r2
            r1.f31782a = r2
            java.lang.String r2 = "SentryEnvelope items are required."
            java.lang.Object r2 = io.sentry.util.l.c(r3, r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r1.f31783b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.w2.<init>(io.sentry.x2, java.lang.Iterable):void");
    }

    public static w2 a(l0 l0Var, Session session, m mVar) throws IOException {
        l.c(l0Var, "Serializer is required.");
        l.c(session, "session is required.");
        return new w2((o) null, mVar, n3.u(l0Var, session));
    }

    public x2 b() {
        return this.f31782a;
    }

    public Iterable<n3> c() {
        return this.f31783b;
    }

    public w2(o oVar, m mVar, n3 n3Var) {
        l.c(n3Var, "SentryEnvelopeItem is required.");
        this.f31782a = new x2(oVar, mVar);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(n3Var);
        this.f31783b = arrayList;
    }
}
