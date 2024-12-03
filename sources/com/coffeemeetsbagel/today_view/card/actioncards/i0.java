package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;
import hb.c;

public final class i0 implements d<GetFirstEligibleActionCardUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<ActionCardRepository> f37306a;

    /* renamed from: b  reason: collision with root package name */
    private final a<a6.a> f37307b;

    /* renamed from: c  reason: collision with root package name */
    private final a<QuestionRepository> f37308c;

    /* renamed from: d  reason: collision with root package name */
    private final a<ProfileManager> f37309d;

    /* renamed from: e  reason: collision with root package name */
    private final a<PurchaseManager> f37310e;

    /* renamed from: f  reason: collision with root package name */
    private final a<c> f37311f;

    /* renamed from: g  reason: collision with root package name */
    private final a<wb.c> f37312g;

    /* renamed from: h  reason: collision with root package name */
    private final a<r> f37313h;

    public i0(a<ActionCardRepository> aVar, a<a6.a> aVar2, a<QuestionRepository> aVar3, a<ProfileManager> aVar4, a<PurchaseManager> aVar5, a<c> aVar6, a<wb.c> aVar7, a<r> aVar8) {
        this.f37306a = aVar;
        this.f37307b = aVar2;
        this.f37308c = aVar3;
        this.f37309d = aVar4;
        this.f37310e = aVar5;
        this.f37311f = aVar6;
        this.f37312g = aVar7;
        this.f37313h = aVar8;
    }

    public static i0 a(a<ActionCardRepository> aVar, a<a6.a> aVar2, a<QuestionRepository> aVar3, a<ProfileManager> aVar4, a<PurchaseManager> aVar5, a<c> aVar6, a<wb.c> aVar7, a<r> aVar8) {
        return new i0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8);
    }

    public static GetFirstEligibleActionCardUseCase c(ActionCardRepository actionCardRepository, a6.a aVar, QuestionRepository questionRepository, ProfileManager profileManager, PurchaseManager purchaseManager, c cVar, wb.c cVar2, r rVar) {
        return new GetFirstEligibleActionCardUseCase(actionCardRepository, aVar, questionRepository, profileManager, purchaseManager, cVar, cVar2, rVar);
    }

    /* renamed from: b */
    public GetFirstEligibleActionCardUseCase get() {
        return c(this.f37306a.get(), this.f37307b.get(), this.f37308c.get(), this.f37309d.get(), this.f37310e.get(), this.f37311f.get(), this.f37312g.get(), this.f37313h.get());
    }
}
