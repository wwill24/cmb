package io.sentry;

import io.sentry.hints.a;
import io.sentry.hints.c;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.n;
import io.sentry.protocol.v;
import io.sentry.protocol.x;
import io.sentry.util.i;
import io.sentry.util.l;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class e1 implements t, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final SentryOptions f31201a;

    /* renamed from: b  reason: collision with root package name */
    private final a4 f31202b;

    /* renamed from: c  reason: collision with root package name */
    private final q3 f31203c;

    /* renamed from: d  reason: collision with root package name */
    private volatile z f31204d = null;

    public e1(SentryOptions sentryOptions) {
        SentryOptions sentryOptions2 = (SentryOptions) l.c(sentryOptions, "The SentryOptions is required.");
        this.f31201a = sentryOptions2;
        z3 z3Var = new z3(sentryOptions2.getInAppExcludes(), sentryOptions2.getInAppIncludes());
        this.f31203c = new q3(z3Var);
        this.f31202b = new a4(z3Var, sentryOptions2);
    }

    private void C(p2 p2Var) {
        if (p2Var.M() == null) {
            p2Var.b0(this.f31201a.getServerName());
        }
        if (this.f31201a.isAttachServerName() && p2Var.M() == null) {
            c();
            if (this.f31204d != null) {
                p2Var.b0(this.f31204d.d());
            }
        }
    }

    private void E(p2 p2Var) {
        if (p2Var.N() == null) {
            p2Var.d0(new HashMap(this.f31201a.getTags()));
            return;
        }
        for (Map.Entry next : this.f31201a.getTags().entrySet()) {
            if (!p2Var.N().containsKey(next.getKey())) {
                p2Var.c0((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    private void F(p3 p3Var, w wVar) {
        if (p3Var.r0() == null) {
            ArrayList arrayList = null;
            List<n> o02 = p3Var.o0();
            if (o02 != null && !o02.isEmpty()) {
                for (n next : o02) {
                    if (!(next.g() == null || next.h() == null)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next.h());
                    }
                }
            }
            if (this.f31201a.isAttachThreads() || i.g(wVar, a.class)) {
                Object f10 = i.f(wVar);
                boolean z10 = false;
                if (f10 instanceof a) {
                    z10 = ((a) f10).a();
                }
                p3Var.z0(this.f31202b.b(arrayList, z10));
            } else if (!this.f31201a.isAttachStacktrace()) {
            } else {
                if ((o02 == null || o02.isEmpty()) && !e(wVar)) {
                    p3Var.z0(this.f31202b.a());
                }
            }
        }
    }

    private boolean G(p2 p2Var, w wVar) {
        if (i.s(wVar)) {
            return true;
        }
        this.f31201a.getLogger().c(SentryLevel.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", p2Var.G());
        return false;
    }

    private void c() {
        if (this.f31204d == null) {
            synchronized (this) {
                if (this.f31204d == null) {
                    this.f31204d = z.e();
                }
            }
        }
    }

    private boolean e(w wVar) {
        return i.g(wVar, c.class);
    }

    private void f(p2 p2Var) {
        if (!this.f31201a.isSendDefaultPii()) {
            return;
        }
        if (p2Var.Q() == null) {
            x xVar = new x();
            xVar.q("{{auto}}");
            p2Var.e0(xVar);
        } else if (p2Var.Q().m() == null) {
            p2Var.Q().q("{{auto}}");
        }
    }

    private void g(p2 p2Var) {
        x(p2Var);
        m(p2Var);
        C(p2Var);
        l(p2Var);
        y(p2Var);
        E(p2Var);
        f(p2Var);
    }

    private void h(p2 p2Var) {
        v(p2Var);
    }

    private void k(p2 p2Var) {
        if (this.f31201a.getProguardUuid() != null) {
            io.sentry.protocol.c D = p2Var.D();
            if (D == null) {
                D = new io.sentry.protocol.c();
            }
            if (D.c() == null) {
                D.d(new ArrayList());
            }
            List<DebugImage> c10 = D.c();
            if (c10 != null) {
                DebugImage debugImage = new DebugImage();
                debugImage.setType(DebugImage.PROGUARD);
                debugImage.setUuid(this.f31201a.getProguardUuid());
                c10.add(debugImage);
                p2Var.S(D);
            }
        }
    }

    private void l(p2 p2Var) {
        if (p2Var.E() == null) {
            p2Var.T(this.f31201a.getDist());
        }
    }

    private void m(p2 p2Var) {
        if (p2Var.F() == null) {
            p2Var.U(this.f31201a.getEnvironment());
        }
    }

    private void n(p3 p3Var) {
        Throwable P = p3Var.P();
        if (P != null) {
            p3Var.v0(this.f31203c.c(P));
        }
    }

    private void u(p3 p3Var) {
        Map<String, String> a10 = this.f31201a.getModulesLoader().a();
        if (a10 != null) {
            Map<String, String> q02 = p3Var.q0();
            if (q02 == null) {
                p3Var.y0(a10);
            } else {
                q02.putAll(a10);
            }
        }
    }

    private void v(p2 p2Var) {
        if (p2Var.I() == null) {
            p2Var.X("java");
        }
    }

    private void x(p2 p2Var) {
        if (p2Var.J() == null) {
            p2Var.Y(this.f31201a.getRelease());
        }
    }

    private void y(p2 p2Var) {
        if (p2Var.L() == null) {
            p2Var.a0(this.f31201a.getSdkVersion());
        }
    }

    public p3 a(p3 p3Var, w wVar) {
        h(p3Var);
        n(p3Var);
        k(p3Var);
        u(p3Var);
        if (G(p3Var, wVar)) {
            g(p3Var);
            F(p3Var, wVar);
        }
        return p3Var;
    }

    public v b(v vVar, w wVar) {
        h(vVar);
        k(vVar);
        if (G(vVar, wVar)) {
            g(vVar);
        }
        return vVar;
    }

    public void close() throws IOException {
        if (this.f31204d != null) {
            this.f31204d.c();
        }
    }
}
