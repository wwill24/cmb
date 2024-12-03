package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.match.l;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;
import ma.k;
import yb.c;

public final class t2 implements d<SuggestedRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<k> f12578a;

    /* renamed from: b  reason: collision with root package name */
    private final a<c> f12579b;

    /* renamed from: c  reason: collision with root package name */
    private final a<hb.c> f12580c;

    /* renamed from: d  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f12581d;

    /* renamed from: e  reason: collision with root package name */
    private final a<PhotoRepository> f12582e;

    /* renamed from: f  reason: collision with root package name */
    private final a<QuestionRepository> f12583f;

    /* renamed from: g  reason: collision with root package name */
    private final a<l> f12584g;

    public t2(a<k> aVar, a<c> aVar2, a<hb.c> aVar3, a<ProfileRepositoryV2> aVar4, a<PhotoRepository> aVar5, a<QuestionRepository> aVar6, a<l> aVar7) {
        this.f12578a = aVar;
        this.f12579b = aVar2;
        this.f12580c = aVar3;
        this.f12581d = aVar4;
        this.f12582e = aVar5;
        this.f12583f = aVar6;
        this.f12584g = aVar7;
    }

    public static t2 a(a<k> aVar, a<c> aVar2, a<hb.c> aVar3, a<ProfileRepositoryV2> aVar4, a<PhotoRepository> aVar5, a<QuestionRepository> aVar6, a<l> aVar7) {
        return new t2(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static SuggestedRepository c(k kVar, c cVar, hb.c cVar2, ProfileRepositoryV2 profileRepositoryV2, PhotoRepository photoRepository, QuestionRepository questionRepository, l lVar) {
        return new SuggestedRepository(kVar, cVar, cVar2, profileRepositoryV2, photoRepository, questionRepository, lVar);
    }

    /* renamed from: b */
    public SuggestedRepository get() {
        return c(this.f12578a.get(), this.f12579b.get(), this.f12580c.get(), this.f12581d.get(), this.f12582e.get(), this.f12583f.get(), this.f12584g.get());
    }
}
