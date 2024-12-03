package com.coffeemeetsbagel.new_user_experience.match_prefs;

import android.view.ViewGroup;
import b6.s;
import b6.u;
import b6.w;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.match_prefs.MatchPreference$Type;
import com.coffeemeetsbagel.match_prefs.f;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.new_user_experience.match_prefs.MatchPrefsPresenter;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.l;
import com.coffeemeetsbagel.new_user_experience.match_prefs.distance.t;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.n;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.uber.autodispose.p;
import fa.a;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ma.g;
import na.b;
import pa.c;
import qj.q;

public final class MatchPrefsInteractor extends s<MatchPrefsPresenter, h0> implements MatchPrefsPresenter.a {
    /* access modifiers changed from: private */
    public boolean B;
    private a C = new a();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean f35132f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f35133g;

    /* renamed from: h  reason: collision with root package name */
    public b f35134h;

    /* renamed from: j  reason: collision with root package name */
    public ProfileManager f35135j;

    /* renamed from: k  reason: collision with root package name */
    public m1 f35136k;

    /* renamed from: l  reason: collision with root package name */
    public d f35137l;

    /* renamed from: m  reason: collision with root package name */
    public s9.a f35138m;

    /* renamed from: n  reason: collision with root package name */
    public k f35139n;

    /* renamed from: p  reason: collision with root package name */
    public l f35140p;

    /* renamed from: q  reason: collision with root package name */
    public l5.a f35141q;

    /* renamed from: t  reason: collision with root package name */
    public GetUserMCQUseCase f35142t;

    /* renamed from: w  reason: collision with root package name */
    public GetMatchPreferencesUseCase f35143w;

    /* renamed from: x  reason: collision with root package name */
    public q<c6.a> f35144x;

    /* renamed from: y  reason: collision with root package name */
    public g f35145y;

    /* renamed from: z  reason: collision with root package name */
    private int f35146z;

    public static final class a extends w {
        a() {
        }
    }

    public MatchPrefsInteractor(boolean z10) {
        this.f35132f = z10;
        String simpleName = MatchPrefsInteractor.class.getSimpleName();
        j.f(simpleName, "MatchPrefsInteractor::class.java.simpleName");
        this.f35133g = simpleName;
    }

    private final String W1() {
        u<ViewGroup, ?, ?> o10 = ((h0) B1()).o();
        if (o10 instanceof com.coffeemeetsbagel.new_user_experience.match_prefs.gender.j) {
            return "Onboarding Gender";
        }
        if (o10 instanceof l) {
            return "Age";
        }
        if ((o10 instanceof n) || (o10 instanceof com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.n)) {
            return "Height";
        }
        if (o10 instanceof t) {
            NetworkProfile j10 = c2().j();
            j.d(j10);
            if (j10.isHeightUnitMetric()) {
                return "Distance Metric";
            }
            return "Distance Miles";
        } else if (o10 instanceof com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity.l) {
            return "Onboarding - Ethnicity";
        } else {
            if (o10 instanceof com.coffeemeetsbagel.new_user_experience.match_prefs.religion.l) {
                return "Onboarding - Religion";
            }
            if (o10 instanceof com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.w) {
                return ((com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.w) o10).m();
            }
            return "Preferences";
        }
    }

    private final void g2() {
        ((p) V1().g(com.uber.autodispose.a.a(this))).c(new p(new MatchPrefsInteractor$observeSubscriptionResults$1(this)));
    }

    /* access modifiers changed from: private */
    public static final void h2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void i2() {
        ((p) b2().d().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new s(new MatchPrefsInteractor$observeUserInputs$1(this)));
        ((p) b2().e().g(com.uber.autodispose.a.a(this))).c(new t(new MatchPrefsInteractor$observeUserInputs$2(this)));
        ((p) b2().c().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new u(new MatchPrefsInteractor$observeUserInputs$3(this)));
    }

    /* access modifiers changed from: private */
    public static final void j2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void k2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void l2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void m2(MatchPrefsInteractor matchPrefsInteractor) {
        j.g(matchPrefsInteractor, "this$0");
        ((MatchPrefsPresenter) matchPrefsInteractor.f7875e).L(false);
    }

    /* access modifiers changed from: private */
    public static final void n2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void o2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void p2(boolean z10) {
        ((h0) B1()).q();
        ((MatchPrefsPresenter) this.f7875e).M(z10);
        d.h(e2(), (String) null, 1, (Object) null);
        this.C.start();
        ((com.uber.autodispose.n) Y1().m().a0(sj.a.a()).g(com.uber.autodispose.a.a(this.C))).b(new q(new MatchPrefsInteractor$showPreferenceList$1(this)), new r(new MatchPrefsInteractor$showPreferenceList$2(this)));
    }

    static /* synthetic */ void q2(MatchPrefsInteractor matchPrefsInteractor, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        matchPrefsInteractor.p2(z10);
    }

