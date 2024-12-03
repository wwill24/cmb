package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import fj.d;
import fk.a;
import u6.e;

public final class v0 implements d<GetBagelConnectionUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<m5.a> f12982a;

    /* renamed from: b  reason: collision with root package name */
    private final a<SubscriptionRepository> f12983b;

    /* renamed from: c  reason: collision with root package name */
    private final a<LikesYouMatchRepository> f12984c;

    /* renamed from: d  reason: collision with root package name */
    private final a<e> f12985d;

    /* renamed from: e  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f12986e;

    /* renamed from: f  reason: collision with root package name */
    private final a<FeatureFlagRepository> f12987f;

    public v0(a<m5.a> aVar, a<SubscriptionRepository> aVar2, a<LikesYouMatchRepository> aVar3, a<e> aVar4, a<ProfileRepositoryV2> aVar5, a<FeatureFlagRepository> aVar6) {
        this.f12982a = aVar;
        this.f12983b = aVar2;
        this.f12984c = aVar3;
        this.f12985d = aVar4;
        this.f12986e = aVar5;
        this.f12987f = aVar6;
    }

    public static v0 a(a<m5.a> aVar, a<SubscriptionRepository> aVar2, a<LikesYouMatchRepository> aVar3, a<e> aVar4, a<ProfileRepositoryV2> aVar5, a<FeatureFlagRepository> aVar6) {
        return new v0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static GetBagelConnectionUseCase c(m5.a aVar, SubscriptionRepository subscriptionRepository, LikesYouMatchRepository likesYouMatchRepository, e eVar, ProfileRepositoryV2 profileRepositoryV2, FeatureFlagRepository featureFlagRepository) {
        return new GetBagelConnectionUseCase(aVar, subscriptionRepository, likesYouMatchRepository, eVar, profileRepositoryV2, featureFlagRepository);
    }

    /* renamed from: b */
    public GetBagelConnectionUseCase get() {
        return c(this.f12982a.get(), this.f12983b.get(), this.f12984c.get(), this.f12985d.get(), this.f12986e.get(), this.f12987f.get());
    }
}
