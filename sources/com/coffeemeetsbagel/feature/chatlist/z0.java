package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.feature.chatlist.h;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.Bagel;
import java.util.List;

class z0 implements h, j.b {

    /* renamed from: a  reason: collision with root package name */
    private j f12996a;

    /* renamed from: b  reason: collision with root package name */
    private h.a f12997b;

    z0(j jVar) {
        this.f12996a = jVar;
    }

    public void a(h.a aVar) {
        this.f12997b = aVar;
        this.f12996a.r(this);
        this.f12996a.s();
    }

    public void o0() {
        h.a aVar;
        this.f12996a.F(this);
        List<Bagel> A = this.f12996a.A();
        if (A != null && (aVar = this.f12997b) != null) {
            aVar.a(A);
        }
    }
}
