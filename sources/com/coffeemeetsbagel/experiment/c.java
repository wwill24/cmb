package com.coffeemeetsbagel.experiment;

import com.coffeemeetsbagel.bakery.Bakery;
import fj.d;
import fj.g;
import fk.a;

public final class c implements d<r> {

    /* renamed from: a  reason: collision with root package name */
    private final a f12643a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Bakery> f12644b;

    /* renamed from: c  reason: collision with root package name */
    private final a<FeatureFlagRepository> f12645c;

    public c(a aVar, a<Bakery> aVar2, a<FeatureFlagRepository> aVar3) {
        this.f12643a = aVar;
        this.f12644b = aVar2;
        this.f12645c = aVar3;
    }

    public static c a(a aVar, a<Bakery> aVar2, a<FeatureFlagRepository> aVar3) {
        return new c(aVar, aVar2, aVar3);
    }

    public static r b(a aVar, Bakery bakery, FeatureFlagRepository featureFlagRepository) {
        return (r) g.e(aVar.b(bakery, featureFlagRepository));
    }

    /* renamed from: c */
    public r get() {
        return b(this.f12643a, this.f12644b.get(), this.f12645c.get());
    }
}
