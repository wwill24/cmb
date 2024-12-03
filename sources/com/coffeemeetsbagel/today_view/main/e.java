package com.coffeemeetsbagel.today_view.main;

import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.bagel.GetLastPassedBagelUseCase;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match.d;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import com.coffeemeetsbagel.models.enums.BagelAction;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.domain.BenefitKeys;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor;
import com.coffeemeetsbagel.utils.model.Optional;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.uber.autodispose.n;
import ic.f;
import ic.g;
import ic.h;
import ic.i;
import ic.k;
import ic.l;
import ic.p;
import io.reactivex.BackpressureStrategy;
import java.util.List;
import kotlin.Pair;
import qj.b0;
import qj.q;
import qj.w;
import wb.c;

public class e extends s<g, h> {
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public final io.reactivex.subjects.a<Boolean> C;
    /* access modifiers changed from: private */
    public final q<Boolean> D;
    private boolean E = false;
    private boolean F = false;

    /* renamed from: f  reason: collision with root package name */
    j f37368f;

    /* renamed from: g  reason: collision with root package name */
    ProfileContract$Manager f37369g;

    /* renamed from: h  reason: collision with root package name */
    ActivityMain f37370h;

    /* renamed from: j  reason: collision with root package name */
    c f37371j;

    /* renamed from: k  reason: collision with root package name */
    a7.a f37372k;

    /* renamed from: l  reason: collision with root package name */
    a0 f37373l;

    /* renamed from: m  reason: collision with root package name */
    QuestionRepository f37374m;

    /* renamed from: n  reason: collision with root package name */
    t f37375n;

    /* renamed from: p  reason: collision with root package name */
    s9.a f37376p;

    /* renamed from: q  reason: collision with root package name */
    SuggestedRepository f37377q;

    /* renamed from: t  reason: collision with root package name */
    hb.c f37378t;

    /* renamed from: w  reason: collision with root package name */
    a6.a f37379w;

    /* renamed from: x  reason: collision with root package name */
    GetLastPassedBagelUseCase f37380x;

    /* renamed from: y  reason: collision with root package name */
    d f37381y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f37382z;

    public class a {
        public a() {
        }

        public void a(boolean z10) {
            e.this.o2(true);
            e.this.n2(z10);
            e.this.C.d(Boolean.TRUE);
        }

        public void b(boolean z10) {
            e.this.o2(false);
            e.this.n2(z10);
            e.this.C.d(Boolean.TRUE);
        }

        public void c() {
            e.this.f37370h.g4();
        }

        public void d() {
            ((h) e.this.B1()).K();
        }

        public void e() {
            e.this.f37368f.w();
        }

        public void f() {
            ((h) e.this.B1()).L();
        }

        public void g() {
            ((h) e.this.B1()).Q();
        }

        public void h() {
            ((h) e.this.B1()).J(e.this.f37382z, e.this.B, e.this.D, (SuggestedUnsubPaywallInteractor.UnsubPaywall) null);
        }

        public void i() {
            ((h) e.this.B1()).S();
        }

        public void j() {
            ((h) e.this.B1()).P();
        }

        public void k(Long l10) {
            e.this.f37370h.Z4(l10);
        }
    }

    public e() {
        io.reactivex.subjects.a<Boolean> D0 = io.reactivex.subjects.a.D0(Boolean.FALSE);
        this.C = D0;
        this.D = D0.v0(BackpressureStrategy.BUFFER).t0();
    }

    private void V1(List<Bagel> list, Optional<vb.a> optional, Optional<SuggestedLimitsEntity> optional2) {
        if (list.size() > 0) {
            this.f37378t.remove("SUGGEST_UNLIMITED_NO_INVENTORY_2");
            this.f37370h.D4();
        } else {
            this.f37370h.V2();
        }
        if (this.f37369g.j() != null && this.f37369g.j().isOnHold()) {
            Z1(list.size());
        } else if (this.f37376p.a("SuggestedPaywall.Show.Android")) {
            c2(list, optional, optional2);
        } else {
            W1(list);
            this.f37370h.c5(list.size());
        }
    }

