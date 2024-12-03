package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;
import rn.a;
import x6.b;
import x6.d;

public abstract class BaseRepository<DbType, NetworkResponseType> {
    /* access modifiers changed from: private */
    public final h<DbType> g() {
        h<DbType> O = f().D(new h(new BaseRepository$fetchFromNetworkAndSaveToDb$1(this))).r(new i(new BaseRepository$fetchFromNetworkAndSaveToDb$2(this))).O();
        j.f(O, "private fun fetchFromNet…        .toFlowable()\n  }");
        return O;
    }

    /* access modifiers changed from: private */
    public static final Object h(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final a k(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final h l(Throwable th2) {
        j.g(th2, "it");
        return h.X(new b(th2));
    }

    /* access modifiers changed from: protected */
    public abstract w<NetworkResponseType> f();

    public final h<d<DbType>> j() {
        h<d<DbType>> a02 = m().M(new f(new BaseRepository$getRepository$1(this))).g0(new g()).o0(dk.a.c()).a0(sj.a.a());
        j.f(a02, "DbType, NetworkResponseT…edulers.mainThread())\n  }");
        return a02;
    }

    /* access modifiers changed from: protected */
    public abstract h<DbType> m();

    /* access modifiers changed from: protected */
    public abstract DbType n(NetworkResponseType networkresponsetype);

    /* access modifiers changed from: protected */
    public abstract void o(DbType dbtype);

    /* access modifiers changed from: protected */
    public abstract boolean p(DbType dbtype);
}
