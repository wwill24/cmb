package com.coffeemeetsbagel.suggested_history;

import com.coffeemeetsbagel.match.BagelRepository;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import fj.d;
import fk.a;

public final class i implements d<GetHistoryBagelUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<BagelRepository> f37122a;

    /* renamed from: b  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f37123b;

    public i(a<BagelRepository> aVar, a<ProfileRepositoryV2> aVar2) {
        this.f37122a = aVar;
        this.f37123b = aVar2;
    }

    public static i a(a<BagelRepository> aVar, a<ProfileRepositoryV2> aVar2) {
        return new i(aVar, aVar2);
    }

    public static GetHistoryBagelUseCase c(BagelRepository bagelRepository, ProfileRepositoryV2 profileRepositoryV2) {
        return new GetHistoryBagelUseCase(bagelRepository, profileRepositoryV2);
    }

    /* renamed from: b */
    public GetHistoryBagelUseCase get() {
        return c(this.f37122a.get(), this.f37123b.get());
    }
}
