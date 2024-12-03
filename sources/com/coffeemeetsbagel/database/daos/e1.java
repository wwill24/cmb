package com.coffeemeetsbagel.database.daos;

import ja.c;
import kotlin.jvm.internal.j;
import qj.h;
import u6.q;

public abstract class e1 implements l<c>, q {
    public c a() {
        return g();
    }

    public int c(c cVar) {
        j.g(cVar, "user");
        int r10 = r(cVar);
        if (r10 != 0) {
            return r10;
        }
        q(cVar);
        return r10 + 1;
    }

    public int f(String str, String str2) {
        j.g(str, "appsFlyerId");
        j.g(str2, "profileId");
        return j(str, str2);
    }

    public abstract c g();

    public h<c> getUser() {
        return i();
    }

    public abstract h<c> i();

    public abstract int j(String str, String str2);
}
