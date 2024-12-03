package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n1;
import n.a;
import n.c;

final class d1 implements SessionConfig.d {

    /* renamed from: a  reason: collision with root package name */
    static final d1 f1714a = new d1();

    d1() {
    }

    public void a(@NonNull f2<?> f2Var, @NonNull SessionConfig.b bVar) {
        SessionConfig m10 = f2Var.m((SessionConfig) null);
        Config L = n1.L();
        int l10 = SessionConfig.a().l();
        if (m10 != null) {
            l10 = m10.l();
            bVar.a(m10.b());
            bVar.c(m10.i());
            bVar.b(m10.g());
            L = m10.d();
        }
        bVar.r(L);
        a aVar = new a(f2Var);
        bVar.t(aVar.O(l10));
        bVar.e(aVar.P(h1.b()));
        bVar.j(aVar.S(g1.b()));
        bVar.d(m1.d(aVar.R(j0.c())));
        i1 O = i1.O();
        O.p(a.G, aVar.L(c.e()));
        O.p(a.I, aVar.Q((String) null));
        O.p(a.C, Long.valueOf(aVar.T(-1)));
        bVar.g(O);
        bVar.g(aVar.M());
    }
}
