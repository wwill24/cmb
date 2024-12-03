package com.coffeemeetsbagel.limelight.profile_activity;

import b6.q;
import b6.s;
import b6.u;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.match.models.Match;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_view.MatchViewInteractor;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.enums.MatchAction;
import com.uber.autodispose.m;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l8.h;

public final class LikesYouMatchContainerInteractor extends s<LikesYouProfilePresenter, p0> {
    public static final a F = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final String B;
    /* access modifiers changed from: private */
    public final String C;
    private final com.jakewharton.rxrelay2.b<Boolean> D;
    public Match E;

    /* renamed from: f  reason: collision with root package name */
    private final MatchIdAttribution f34401f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f34402g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final b f34403h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final String f34404j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final String f34405k = LikesYouMatchContainerInteractor.class.getSimpleName();

    /* renamed from: l  reason: collision with root package name */
    public a0 f34406l;

    /* renamed from: m  reason: collision with root package name */
    public h f34407m;

    /* renamed from: n  reason: collision with root package name */
    public a7.a f34408n;

    /* renamed from: p  reason: collision with root package name */
    public z f34409p;

    /* renamed from: q  reason: collision with root package name */
    public j f34410q;

    /* renamed from: t  reason: collision with root package name */
    public cb.a f34411t;

    /* renamed from: w  reason: collision with root package name */
    public t f34412w;

    /* renamed from: x  reason: collision with root package name */
    public c6.b f34413x;

    /* renamed from: y  reason: collision with root package name */
    public LikesYouMatchRepository f34414y;

