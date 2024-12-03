package com.coffeemeetsbagel.today_view.today_question;

import b6.s;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.today_view.main.e;
import com.coffeemeetsbagel.today_view.today_question.TodayQuestionPresenter;
import com.uber.autodispose.m;
import com.uber.autodispose.n;
import com.uber.autodispose.t;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class TodayQuestionInteractor extends s<TodayQuestionPresenter, x> implements TodayQuestionPresenter.a {

    /* renamed from: n  reason: collision with root package name */
    public static final a f37501n = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    public QuestionRepository f37502f;

    /* renamed from: g  reason: collision with root package name */
    public e.a f37503g;

    /* renamed from: h  reason: collision with root package name */
    public UserRepository f37504h;

    /* renamed from: j  reason: collision with root package name */
    public a7.a f37505j;

    /* renamed from: k  reason: collision with root package name */
    public SaveAnswerUseCase f37506k;

    /* renamed from: l  reason: collision with root package name */
    public QuestionWAnswers f37507l;

    /* renamed from: m  reason: collision with root package name */
    private String f37508m;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37509a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.QuestionType[] r0 = com.coffeemeetsbagel.models.enums.QuestionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.enums.QuestionType r1 = com.coffeemeetsbagel.models.enums.QuestionType.SINGLE_CHOICE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.models.enums.QuestionType r1 = com.coffeemeetsbagel.models.enums.QuestionType.MULTIPLE_CHOICE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f37509a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.today_view.today_question.TodayQuestionInteractor.b.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public final Integer X1(Question question) {
        QuestionInteractionPolicy interactionPolicy;
        int i10 = b.f37509a[question.getType().ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2 && (interactionPolicy = question.getInteractionPolicy()) != null) {
            return interactionPolicy.getMaxOptions();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void Y1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Z1(TodayQuestionInteractor todayQuestionInteractor) {
        j.g(todayQuestionInteractor, "this$0");
        todayQuestionInteractor.t2(false);
    }

    /* access modifiers changed from: private */
    public static final QuestionWAnswers a2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (QuestionWAnswers) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void b2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void c2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void d2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void e2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void l2() {
        fa.a.f40771d.a("TodayQuestionInteractor", "Success");
    }

    /* access modifiers changed from: private */
    public static final void m2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void n2(TodayQuestionInteractor todayQuestionInteractor) {
        j.g(todayQuestionInteractor, "this$0");
        todayQuestionInteractor.t2(false);
    }

    /* access modifiers changed from: private */
    public static final void o2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void p2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void q2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void t2(boolean z10) {
        ((TodayQuestionPresenter) this.f7875e).v(z10);
    }

    public void A0() {
        ((m) SaveAnswerUseCase.d(j2(), ((TodayQuestionPresenter) this.f7875e).o(), (String) null, g2().e().getId(), g2().e().getGroup().getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null).j(com.uber.autodispose.a.a(this))).f(new p(), new q(new TodayQuestionInteractor$onQuestionAdd$2(this)));
        ((TodayQuestionPresenter) this.f7875e).r();
        f2().f("Periodic Question Confirmation");
    }

    public void H() {
        h2().h();
        u2("Confirm Tapped");
    }

    public void O() {
        h2().j();
        u2("Edit Tapped");
    }

    public void R() {
        ((t) i2().S(g2().e()).q(new r(new TodayQuestionInteractor$onQuestionSkip$1(this))).s(new g(this)).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new h(new TodayQuestionInteractor$onQuestionSkip$3(this)), new i(TodayQuestionInteractor$onQuestionSkip$4.f37512a));
    }

    public final a7.a f2() {
        a7.a aVar = this.f37505j;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final QuestionWAnswers g2() {
        QuestionWAnswers questionWAnswers = this.f37507l;
        if (questionWAnswers != null) {
            return questionWAnswers;
        }
        j.y("data");
        return null;
    }

    public final e.a h2() {
        e.a aVar = this.f37503g;
        if (aVar != null) {
            return aVar;
        }
        j.y("greatGrandParentListener");
        return null;
    }

    public final QuestionRepository i2() {
        QuestionRepository questionRepository = this.f37502f;
        if (questionRepository != null) {
            return questionRepository;
        }
        j.y("questionRepository");
        return null;
    }

    public final SaveAnswerUseCase j2() {
        SaveAnswerUseCase saveAnswerUseCase = this.f37506k;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        j.y("saveAnswerUseCase");
        return null;
    }

    public final UserRepository k2() {
        UserRepository userRepository = this.f37504h;
        if (userRepository != null) {
            return userRepository;
        }
        j.y("userRepository");
        return null;
    }

    public final void r2(QuestionWAnswers questionWAnswers) {
        j.g(questionWAnswers, "<set-?>");
        this.f37507l = questionWAnswers;
    }

    public final void s2(String str) {
        this.f37508m = str;
    }

    public final void u2(String str) {
        j.g(str, "button");
        HashMap hashMap = new HashMap();
        hashMap.put("source", "end_of_suggested");
        f2().trackEvent("Periodic Question Confirmation - " + str, hashMap);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((t) i2().O().q(new f(new TodayQuestionInteractor$didBecomeActive$1(this))).s(new j(this)).D(new k(TodayQuestionInteractor$didBecomeActive$3.f37510a)).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new l(new TodayQuestionInteractor$didBecomeActive$4(this)), new m(new TodayQuestionInteractor$didBecomeActive$5(this)));
        ((n) k2().p().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new n(new TodayQuestionInteractor$didBecomeActive$6(this)), new o(TodayQuestionInteractor$didBecomeActive$7.f37511a));
        f2().f("Periodic Question Prompt");
    }
}
