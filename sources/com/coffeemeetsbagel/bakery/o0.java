package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import d7.g;
import f6.f2;
import fj.d;
import fk.a;
import t8.k;
import t8.l;

public final class o0 implements d<l> {

    /* renamed from: a  reason: collision with root package name */
    private final a<PhotoRepository> f11326a;

    /* renamed from: b  reason: collision with root package name */
    private final a<f2> f11327b;

    /* renamed from: c  reason: collision with root package name */
    private final a<y7.a> f11328c;

    /* renamed from: d  reason: collision with root package name */
    private final a<g> f11329d;

    /* renamed from: e  reason: collision with root package name */
    private final a<ProfileManager> f11330e;

    /* renamed from: f  reason: collision with root package name */
    private final a<k> f11331f;

    public o0(a<PhotoRepository> aVar, a<f2> aVar2, a<y7.a> aVar3, a<g> aVar4, a<ProfileManager> aVar5, a<k> aVar6) {
        this.f11326a = aVar;
        this.f11327b = aVar2;
        this.f11328c = aVar3;
        this.f11329d = aVar4;
        this.f11330e = aVar5;
        this.f11331f = aVar6;
    }

    public static o0 a(a<PhotoRepository> aVar, a<f2> aVar2, a<y7.a> aVar3, a<g> aVar4, a<ProfileManager> aVar5, a<k> aVar6) {
        return new o0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static l c(PhotoRepository photoRepository, f2 f2Var, y7.a aVar, g gVar, ProfileManager profileManager, k kVar) {
        return (l) fj.g.e(c.M(photoRepository, f2Var, aVar, gVar, profileManager, kVar));
    }

    /* renamed from: b */
    public l get() {
        return c(this.f11326a.get(), this.f11327b.get(), this.f11328c.get(), this.f11329d.get(), this.f11330e.get(), this.f11331f.get());
    }
}
