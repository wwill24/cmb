package com.coffeemeetsbagel.subscription_dialog.variants_carousel;

import com.jakewharton.rxrelay2.b;
import com.leanplum.internal.Constants;
import j5.x;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.q;
import vb.d;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final b<d> f37102a;

    /* renamed from: b  reason: collision with root package name */
    private final b<List<d>> f37103b;

    /* renamed from: c  reason: collision with root package name */
    private final b<x> f37104c;

    public n() {
        b<d> C0 = b.C0();
        j.f(C0, "create()");
        this.f37102a = C0;
        b<List<d>> C02 = b.C0();
        j.f(C02, "create()");
        this.f37103b = C02;
        b<x> C03 = b.C0();
        j.f(C03, "create()");
        this.f37104c = C03;
    }

    public final void a() {
        this.f37104c.accept(x.a());
    }

    public final void b(d dVar) {
        j.g(dVar, "variant");
        this.f37102a.accept(dVar);
    }

    public final void c(List<d> list) {
        j.g(list, Constants.Keys.VARIANTS);
        this.f37103b.accept(list);
    }

    public final q<List<d>> d() {
        q<List<d>> P = this.f37103b.P();
        j.f(P, "variantsLoadedRelay.hide()");
        return P;
    }

    public final q<x> e() {
        q<x> P = this.f37104c.P();
        j.f(P, "variantsErrorRelay.hide()");
        return P;
    }

    public final q<d> f() {
        q<d> P = this.f37102a.P();
        j.f(P, "variantSelectedRelay.hide()");
        return P;
    }
}
