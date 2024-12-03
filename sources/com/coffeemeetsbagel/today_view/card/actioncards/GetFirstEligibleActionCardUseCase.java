package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.dto.ActionCard;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import hb.c;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;

public final class GetFirstEligibleActionCardUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final ActionCardRepository f37267a;

    /* renamed from: b  reason: collision with root package name */
    private final a6.a f37268b;

    /* renamed from: c  reason: collision with root package name */
    private final QuestionRepository f37269c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ProfileManager f37270d;

    /* renamed from: e  reason: collision with root package name */
    private final PurchaseManager f37271e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final c f37272f;

    /* renamed from: g  reason: collision with root package name */
    private final wb.c f37273g;

    /* renamed from: h  reason: collision with root package name */
    private final r f37274h;

    /* renamed from: i  reason: collision with root package name */
    private final a f37275i = new a();

    public static final class a implements ActionCard {
        a() {
        }

        public String getAction() {
            return ActionType.DEFAULT.b();
        }

        public String getActionText() {
            return "";
        }

        public String getHeaderText() {
            return "";
        }

        public String getId() {
            return "";
        }

        public String getImageUrl() {
            return "";
        }

        public String getMessageText() {
            return "";
        }
    }

    public GetFirstEligibleActionCardUseCase(ActionCardRepository actionCardRepository, a6.a aVar, QuestionRepository questionRepository, ProfileManager profileManager, PurchaseManager purchaseManager, c cVar, wb.c cVar2, r rVar) {
        j.g(actionCardRepository, "repository");
        j.g(aVar, "coachMark");
        j.g(questionRepository, "questionRepository");
        j.g(profileManager, "profileManager");
        j.g(purchaseManager, "purchaseManager");
        j.g(cVar, "sharedPrefsManager");
        j.g(cVar2, "getActiveSubscriptionUseCase");
        j.g(rVar, "featureManager");
        this.f37267a = actionCardRepository;
        this.f37268b = aVar;
        this.f37269c = questionRepository;
        this.f37270d = profileManager;
        this.f37271e = purchaseManager;
        this.f37272f = cVar;
        this.f37273g = cVar2;
        this.f37274h = rVar;
    }

    /* access modifiers changed from: private */
    public final Pair<ActionCard, Boolean> h(ActionCard actionCard, NetworkProfile networkProfile) {
        boolean z10;
        boolean z11;
        boolean z12;
        String action = actionCard.getAction();
        if (j.b(action, ActionType.LIKE_PASS_FLOW.b())) {
            return k(actionCard);
        }
        if (j.b(action, ActionType.PERIODIC_QUESTIONS.b())) {
            Pair<ActionCard, Boolean> j10 = p(actionCard).j();
            j.f(j10, "getPeriodicQuestionsElig…actionCard).blockingGet()");
            return j10;
        } else if (j.b(action, ActionType.PURCHASE_BOOST.b())) {
            return j(actionCard, networkProfile);
        } else {
            if (j.b(action, ActionType.PURCHASE_BONUS_BAGEL.b())) {
                return i(actionCard, networkProfile);
            }
            if (j.b(action, ActionType.SUGGEST_PAYWALL_UPSELL.b())) {
                Pair<ActionCard, Boolean> h10 = n(actionCard).h();
                j.f(h10, "getPaywallUpsellEligibil…tionCard).blockingFirst()");
                return h10;
            } else if (j.b(action, ActionType.SUGGEST_PAYWALL_INVENTORY.b())) {
                Pair<ActionCard, Boolean> h11 = l(actionCard).h();
                j.f(h11, "getPaywallInventoryEligi…tionCard).blockingFirst()");
                return h11;
            } else {
                boolean z13 = true;
                if (j.b(action, ActionType.BAGEL_PREFS.b())) {
                    z10 = true;
                } else {
                    z10 = j.b(action, ActionType.INVITE_FRIENDS.b());
                }
                if (z10) {
                    z11 = true;
                } else {
                    z11 = j.b(action, ActionType.DISCOVER_SEARCH.b());
                }
                if (z11) {
                    z12 = true;
                } else {
                    z12 = j.b(action, ActionType.DISCOVER.b());
                }
                if (!z12) {
                    z13 = j.b(action, ActionType.LIMELIGHT.b());
                }
                if (z13) {
                    return new Pair<>(actionCard, Boolean.TRUE);
                }
                return new Pair<>(this.f37275i, Boolean.FALSE);
            }
        }
    }

    private final Pair<ActionCard, Boolean> i(ActionCard actionCard, NetworkProfile networkProfile) {
        boolean z10;
        Price price = this.f37271e.getPrice(PurchaseType.BONUS_BAGEL);
        if (!this.f37270d.q(networkProfile) || !networkProfile.isFemale() || networkProfile.isGay()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (price == null || z10) {
            return new Pair<>(actionCard, Boolean.FALSE);
        }
        return new Pair<>(actionCard, Boolean.TRUE);
    }

    private final Pair<ActionCard, Boolean> j(ActionCard actionCard, NetworkProfile networkProfile) {
        Price price = this.f37271e.getPrice(PurchaseType.BOOST);
        boolean z10 = !networkProfile.hasActiveBoost();
        if (price == null || !z10) {
            return new Pair<>(actionCard, Boolean.FALSE);
        }
        return new Pair<>(actionCard, Boolean.TRUE);
    }

    private final Pair<ActionCard, Boolean> k(ActionCard actionCard) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = true;
        if (this.f37272f.t("last_show_like_pass_flow") < DateUtils.getTimestampForLastNoon()) {
            z10 = true;
        } else {
            z10 = false;
        }
        int l10 = this.f37272f.l("num_times_like_pass_flow_shown");
        if (this.f37268b.a("has_seen_pass_flow") || this.f37268b.a("has_seen_like_flow")) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (this.f37270d.h() || z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (l10 < 3) {
            z13 = true;
        } else {
            z13 = false;
        }
        Price price = this.f37271e.getPrice(PurchaseType.BONUS_BAGEL);
        if (price == null || price.getFreeItemCount() <= 0) {
            z14 = false;
        }
        if (!z12 || z14 || !z13 || !z10) {
            return new Pair<>(actionCard, Boolean.FALSE);
        }
        return new Pair<>(actionCard, Boolean.TRUE);
    }

    private final h<Pair<ActionCard, Boolean>> l(ActionCard actionCard) {
        if (this.f37274h.a("SPWV2.Show.Android")) {
            h<R> Y = this.f37273g.a().Y(new h0(new GetFirstEligibleActionCardUseCase$getPaywallInventoryEligibility$1(this, actionCard)));
            j.f(Y, "private fun getPaywallIn…d,false))\n        }\n    }");
            return Y;
        }
        h<Pair<ActionCard, Boolean>> X = h.X(new Pair(actionCard, Boolean.FALSE));
        j.f(X, "{\n            Flowable.j…ionCard,false))\n        }");
        return X;
    }

    /* access modifiers changed from: private */
    public static final Pair m(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    private final h<Pair<ActionCard, Boolean>> n(ActionCard actionCard) {
        if (this.f37274h.a("SPWV2.Show.Android")) {
            h<R> Y = this.f37273g.a().Y(new g0(new GetFirstEligibleActionCardUseCase$getPaywallUpsellEligibility$1(actionCard)));
            j.f(Y, "actionCard: ActionCard):…}\n            }\n        }");
            return Y;
        }
        h<Pair<ActionCard, Boolean>> X = h.X(new Pair(actionCard, Boolean.FALSE));
        j.f(X, "{\n            Flowable.j…ionCard,false))\n        }");
        return X;
    }

    /* access modifiers changed from: private */
    public static final Pair o(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    private final w<Pair<ActionCard, Boolean>> p(ActionCard actionCard) {
        w<R> D = this.f37269c.O().D(new f0(new GetFirstEligibleActionCardUseCase$getPeriodicQuestionsEligibility$1(actionCard)));
        j.f(D, "actionCard: ActionCard):…mpty())\n                }");
        return D;
    }

    /* access modifiers changed from: private */
    public static final Pair q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final ActionCard s(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (ActionCard) function1.invoke(obj);
    }

    public final w<ActionCard> r() {
        w<R> D = this.f37267a.k().E(dk.a.c()).D(new e0(new GetFirstEligibleActionCardUseCase$invoke$1(this)));
        j.f(D, "operator fun invoke(): S…    )\n            }\n    }");
        return D;
    }
}
