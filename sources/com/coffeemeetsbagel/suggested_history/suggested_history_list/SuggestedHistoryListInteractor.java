package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.suggested_history.GetHistoryBagelUseCase;
import com.coffeemeetsbagel.suggested_history.j;
import com.coffeemeetsbagel.upsell_banner.i;
import com.uber.autodispose.n;
import com.uber.autodispose.t;
import ja.b;
import java.util.List;
import kotlin.jvm.functions.Function1;
import qj.b0;
import wb.c;

public final class SuggestedHistoryListInteractor extends s<SuggestedHistoryListPresenter, SuggestedHistoryListRouter> implements p {

    /* renamed from: f  reason: collision with root package name */
    private final j f37136f;

    /* renamed from: g  reason: collision with root package name */
    public UserRepository f37137g;

    /* renamed from: h  reason: collision with root package name */
    public cb.a f37138h;

    /* renamed from: j  reason: collision with root package name */
    public c f37139j;

    /* renamed from: k  reason: collision with root package name */
    public a7.a f37140k;

    /* renamed from: l  reason: collision with root package name */
    public a6.a f37141l;

    /* renamed from: m  reason: collision with root package name */
    public GetHistoryBagelUseCase f37142m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final String f37143n = SuggestedHistoryListInteractor.class.getSimpleName();

    public static final class a implements i.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedHistoryListInteractor f37144a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PurchaseSource f37145b;

        a(SuggestedHistoryListInteractor suggestedHistoryListInteractor, PurchaseSource purchaseSource) {
            this.f37144a = suggestedHistoryListInteractor;
            this.f37145b = purchaseSource;
        }

        public void a() {
            ((SuggestedHistoryListRouter) this.f37144a.B1()).n(this.f37145b);
        }

        public void b() {
        }
    }

    public SuggestedHistoryListInteractor(j jVar) {
        kotlin.jvm.internal.j.g(jVar, "parentListener");
        this.f37136f = jVar;
    }

    /* access modifiers changed from: private */
    public static final b0 P1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Q1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void R1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void X1(List<? extends Bagel> list, boolean z10) {
        if (list.isEmpty()) {
            ((SuggestedHistoryListPresenter) this.f7875e).m();
            return;
        }
        ((SuggestedHistoryListPresenter) this.f7875e).l();
        ((SuggestedHistoryListPresenter) this.f7875e).n(list);
        if (z10) {
            ((SuggestedHistoryListRouter) B1()).o();
        } else {
            Y1();
        }
    }

    private final void Y1() {
        ((t) W1().p().L().E(U1().a()).g(com.uber.autodispose.a.a(this))).b(new k(new SuggestedHistoryListInteractor$renderUpsellBanner$1(this)), new l(new SuggestedHistoryListInteractor$renderUpsellBanner$2(this)));
    }

    /* access modifiers changed from: private */
    public static final void Z1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void a2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void b2(b bVar) {
        String str;
        if (bVar.A()) {
            str = t9.a.discoverBannerFreeTrialCta;
        } else {
            str = t9.a.discoverBannerSubscriptionCta;
        }
        a aVar = new a(this, new PurchaseSource("suggested history", "suggested history"));
        boolean A = bVar.A();
        kotlin.jvm.internal.j.f(str, "ctaText");
        ((SuggestedHistoryListRouter) B1()).p(A, str, R.string.suggested_history_upsell_banner_text, aVar);
    }

    public final c S1() {
        c cVar = this.f37139j;
        if (cVar != null) {
            return cVar;
        }
        kotlin.jvm.internal.j.y("getActiveSubscriptionUseCase");
        return null;
    }

    public final GetHistoryBagelUseCase T1() {
        GetHistoryBagelUseCase getHistoryBagelUseCase = this.f37142m;
        if (getHistoryBagelUseCase != null) {
            return getHistoryBagelUseCase;
        }
        kotlin.jvm.internal.j.y("getHistoryBagelUseCase");
        return null;
    }

    public final cb.a U1() {
        cb.a aVar = this.f37138h;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("schedulerProvider");
        return null;
    }

    public final a7.a V1() {
        a7.a aVar = this.f37140k;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("tracker");
        return null;
    }

    public final UserRepository W1() {
        UserRepository userRepository = this.f37137g;
        if (userRepository != null) {
            return userRepository;
        }
        kotlin.jvm.internal.j.y("userRepository");
        return null;
    }

    public void n(Bagel bagel) {
        kotlin.jvm.internal.j.g(bagel, Extra.BAGEL);
        this.f37136f.n(bagel);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((n) S1().a().S(new h(new SuggestedHistoryListInteractor$didBecomeActive$1(this))).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new i(new SuggestedHistoryListInteractor$didBecomeActive$2(this)), new j(new SuggestedHistoryListInteractor$didBecomeActive$3(this)));
        V1().d("History List Viewed");
    }
}
