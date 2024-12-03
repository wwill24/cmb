package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.feature.chatlist.GetBagelUseCase;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import f6.f2;
import fj.d;
import fj.g;
import fk.a;
import u6.e;

public final class d0 implements d<GetBagelUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f7.a> f11083a;

    /* renamed from: b  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f11084b;

    /* renamed from: c  reason: collision with root package name */
    private final a<f2> f11085c;

    /* renamed from: d  reason: collision with root package name */
    private final a<e> f11086d;

    public d0(a<f7.a> aVar, a<ProfileRepositoryV2> aVar2, a<f2> aVar3, a<e> aVar4) {
        this.f11083a = aVar;
        this.f11084b = aVar2;
        this.f11085c = aVar3;
        this.f11086d = aVar4;
    }

    public static d0 a(a<f7.a> aVar, a<ProfileRepositoryV2> aVar2, a<f2> aVar3, a<e> aVar4) {
        return new d0(aVar, aVar2, aVar3, aVar4);
    }

    public static GetBagelUseCase c(f7.a aVar, ProfileRepositoryV2 profileRepositoryV2, f2 f2Var, e eVar) {
        return (GetBagelUseCase) g.e(c.A(aVar, profileRepositoryV2, f2Var, eVar));
    }

    /* renamed from: b */
    public GetBagelUseCase get() {
        return c(this.f11083a.get(), this.f11084b.get(), this.f11085c.get(), this.f11086d.get());
    }
}
