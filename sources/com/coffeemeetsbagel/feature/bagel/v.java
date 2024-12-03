package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.match.BagelRepository;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import fj.d;
import fk.a;

public final class v implements d<GetLastPassedBagelUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<BagelRepository> f12794a;

    /* renamed from: b  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f12795b;

    public v(a<BagelRepository> aVar, a<ProfileRepositoryV2> aVar2) {
        this.f12794a = aVar;
        this.f12795b = aVar2;
    }

    public static v a(a<BagelRepository> aVar, a<ProfileRepositoryV2> aVar2) {
        return new v(aVar, aVar2);
    }

    public static GetLastPassedBagelUseCase c(BagelRepository bagelRepository, ProfileRepositoryV2 profileRepositoryV2) {
        return new GetLastPassedBagelUseCase(bagelRepository, profileRepositoryV2);
    }

    /* renamed from: b */
    public GetLastPassedBagelUseCase get() {
        return c(this.f12794a.get(), this.f12795b.get());
    }
}