    /* renamed from: z  reason: collision with root package name */
    public wb.c f34415z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        void a(u<?, ?, ?> uVar);
    }

    public static final class c implements MatchViewInteractor.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LikesYouMatchContainerInteractor f34416a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Match f34417b;

        c(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor, Match match) {
            this.f34416a = likesYouMatchContainerInteractor;
            this.f34417b = match;
        }

        public void b(String str) {
            kotlin.jvm.internal.j.g(str, "comment");
        }

        public void c() {
        }

        public void d() {
            ((LikesYouProfilePresenter) this.f34416a.f7875e).B(this.f34417b.getProfileId(), false);
        }

        public void e() {
            ((LikesYouProfilePresenter) this.f34416a.f7875e).B(this.f34417b.getProfileId(), true);
        }

        public void f(Bagel.STAMP stamp) {
            kotlin.jvm.internal.j.g(stamp, "stamp");
        }
    }

    public static final class d implements j.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LikesYouMatchContainerInteractor f34418a;

        d(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
            this.f34418a = likesYouMatchContainerInteractor;
        }

        public void a(Bagel bagel) {
            Unit unit;
            ((LikesYouProfilePresenter) this.f34418a.f7875e).A();
            if (bagel != null) {
                LikesYouMatchContainerInteractor likesYouMatchContainerInteractor = this.f34418a;
                b Y1 = likesYouMatchContainerInteractor.f34403h;
                q B1 = likesYouMatchContainerInteractor.B1();
                kotlin.jvm.internal.j.f(B1, "router");
                Y1.a((u) B1);
                ((p0) likesYouMatchContainerInteractor.B1()).m(bagel);
                unit = Unit.f32013a;
            } else {
                unit = null;
            }
            if (unit == null) {
                ((LikesYouProfilePresenter) this.f34418a.f7875e).G();
            }
        }

        public void onError(String str) {
            ((LikesYouProfilePresenter) this.f34418a.f7875e).A();
            ((LikesYouProfilePresenter) this.f34418a.f7875e).G();
        }
    }

    public LikesYouMatchContainerInteractor(MatchIdAttribution matchIdAttribution, List<String> list, b bVar, String str) {
        kotlin.jvm.internal.j.g(matchIdAttribution, "profileIdAttribution");
        kotlin.jvm.internal.j.g(list, "profileIds");
        kotlin.jvm.internal.j.g(bVar, "actionListener");
        kotlin.jvm.internal.j.g(str, "screenSource");
        this.f34401f = matchIdAttribution;
        this.f34402g = list;
        this.f34403h = bVar;
        this.f34404j = str;
        String c10 = matchIdAttribution.c();
        kotlin.jvm.internal.j.d(c10);
        this.B = c10;
        this.C = matchIdAttribution.d();
        com.jakewharton.rxrelay2.b<Boolean> D0 = com.jakewharton.rxrelay2.b.D0(Boolean.FALSE);
        kotlin.jvm.internal.j.f(D0, "createDefault(false)");
        this.D = D0;
    }

    /* access modifiers changed from: private */
    public static final void A2(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        kotlin.jvm.internal.j.g(likesYouMatchContainerInteractor, "this$0");
        likesYouMatchContainerInteractor.r2().l();
        ((LikesYouProfilePresenter) likesYouMatchContainerInteractor.f7875e).D(likesYouMatchContainerInteractor.p2().getId());
        likesYouMatchContainerInteractor.M2(likesYouMatchContainerInteractor.p2().getProfileId());
    }

    /* access modifiers changed from: private */
    public static final void B2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void D2(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        kotlin.jvm.internal.j.g(likesYouMatchContainerInteractor, "this$0");
        ((LikesYouProfilePresenter) likesYouMatchContainerInteractor.f7875e).A();
    }

    /* access modifiers changed from: private */
    public static final void E2(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        kotlin.jvm.internal.j.g(likesYouMatchContainerInteractor, "this$0");
        b bVar = likesYouMatchContainerInteractor.f34403h;
        q B1 = likesYouMatchContainerInteractor.B1();
        kotlin.jvm.internal.j.f(B1, "router");
        bVar.a((u) B1);
        likesYouMatchContainerInteractor.M2(likesYouMatchContainerInteractor.p2().getProfileId());
    }

    /* access modifiers changed from: private */
    public static final void F2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void G2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void J2(String str, Match match) {
        q2().b("limelight", str);
        ((com.uber.autodispose.t) n2().a().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new a0(new LikesYouMatchContainerInteractor$trackAction$1(str, match, this)), new b0(new LikesYouMatchContainerInteractor$trackAction$2(this)));
    }

    /* access modifiers changed from: private */
    public static final void K2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void L2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void M2(String str) {
        ((com.uber.autodispose.t) o2().G(str).L().g(com.uber.autodispose.a.a(this))).b(new e0(new LikesYouMatchContainerInteractor$updateCardsAndGroupsAfterAction$1(this, str)), new f0(new LikesYouMatchContainerInteractor$updateCardsAndGroupsAfterAction$2(this)));
    }

    /* access modifiers changed from: private */
    public static final void N2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void O2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void h2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void i2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void j2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void t2(c6.a aVar) {
        int b10 = aVar.b();
        if ((b10 == 9279 || b10 == 9304) && aVar.c() == 67) {
            ((p0) B1()).p(u9.d.f18027a.b(aVar));
            M2(p2().getProfileId());
            ((com.uber.autodispose.t) o2().S(p2().getProfileId(), true).g(com.uber.autodispose.a.a(this))).d();
            b bVar = this.f34403h;
            q B1 = B1();
            kotlin.jvm.internal.j.f(B1, "router");
            bVar.a((u) B1);
        }
    }

    /* access modifiers changed from: private */
    public final void u2(Match match) {
        c cVar = new c(this, match);
        ((m) o2().Q(MatchAction.CHECK, match, this.f34404j).j(com.uber.autodispose.a.a(this))).f(new g0(), new h0(new LikesYouMatchContainerInteractor$renderMatch$2(this)));
        int id2 = match.getAction().getId();
        MatchIdAttribution matchIdAttribution = this.f34401f;
        int wooCount = match.getWooCount();
        int wooSeenCount = match.getWooSeenCount();
        qj.q<Boolean> P = this.D.P();
        kotlin.jvm.internal.j.f(P, "matchIsSeen.hide()");
        ((p0) B1()).o(id2, matchIdAttribution, wooCount, wooSeenCount, cVar, P, match.getMessage(), match.getMatchToMe());
    }

    /* access modifiers changed from: private */
    public static final void v2() {
    }

    /* access modifiers changed from: private */
    public static final void w2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void y2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void z2(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        kotlin.jvm.internal.j.g(likesYouMatchContainerInteractor, "this$0");
        ((LikesYouProfilePresenter) likesYouMatchContainerInteractor.f7875e).A();
    }

    public final void C2() {
        J2("pass", p2());
        ((m) o2().Q(MatchAction.PASS, p2(), this.f34404j).t(new i0(new LikesYouMatchContainerInteractor$sendPass$1(this))).u(new j0(this)).z(s2().a()).j(com.uber.autodispose.a.a(this))).f(new k0(this), new v(new LikesYouMatchContainerInteractor$sendPass$4(this)));
    }

    public final void H2(Match match) {
        kotlin.jvm.internal.j.g(match, "<set-?>");
        this.E = match;
    }

    public final void I2(String str) {
        kotlin.jvm.internal.j.g(str, "id");
        ((LikesYouProfilePresenter) this.f7875e).I();
        m2().d(str, new d(this));
    }

    public final c6.b k2() {
        c6.b bVar = this.f34413x;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("activityResultStream");
        return null;
    }

    public final a7.a l2() {
        a7.a aVar = this.f34408n;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("analyticsManager");
        return null;
    }

    public final j m2() {
        j jVar = this.f34410q;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("bagelManager");
        return null;
    }

    public final wb.c n2() {
        wb.c cVar = this.f34415z;
        if (cVar != null) {
            return cVar;
        }
        kotlin.jvm.internal.j.y("getActiveSubscriptionUseCase");
        return null;
    }

    public final LikesYouMatchRepository o2() {
        LikesYouMatchRepository likesYouMatchRepository = this.f34414y;
        if (likesYouMatchRepository != null) {
            return likesYouMatchRepository;
        }
        kotlin.jvm.internal.j.y("likesYouMatchRepository");
        return null;
    }

    public final Match p2() {
        Match match = this.E;
        if (match != null) {
            return match;
        }
        kotlin.jvm.internal.j.y("match");
        return null;
    }

    public final z q2() {
        z zVar = this.f34409p;
        if (zVar != null) {
            return zVar;
        }
        kotlin.jvm.internal.j.y("matchAnalytics");
        return null;
    }

    public final h r2() {
        h hVar = this.f34407m;
        if (hVar != null) {
            return hVar;
        }
        kotlin.jvm.internal.j.y("mongooseManager");
        return null;
    }

    public final cb.a s2() {
        cb.a aVar = this.f34411t;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("schedulerProvider");
        return null;
    }

    public final void u1() {
        b bVar = this.f34403h;
        q B1 = B1();
        kotlin.jvm.internal.j.f(B1, "router");
        bVar.a((u) B1);
    }

    public final void x2() {
        J2("like", p2());
        ((m) o2().Q(MatchAction.LIKE, p2(), this.f34404j).t(new w(new LikesYouMatchContainerInteractor$sendLike$1(this))).u(new x(this)).z(s2().a()).j(com.uber.autodispose.a.a(this))).f(new y(this), new z(new LikesYouMatchContainerInteractor$sendLike$4(this)));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((n) o2().J(this.B).v().a0(s2().a()).g(com.uber.autodispose.a.a(this))).b(new u(new LikesYouMatchContainerInteractor$didBecomeActive$1(this)), new c0(new LikesYouMatchContainerInteractor$didBecomeActive$2(this)));
        ((p) k2().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new d0(new LikesYouMatchContainerInteractor$didBecomeActive$3(this)));
    }
}
