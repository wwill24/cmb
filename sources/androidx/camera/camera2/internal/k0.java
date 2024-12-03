package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.n1;
import n.a;

class k0 implements d0.b {

    /* renamed from: a  reason: collision with root package name */
    static final k0 f1828a = new k0();

    k0() {
    }

    public void a(@NonNull f2<?> f2Var, @NonNull d0.a aVar) {
        d0 q10 = f2Var.q((d0) null);
        Config L = n1.L();
        int g10 = d0.a().g();
        if (q10 != null) {
            g10 = q10.g();
            aVar.a(q10.b());
            L = q10.d();
        }
        aVar.p(L);
        a aVar2 = new a(f2Var);
        aVar.q(aVar2.O(g10));
        aVar.c(m1.d(aVar2.R(j0.c())));
        aVar.e(aVar2.M());
    }
}
