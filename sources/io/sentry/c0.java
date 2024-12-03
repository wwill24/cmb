package io.sentry;

import io.sentry.protocol.o;
import io.sentry.protocol.v;
import io.sentry.protocol.x;
import org.jetbrains.annotations.ApiStatus;

public final class c0 implements g0 {

    /* renamed from: a  reason: collision with root package name */
    private static final c0 f31156a = new c0();

    private c0() {
    }

    public static c0 b() {
        return f31156a;
    }

    public o A(Throwable th2, w wVar) {
        return n2.f(th2, wVar);
    }

    public o B(v vVar, p4 p4Var, w wVar, z1 z1Var) {
        return n2.k().B(vVar, p4Var, wVar, z1Var);
    }

    public void C() {
        n2.s();
    }

    public void a(String str, String str2) {
        n2.q(str, str2);
    }

    public void close() {
        n2.g();
    }

    public SentryOptions getOptions() {
        return n2.k().getOptions();
    }

    public boolean isEnabled() {
        return n2.o();
    }

    public void o(long j10) {
        n2.j(j10);
    }

    public void p(x xVar) {
        n2.r(xVar);
    }

    @ApiStatus.Internal
    public o r(w2 w2Var, w wVar) {
        return n2.k().r(w2Var, wVar);
    }

    public void t(d dVar, w wVar) {
        n2.b(dVar, wVar);
    }

    public void u(f2 f2Var) {
        n2.h(f2Var);
    }

    public void v(Throwable th2, m0 m0Var, String str) {
        n2.k().v(th2, m0Var, str);
    }

    public void w() {
        n2.i();
    }

    public o x(p3 p3Var, w wVar) {
        return n2.d(p3Var, wVar);
    }

    public n0 y(s4 s4Var, u4 u4Var) {
        return n2.t(s4Var, u4Var);
    }

    public g0 clone() {
        return n2.k().clone();
    }
}
