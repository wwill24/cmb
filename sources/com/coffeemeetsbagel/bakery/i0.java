package com.coffeemeetsbagel.bakery;

import a7.a;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import fj.d;
import fj.g;
import hb.c;

public final class i0 implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<FirebaseContract.Analytics> f11212a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<q8.a> f11213b;

    /* renamed from: c  reason: collision with root package name */
    private final fk.a<c> f11214c;

    /* renamed from: d  reason: collision with root package name */
    private final fk.a<SubscriptionRepository> f11215d;

    /* renamed from: e  reason: collision with root package name */
    private final fk.a<UserRepository> f11216e;

    /* renamed from: f  reason: collision with root package name */
    private final fk.a<AuthenticationScopeProvider> f11217f;

    /* renamed from: g  reason: collision with root package name */
    private final fk.a<ProfileRepositoryV2> f11218g;

    public i0(fk.a<FirebaseContract.Analytics> aVar, fk.a<q8.a> aVar2, fk.a<c> aVar3, fk.a<SubscriptionRepository> aVar4, fk.a<UserRepository> aVar5, fk.a<AuthenticationScopeProvider> aVar6, fk.a<ProfileRepositoryV2> aVar7) {
        this.f11212a = aVar;
        this.f11213b = aVar2;
        this.f11214c = aVar3;
        this.f11215d = aVar4;
        this.f11216e = aVar5;
        this.f11217f = aVar6;
        this.f11218g = aVar7;
    }

    public static i0 a(fk.a<FirebaseContract.Analytics> aVar, fk.a<q8.a> aVar2, fk.a<c> aVar3, fk.a<SubscriptionRepository> aVar4, fk.a<UserRepository> aVar5, fk.a<AuthenticationScopeProvider> aVar6, fk.a<ProfileRepositoryV2> aVar7) {
        return new i0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static a c(FirebaseContract.Analytics analytics, q8.a aVar, c cVar, SubscriptionRepository subscriptionRepository, UserRepository userRepository, AuthenticationScopeProvider authenticationScopeProvider, ProfileRepositoryV2 profileRepositoryV2) {
        return (a) g.e(c.G(analytics, aVar, cVar, subscriptionRepository, userRepository, authenticationScopeProvider, profileRepositoryV2));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f11212a.get(), this.f11213b.get(), this.f11214c.get(), this.f11215d.get(), this.f11216e.get(), this.f11217f.get(), this.f11218g.get());
    }
}
