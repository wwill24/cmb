package com.coffeemeetsbagel.experiment;

import fj.d;
import fj.g;
import fk.a;
import hb.c;

public final class b implements d<FeatureFlagRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a f12639a;

    /* renamed from: b  reason: collision with root package name */
    private final a<s> f12640b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c> f12641c;

    /* renamed from: d  reason: collision with root package name */
    private final a<j7.a> f12642d;

    public b(a aVar, a<s> aVar2, a<c> aVar3, a<j7.a> aVar4) {
        this.f12639a = aVar;
        this.f12640b = aVar2;
        this.f12641c = aVar3;
        this.f12642d = aVar4;
    }

    public static b a(a aVar, a<s> aVar2, a<c> aVar3, a<j7.a> aVar4) {
        return new b(aVar, aVar2, aVar3, aVar4);
    }

    public static FeatureFlagRepository b(a aVar, s sVar, c cVar, j7.a aVar2) {
        return (FeatureFlagRepository) g.e(aVar.a(sVar, cVar, aVar2));
    }

    /* renamed from: c */
    public FeatureFlagRepository get() {
        return b(this.f12639a, this.f12640b.get(), this.f12641c.get(), this.f12642d.get());
    }
}
