package io.sentry;

import io.sentry.protocol.TransactionNameSource;
import io.sentry.protocol.o;

public final class p1 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    private static final p1 f31372a = new p1();

    private p1() {
    }

    public static p1 p() {
        return f31372a;
    }

    public boolean a() {
        return true;
    }

    public void b() {
    }

    public void c(String str) {
    }

    public o d() {
        return o.f31517b;
    }

    public TransactionNameSource e() {
        return TransactionNameSource.CUSTOM;
    }

    public p4 f() {
        return new p4(o.f31517b, "");
    }

    public boolean g(u2 u2Var) {
        return false;
    }

    public String getDescription() {
        return null;
    }

    public String getName() {
        return "";
    }

    public u2 getStartDate() {
        return new w3();
    }

    public SpanStatus getStatus() {
        return null;
    }

    public void h(SpanStatus spanStatus) {
    }

    public m0 i(String str, String str2, u2 u2Var, Instrumenter instrumenter) {
        return o1.p();
    }

    public void j(String str, Number number, MeasurementUnit measurementUnit) {
    }

    public i4 k() {
        return null;
    }

    public void l() {
    }

    public j4 m() {
        return new j4(o.f31517b, l4.f31327b, "op", (l4) null, (r4) null);
    }

    public u2 n() {
        return new w3();
    }

    public void o(SpanStatus spanStatus, u2 u2Var) {
    }
}
