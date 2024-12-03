package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import b6.s;
import c6.a;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.match_prefs.MatchPreferenceQuestions;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.models.entities.CapabilityType;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.PremiumPreferencePresenter;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.uber.autodispose.m;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import ma.g;
import qj.h;
import qj.q;
import qj.w;

public final class PremiumPreferenceInteractor extends s<PremiumPreferencePresenter, w> implements PremiumPreferencePresenter.a {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f35221f;

    /* renamed from: g  reason: collision with root package name */
    public QuestionRepository f35222g;

    /* renamed from: h  reason: collision with root package name */
    public k f35223h;

    /* renamed from: j  reason: collision with root package name */
    public l f35224j;

    /* renamed from: k  reason: collision with root package name */
    public q<a> f35225k;

    /* renamed from: l  reason: collision with root package name */
    public g f35226l;

    /* renamed from: m  reason: collision with root package name */
    public l5.a f35227m;

    /* renamed from: n  reason: collision with root package name */
    public s9.a f35228n;

    /* renamed from: p  reason: collision with root package name */
    public SaveAnswerUseCase f35229p;

    /* renamed from: q  reason: collision with root package name */
    public a7.a f35230q;

    /* renamed from: t  reason: collision with root package name */
    public UserRepository f35231t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public Question f35232w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public final String f35233x;

    /* renamed from: y  reason: collision with root package name */
    private final PurchaseSource f35234y = new PurchaseSource("Suggested Preference Detail", "premium suggested preferences");
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f35235z;

    public PremiumPreferenceInteractor(String str) {
        j.g(str, "questionId");
        this.f35221f = str;
        String simpleName = PremiumPreferenceInteractor.class.getSimpleName();
        j.f(simpleName, "this::class.java.simpleName");
        this.f35233x = simpleName;
    }

