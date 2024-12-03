package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.match.BagelRepository;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import fj.d;
import fk.a;

public final class b0 implements d<UpdateBagelLocalUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<y6.a> f12704a;

    /* renamed from: b  reason: collision with root package name */
    private final a<BagelRepository> f12705b;

    /* renamed from: c  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f12706c;

    public b0(a<y6.a> aVar, a<BagelRepository> aVar2, a<ProfileRepositoryV2> aVar3) {
        this.f12704a = aVar;
        this.f12705b = aVar2;
        this.f12706c = aVar3;
    }

    public static b0 a(a<y6.a> aVar, a<BagelRepository> aVar2, a<ProfileRepositoryV2> aVar3) {
        return new b0(aVar, aVar2, aVar3);
    }

    public static UpdateBagelLocalUseCase c(y6.a aVar, BagelRepository bagelRepository, ProfileRepositoryV2 profileRepositoryV2) {
        return new UpdateBagelLocalUseCase(aVar, bagelRepository, profileRepositoryV2);
    }

    /* renamed from: b */
    public UpdateBagelLocalUseCase get() {
        return c(this.f12704a.get(), this.f12705b.get(), this.f12706c.get());
    }
}
