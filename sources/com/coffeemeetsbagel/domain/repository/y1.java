package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.google_play.CmbBillingClient;
import fj.d;
import fk.a;
import ma.j;
import u6.b;
import u6.c;
import u6.o;
import u6.p;

public final class y1 implements d<SubscriptionRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbBillingClient> f12605a;

    /* renamed from: b  reason: collision with root package name */
    private final a<j> f12606b;

    /* renamed from: c  reason: collision with root package name */
    private final a<b> f12607c;

    /* renamed from: d  reason: collision with root package name */
    private final a<c> f12608d;

    /* renamed from: e  reason: collision with root package name */
    private final a<p> f12609e;

    /* renamed from: f  reason: collision with root package name */
    private final a<o> f12610f;

    /* renamed from: g  reason: collision with root package name */
    private final a<UserRepository> f12611g;

    /* renamed from: h  reason: collision with root package name */
    private final a<hb.c> f12612h;

    public y1(a<CmbBillingClient> aVar, a<j> aVar2, a<b> aVar3, a<c> aVar4, a<p> aVar5, a<o> aVar6, a<UserRepository> aVar7, a<hb.c> aVar8) {
        this.f12605a = aVar;
        this.f12606b = aVar2;
        this.f12607c = aVar3;
        this.f12608d = aVar4;
        this.f12609e = aVar5;
        this.f12610f = aVar6;
        this.f12611g = aVar7;
        this.f12612h = aVar8;
    }

    public static y1 a(a<CmbBillingClient> aVar, a<j> aVar2, a<b> aVar3, a<c> aVar4, a<p> aVar5, a<o> aVar6, a<UserRepository> aVar7, a<hb.c> aVar8) {
        return new y1(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8);
    }

    public static SubscriptionRepository c(CmbBillingClient cmbBillingClient, j jVar, b bVar, c cVar, p pVar, o oVar, UserRepository userRepository, hb.c cVar2) {
        return new SubscriptionRepository(cmbBillingClient, jVar, bVar, cVar, pVar, oVar, userRepository, cVar2);
    }

    /* renamed from: b */
    public SubscriptionRepository get() {
        return c(this.f12605a.get(), this.f12606b.get(), this.f12607c.get(), this.f12608d.get(), this.f12609e.get(), this.f12610f.get(), this.f12611g.get(), this.f12612h.get());
    }
}