    static /* synthetic */ void A2(PremiumPreferenceInteractor premiumPreferenceInteractor, QuestionWAnswers questionWAnswers, Boolean bool, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = null;
        }
        premiumPreferenceInteractor.z2(questionWAnswers, bool, z10);
    }

    /* access modifiers changed from: private */
    public static final Boolean B2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Boolean) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void C2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void D2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void E2(Question question) {
        SaveAnswerUseCase s22 = s2();
        List<Option> u10 = ((PremiumPreferencePresenter) this.f7875e).u();
        ArrayList arrayList = new ArrayList(r.t(u10, 10));
        for (Option id2 : u10) {
            arrayList.add(id2.getId());
        }
        ((m) SaveAnswerUseCase.d(s22, arrayList, (String) null, question.getId(), question.getGroup().getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, ((PremiumPreferencePresenter) this.f7875e).r(m2(question)), (Location) null, 754, (Object) null).z(sj.a.a()).j(com.uber.autodispose.a.a(this))).f(new h(this, question), new i(new PremiumPreferenceInteractor$saveAnswer$3(this)));
    }

    /* access modifiers changed from: private */
    public static final void F2(PremiumPreferenceInteractor premiumPreferenceInteractor, Question question) {
        j.g(premiumPreferenceInteractor, "this$0");
        j.g(question, "$question");
        fa.a.f40771d.a("MatchPrefs", "Next tap end - Premium/ Dynamic");
        premiumPreferenceInteractor.o2().onSuccess(question.getLabel());
    }

    /* access modifiers changed from: private */
    public static final void G2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair d2(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final rn.a e2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void f2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void g2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final w<Boolean> j2(boolean z10) {
        if (z10) {
            w<R> D = q2().getProfile().K(dk.a.c()).D(new g(PremiumPreferenceInteractor$getCapability$1.f35237a));
            j.f(D, "{\n            profileSer…Preferences() }\n        }");
            return D;
        }
        w<Boolean> L = l2().a(CapabilityType.PREMIUM_PREFERENCES).L();
        j.f(L, "{\n            capability….firstOrError()\n        }");
        return L;
    }

    /* access modifiers changed from: private */
    public static final Boolean k2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Boolean) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final DealbreakerVariant m2(Question question) {
        boolean b10 = j.b(MatchPreferenceQuestions.GENDER.b(), question.getName());
        if (n2().a("DealbreakersV2.VariantA.Android") && !b10) {
            return DealbreakerVariant.VARIANT_A;
        }
        if (!n2().a("DealbreakersV2.VariantB.Android") || b10) {
            return DealbreakerVariant.DISABLED;
        }
        return DealbreakerVariant.VARIANT_B;
    }

    private final void u2() {
        ((p) h2().g(com.uber.autodispose.a.a(this))).c(new o(new PremiumPreferenceInteractor$observeMpuResults$1(this)));
    }

    /* access modifiers changed from: private */
    public static final void v2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void w2() {
        ((p) ((PremiumPreferencePresenter) this.f7875e).v().g(com.uber.autodispose.a.a(this))).c(new m(new PremiumPreferenceInteractor$observeUserInputs$1(this)));
        ((p) p2().a().s().g(com.uber.autodispose.a.a(this))).c(new n(new PremiumPreferenceInteractor$observeUserInputs$2(this)));
    }

    /* access modifiers changed from: private */
    public static final void x2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void y2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void z2(QuestionWAnswers questionWAnswers, Boolean bool, boolean z10) {
        w<R> wVar;
        if (questionWAnswers.e().getGroup() == QuestionGroupType.FREE_PREFERENCES) {
            wVar = w.C(Boolean.FALSE);
            j.f(wVar, "just(false)");
        } else if (bool != null) {
            wVar = w.C(bool);
            j.f(wVar, "just(lockedState)");
        } else {
            wVar = j2(z10).D(new p(PremiumPreferenceInteractor$renderOptionsAndAnswers$lockedStateSingle$1.f35238a));
            j.f(wVar, "getCapability(shouldGetR… !hasPremPrefCapability }");
        }
        ((t) wVar.E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new q(new PremiumPreferenceInteractor$renderOptionsAndAnswers$1(this, questionWAnswers)), new r(new PremiumPreferenceInteractor$renderOptionsAndAnswers$2(this)));
    }

    public void X0() {
        ((w) B1()).o(this.f35234y);
    }

    public void e() {
        ((w) B1()).o(this.f35234y);
    }

    public final q<a> h2() {
        q<a> qVar = this.f35225k;
        if (qVar != null) {
            return qVar;
        }
        j.y("activityResultStream");
        return null;
    }

    public final a7.a i2() {
        a7.a aVar = this.f35230q;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final l5.a l2() {
        l5.a aVar = this.f35227m;
        if (aVar != null) {
            return aVar;
        }
        j.y("capabilityUseCase");
        return null;
    }

    public final s9.a n2() {
        s9.a aVar = this.f35228n;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManager");
        return null;
    }

    public final k o2() {
        k kVar = this.f35223h;
        if (kVar != null) {
            return kVar;
        }
        j.y("matchPrefsDataListener");
        return null;
    }

    public final l p2() {
        l lVar = this.f35224j;
        if (lVar != null) {
            return lVar;
        }
        j.y("matchPrefsDataStream");
        return null;
    }

    public final g q2() {
        g gVar = this.f35226l;
        if (gVar != null) {
            return gVar;
        }
        j.y("profileService");
        return null;
    }

    public final QuestionRepository r2() {
        QuestionRepository questionRepository = this.f35222g;
        if (questionRepository != null) {
            return questionRepository;
        }
        j.y("questionRepository");
        return null;
    }

    public final SaveAnswerUseCase s2() {
        SaveAnswerUseCase saveAnswerUseCase = this.f35229p;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        j.y("saveAnswerUseCase");
        return null;
    }

    public final UserRepository t2() {
        UserRepository userRepository = this.f35231t;
        if (userRepository != null) {
            return userRepository;
        }
        j.y("userRepository");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((n) h.x0(t2().p(), l2().a(CapabilityType.PREMIUM_PREFERENCES), new f(PremiumPreferenceInteractor$didBecomeActive$1.f35236a)).M(new j(new PremiumPreferenceInteractor$didBecomeActive$2(this))).o0(dk.a.c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new k(new PremiumPreferenceInteractor$didBecomeActive$3(this)), new l(new PremiumPreferenceInteractor$didBecomeActive$4(this)));
        u2();
        w2();
    }
}