    private void W1(List<Bagel> list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleBagelsNoPaywall: ");
        sb2.append(list.size());
        int size = list.size();
        if (size == 0) {
            if (this.f37376p.a("SuggestedPaywall.Show.Android")) {
                this.f37372k.d("Suggested - Out Of Inventory");
            }
            Z1(list.size());
        } else if (size != 1) {
            ((h) B1()).M(list.get(0), list.get(1));
        } else {
            ((h) B1()).N(list.get(0), this.f37382z, this.B, this.D, (SuggestedUnsubPaywallInteractor.UnsubPaywall) null);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("subscriptionHasUnlimited=");
        sb3.append(this.F);
        if (list.size() > 0 && !this.E && this.F) {
            if (!this.f37379w.a("unlimited_in_suggested_toolbar")) {
                p2();
                this.f37379w.b("unlimited_in_suggested_toolbar");
            } else if (!this.f37379w.a("unlimited_in_suggested_toolbar_2x")) {
                p2();
                this.f37379w.b("unlimited_in_suggested_toolbar_2x");
            }
            this.E = true;
        }
    }

    private void X1(SuggestedLimitsEntity suggestedLimitsEntity, List<Bagel> list) {
        SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall;
        SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall2;
        if (suggestedLimitsEntity.getRemainingLikes() == null || suggestedLimitsEntity.getRemainingViews() == null || suggestedLimitsEntity.getNumBagelsRequiredForUpsell() == null) {
            W1(list);
        } else if (suggestedLimitsEntity.getRemainingLikes().intValue() <= 0 || suggestedLimitsEntity.getRemainingViews().intValue() <= 0) {
            if (suggestedLimitsEntity.getRemainingViews().intValue() == 0) {
                this.f37372k.d("Suggested - Out Of Bagels");
            } else if (suggestedLimitsEntity.getRemainingLikes().intValue() == 0) {
                this.f37372k.d("Suggested - Out Of Likes");
            }
            if (list.size() >= suggestedLimitsEntity.getNumBagelsRequiredForUpsell().intValue()) {
                if (suggestedLimitsEntity.getRemainingViews().intValue() == 0) {
                    unsubPaywall = SuggestedUnsubPaywallInteractor.UnsubPaywall.NO_VIEWS;
                } else {
                    unsubPaywall = SuggestedUnsubPaywallInteractor.UnsubPaywall.NO_LIKES;
                }
                Y1(unsubPaywall);
                return;
            }
            Z1(list.size());
        } else if ((suggestedLimitsEntity.getRemainingLikes().intValue() == 1 || suggestedLimitsEntity.getRemainingViews().intValue() == 1) && list.size() > 0) {
            if (list.size() < suggestedLimitsEntity.getNumBagelsRequiredForUpsell().intValue()) {
                unsubPaywall2 = null;
            } else if (suggestedLimitsEntity.getRemainingViews().intValue() == 1) {
                unsubPaywall2 = SuggestedUnsubPaywallInteractor.UnsubPaywall.NO_VIEWS;
            } else {
                unsubPaywall2 = SuggestedUnsubPaywallInteractor.UnsubPaywall.NO_LIKES;
            }
            ((h) B1()).N(list.get(0), this.f37382z, this.B, this.D, unsubPaywall2);
        } else {
            W1(list);
        }
    }

    private void Y1(SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        ((h) B1()).J(this.f37382z, this.B, this.D, unsubPaywall);
        this.f37370h.N2();
    }

    private void Z1(int i10) {
        ((h) B1()).J(this.f37382z, this.B, this.D, (SuggestedUnsubPaywallInteractor.UnsubPaywall) null);
        this.f37370h.N2();
        if (!this.f37376p.a("SuggestedPaywall.Show.Android")) {
            this.f37370h.c5(i10);
        }
    }

    private w<Boolean> a2(Bagel bagel) {
        bagel.setAction(3);
        this.f37368f.u(bagel);
        this.f37368f.b((j.a) null, bagel, "TodayViewMainInteractor");
        return this.f37381y.d(bagel, BagelAction.CHECK).D(new l());
    }

    private void b2(List<Bagel> list, ProfileManager.ProfileStatus profileStatus, Optional<vb.a> optional, Optional<SuggestedLimitsEntity> optional2) {
        ((g) this.f7875e).j();
        if (profileStatus == ProfileManager.ProfileStatus.DEACTIVATED) {
            this.f37370h.g4();
        } else if (profileStatus == ProfileManager.ProfileStatus.ACTIVE) {
            this.f37370h.Y4();
        }
        V1(list, optional, optional2);
    }

    private void c2(List<Bagel> list, Optional<vb.a> optional, Optional<SuggestedLimitsEntity> optional2) {
        if (optional.d()) {
            W1(list);
        } else if (optional2.d()) {
            X1(optional2.c(), list);
        } else {
            W1(list);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d2(p pVar) throws Exception {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Got state: ");
        sb2.append(pVar);
        this.f37368f.w();
        vb.a g10 = pVar.d().g();
        if (g10 == null || !g10.h(BenefitKeys.UNLIMITED_SUGGESTED_VIEWS)) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.F = z10;
        if (this.f37376p.a("SuggestedPaywall.Show.Android") || this.F) {
            m2(pVar.a(), pVar.c(), pVar.b(), pVar.d());
        } else {
            b2(pVar.a(), pVar.b(), (Optional<vb.a>) null, (Optional<SuggestedLimitsEntity>) null);
        }
        ((g) this.f7875e).j();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e2(Throwable th2) throws Exception {
        fa.a.g("TodayViewMainInteractor", "Failed to load Suggested.", th2);
        this.f37368f.w();
        ((g) this.f7875e).j();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ b0 g2(Pair pair) throws Exception {
        if (((Optional) pair.c()).d()) {
            return a2((Bagel) pair.d());
        }
        return w.C(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h2(Boolean bool) throws Exception {
        ((h) B1()).D(Boolean.valueOf(!bool.booleanValue()));
        if (bool.booleanValue()) {
            this.f37368f.w();
            return;
        }
        ((h) B1()).O(new PurchaseSource("Suggested", "suggested_rewind"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i2(Boolean bool) throws Exception {
        if (!bool.booleanValue()) {
            this.C.d(Boolean.TRUE);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j2(List list, ProfileManager.ProfileStatus profileStatus, Optional optional, Optional optional2, List list2) throws Exception {
        if (list2.isEmpty()) {
            b2(list, profileStatus, optional, optional2);
        } else {
            this.f37368f.p(true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k2(Throwable th2) throws Exception {
        ((g) this.f7875e).j();
        fa.a.g("TodayViewMainInteractor", "problem getting bagels", th2);
    }

    private void m2(List<Bagel> list, Optional<SuggestedLimitsEntity> optional, ProfileManager.ProfileStatus profileStatus, Optional<vb.a> optional2) {
        ((com.uber.autodispose.t) this.f37377q.F(list.size(), optional).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new g(this, list, profileStatus, optional2, optional), new h(this));
    }

    /* access modifiers changed from: private */
    public void n2(boolean z10) {
        this.B = z10;
    }

    /* access modifiers changed from: private */
    public void o2(boolean z10) {
        this.f37382z = z10;
    }

    private void p2() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("showUnlimitedBalloon(): balloonShown=");
        sb2.append(this.E);
        new Balloon.a(this.f37370h).m1(this.f37370h).c1(BalloonAnimation.ELASTIC).D1(true).E1(R.string.suggested_unlimited_ballon).B1(R.color.dark_gray).F1(14.0f).C1(8388611).G1(1.0f).d1(12.0f).o1(R.dimen.baseline_2x).n1(R.dimen.baseline_1x).r1(R.dimen.baseline_3x).y1(R.dimen.baseline_2x).b1(R.color.white).k1(true).Z0(10).X0(0.5f).W0(ArrowOrientation.BOTTOM).Y0(ArrowPositionRules.ALIGN_BALLOON).u1(R.color.black).a().C0(this.f37370h.T0().getSubTitleView());
    }

    /* access modifiers changed from: protected */
    public void F1() {
        super.F1();
        ((g) this.f7875e).j();
    }

    public void J() {
        ((com.uber.autodispose.t) w.S(this.f37371j.a().L(), this.f37380x.c(), new i()).v(new ic.j(this)).g(com.uber.autodispose.a.a(this))).c(new k(this));
    }

    public void l2() {
        ((com.uber.autodispose.p) this.D.g(com.uber.autodispose.a.a(this))).c(new f(this));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((g) this.f7875e).k();
        q<List<Bagel>> e10 = this.f37368f.e();
        BackpressureStrategy backpressureStrategy = BackpressureStrategy.LATEST;
        ((n) qj.h.l(e10.v0(backpressureStrategy), this.f37369g.i().v0(backpressureStrategy), this.f37371j.a(), this.f37377q.x(), new ic.c()).v().o0(dk.a.c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new ic.d(this), new ic.e(this));
        this.f37372k.f("Today's Bagel");
    }
}
