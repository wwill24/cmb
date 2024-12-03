package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.likes_you.b;
import com.coffeemeetsbagel.likes_you.f;
import com.coffeemeetsbagel.likes_you.h;
import com.coffeemeetsbagel.likes_you.m;
import com.coffeemeetsbagel.match.b0;
import com.coffeemeetsbagel.match.u;
import fj.d;
import fk.a;
import ma.e;
import u6.g;
import u6.i;
import u6.k;

public final class z implements d<LikesYouMatchRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<g> f12614a;

    /* renamed from: b  reason: collision with root package name */
    private final a<u> f12615b;

    /* renamed from: c  reason: collision with root package name */
    private final a<cb.a> f12616c;

    /* renamed from: d  reason: collision with root package name */
    private final a<k> f12617d;

    /* renamed from: e  reason: collision with root package name */
    private final a<i> f12618e;

    /* renamed from: f  reason: collision with root package name */
    private final a<b0> f12619f;

    /* renamed from: g  reason: collision with root package name */
    private final a<za.a> f12620g;

    /* renamed from: h  reason: collision with root package name */
    private final a<e> f12621h;

    /* renamed from: i  reason: collision with root package name */
    private final a<b> f12622i;

    /* renamed from: j  reason: collision with root package name */
    private final a<h> f12623j;

    /* renamed from: k  reason: collision with root package name */
    private final a<m> f12624k;

    /* renamed from: l  reason: collision with root package name */
    private final a<f> f12625l;

    public z(a<g> aVar, a<u> aVar2, a<cb.a> aVar3, a<k> aVar4, a<i> aVar5, a<b0> aVar6, a<za.a> aVar7, a<e> aVar8, a<b> aVar9, a<h> aVar10, a<m> aVar11, a<f> aVar12) {
        this.f12614a = aVar;
        this.f12615b = aVar2;
        this.f12616c = aVar3;
        this.f12617d = aVar4;
        this.f12618e = aVar5;
        this.f12619f = aVar6;
        this.f12620g = aVar7;
        this.f12621h = aVar8;
        this.f12622i = aVar9;
        this.f12623j = aVar10;
        this.f12624k = aVar11;
        this.f12625l = aVar12;
    }

    public static z a(a<g> aVar, a<u> aVar2, a<cb.a> aVar3, a<k> aVar4, a<i> aVar5, a<b0> aVar6, a<za.a> aVar7, a<e> aVar8, a<b> aVar9, a<h> aVar10, a<m> aVar11, a<f> aVar12) {
        return new z(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12);
    }

    public static LikesYouMatchRepository c(g gVar, u uVar, cb.a aVar, k kVar, i iVar, b0 b0Var, za.a aVar2, e eVar, b bVar, h hVar, m mVar, f fVar) {
        return new LikesYouMatchRepository(gVar, uVar, aVar, kVar, iVar, b0Var, aVar2, eVar, bVar, hVar, mVar, fVar);
    }

    /* renamed from: b */
    public LikesYouMatchRepository get() {
        return c(this.f12614a.get(), this.f12615b.get(), this.f12616c.get(), this.f12617d.get(), this.f12618e.get(), this.f12619f.get(), this.f12620g.get(), this.f12621h.get(), this.f12622i.get(), this.f12623j.get(), this.f12624k.get(), this.f12625l.get());
    }
}