    /* access modifiers changed from: private */
    public static final void r2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void s2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void t2() {
        this.B = false;
        e2().g(W1());
    }

    public void D() {
        ((h0) B1()).s(new PurchaseSource("Suggested Preference List", "premium suggested preferences"));
    }

    public void E0() {
        e2().c(W1());
        q2(this, false, 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void F1() {
        super.F1();
        this.C.v();
    }

    public void U0() {
        boolean z10;
        e2().f((String) null, (Boolean) null);
        NetworkProfile j10 = c2().j();
        if (j10 != null) {
            String criteriaGender = j10.getCriteriaGender();
            if (criteriaGender == null || criteriaGender.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                b Z1 = Z1();
                String w10 = ((MatchPrefsPresenter) this.f7875e).w();
                j.f(w10, "presenter.genderRequirementError");
                Z1.onError(w10);
                int i10 = this.f35146z + 1;
                this.f35146z = i10;
                e2().e("Onboarding - Preferences - Gender Not Selected", h0.k(new Pair("number_of_failures", String.valueOf(i10))));
                return;
            }
        }
        ((MatchPrefsPresenter) this.f7875e).L(true);
        e2().g("Learning Your Type");
        d2().c(false);
        ((com.uber.autodispose.t) c.b(d2()).L(10, TimeUnit.SECONDS).E(sj.a.a()).s(new v(this)).g(com.uber.autodispose.a.a(this))).b(new w(new MatchPrefsInteractor$onSummaryNextClick$3(this)), new x(new MatchPrefsInteractor$onSummaryNextClick$4(this)));
    }

    public final q<c6.a> V1() {
        q<c6.a> qVar = this.f35144x;
        if (qVar != null) {
            return qVar;
        }
        j.y("activityResultStream");
        return null;
    }

    public final s9.a X1() {
        s9.a aVar = this.f35138m;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManager");
        return null;
    }

    public final GetMatchPreferencesUseCase Y1() {
        GetMatchPreferencesUseCase getMatchPreferencesUseCase = this.f35143w;
        if (getMatchPreferencesUseCase != null) {
            return getMatchPreferencesUseCase;
        }
        j.y("getMatchPreferencesUseCase");
        return null;
    }

    public void Z(f fVar, boolean z10) {
        Unit unit;
        ViewGroup l10;
        String str;
        Question e10;
        j.g(fVar, "item");
        ((h0) B1()).m(fVar, z10);
        this.C.v();
        u<ViewGroup, ?, ?> o10 = ((h0) B1()).o();
        if (o10 == null || (l10 = o10.l()) == null) {
            unit = null;
        } else {
            MatchPrefsPresenter matchPrefsPresenter = (MatchPrefsPresenter) this.f7875e;
            QuestionWAnswers a10 = fVar.a();
            if (a10 == null || (e10 = a10.e()) == null || (str = e10.getLabel()) == null) {
                str = "";
            }
            matchPrefsPresenter.I(l10, str);
            t2();
            unit = Unit.f32013a;
        }
        if (unit == null) {
            a.C0491a aVar = fa.a.f40771d;
            String str2 = this.f35133g;
            MatchPreference$Type b10 = fVar.b();
            aVar.b(str2, "Failed to get the view for: " + b10);
        }
    }

    public final b Z1() {
        b bVar = this.f35134h;
        if (bVar != null) {
            return bVar;
        }
        j.y("interactionListener");
        return null;
    }

    public final k a2() {
        k kVar = this.f35139n;
        if (kVar != null) {
            return kVar;
        }
        j.y("matchPrefsDataListener");
        return null;
    }

    public final l b2() {
        l lVar = this.f35140p;
        if (lVar != null) {
            return lVar;
        }
        j.y("matchPrefsDataStream");
        return null;
    }

    public final ProfileManager c2() {
        ProfileManager profileManager = this.f35135j;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    public final m1 d2() {
        m1 m1Var = this.f35136k;
        if (m1Var != null) {
            return m1Var;
        }
        j.y("syncManager");
        return null;
    }

    public void e0() {
        Z1().d();
        e2().b(W1(), false);
    }

    public final d e2() {
        d dVar = this.f35137l;
        if (dVar != null) {
            return dVar;
        }
        j.y("tracker");
        return null;
    }

    public final boolean f2(boolean z10) {
        e2().b(W1(), true);
        if (z10) {
            return false;
        }
        q2(this, false, 1, (Object) null);
        return true;
    }

    public void v1(String str) {
        j.g(str, "questionText");
        a.C0491a aVar = fa.a.f40771d;
        String str2 = this.f35133g;
        aVar.a(str2, "onPreferenceNextClick - " + str);
        Z1().c();
        e2().f(W1(), Boolean.valueOf(this.B));
        a2().f(str);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        e2().a(this.f35132f);
        p2(true);
        i2();
        g2();
    }
}
