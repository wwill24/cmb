package com.uber.autodispose;

import qj.a;
import qj.f;

public final class s {
    public static a b(q qVar) {
        return a.o(new r(qVar));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ f c(q qVar) throws Exception {
        try {
            return qVar.s();
        } catch (OutsideScopeException e10) {
            vj.f<? super OutsideScopeException> a10 = h.a();
            if (a10 == null) {
                return a.v(e10);
            }
            a10.accept(e10);
            return a.m();
        }
    }
}
