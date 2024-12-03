package com.coffeemeetsbagel.products.my_answers.presentation;

import android.annotation.SuppressLint;
import b6.s;
import c6.b;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.g;
import com.uber.autodispose.m;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;

public final class MyAnswersInteractor extends s<MyAnswersPresenter, j0> {

    /* renamed from: q  reason: collision with root package name */
    public static final a f35821q = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean f35822f;

    /* renamed from: g  reason: collision with root package name */
    public ta.a f35823g;

    /* renamed from: h  reason: collision with root package name */
    public h<Unit> f35824h;

    /* renamed from: j  reason: collision with root package name */
    public h<Pair<QuestionWAnswers, Integer>> f35825j;

    /* renamed from: k  reason: collision with root package name */
    public b f35826k;

    /* renamed from: l  reason: collision with root package name */
    public DeletePromptAnswerUseCase f35827l;

    /* renamed from: m  reason: collision with root package name */
    public UserRepository f35828m;

    /* renamed from: n  reason: collision with root package name */
    public QuestionRepository f35829n;

    /* renamed from: p  reason: collision with root package name */
    public g f35830p;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MyAnswersInteractor(boolean z10) {
        this.f35822f = z10;
    }

    /* access modifiers changed from: private */
    public static final void Y1(MyAnswersInteractor myAnswersInteractor, Pair pair) {
        j.g(myAnswersInteractor, "this$0");
        j.g(pair, "$pair");
        myAnswersInteractor.n2(pair);
    }

    /* access modifiers changed from: private */
    public static final void Z1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void a2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void b2(MyAnswersInteractor myAnswersInteractor) {
        j.g(myAnswersInteractor, "this$0");
        myAnswersInteractor.x2(false);
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

    private final void n2(Pair<QuestionWAnswers, Integer> pair) {
        l2().b();
        ((j0) B1()).p();
        ((MyAnswersPresenter) this.f7875e).m(pair.d().intValue());
    }

    /* access modifiers changed from: private */
    public final void p2(Throwable th2) {
        fa.a.f40771d.c("MyAnswersInteractor", "error fetching my answers", th2);
        ((j0) B1()).p();
    }

    /* access modifiers changed from: private */
    public final void q2(List<QuestionWAnswers> list, int i10) {
        ((MyAnswersPresenter) this.f7875e).q(list, i10);
    }

    /* access modifiers changed from: private */
    public static final void s2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final rn.a t2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void u2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void v2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void w2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void x2(boolean z10) {
        ((MyAnswersPresenter) this.f7875e).p(z10);
    }

    public final void X1(Pair<QuestionWAnswers, Integer> pair) {
        j.g(pair, "pair");
        ((m) h2().c(pair.c().e().getId()).t(new e0(new MyAnswersInteractor$deleteAnswer$1(this))).u(new f0(this)).z(sj.a.a()).j(com.uber.autodispose.a.a(this))).f(new v(this, pair), new w(new MyAnswersInteractor$deleteAnswer$4(this)));
    }

    public final b f2() {
        b bVar = this.f35826k;
        if (bVar != null) {
            return bVar;
        }
        j.y("activityResultStream");
        return null;
    }

    public final h<Unit> g2() {
        h<Unit> hVar = this.f35824h;
        if (hVar != null) {
            return hVar;
        }
        j.y("addPromptClicks");
        return null;
    }

    public final DeletePromptAnswerUseCase h2() {
        DeletePromptAnswerUseCase deletePromptAnswerUseCase = this.f35827l;
        if (deletePromptAnswerUseCase != null) {
            return deletePromptAnswerUseCase;
        }
        j.y("deleteAnswerUseCase");
        return null;
    }

    public final h<Pair<QuestionWAnswers, Integer>> i2() {
        h<Pair<QuestionWAnswers, Integer>> hVar = this.f35825j;
        if (hVar != null) {
            return hVar;
        }
        j.y("editAnswerClicks");
        return null;
    }

    public final g j2() {
        g gVar = this.f35830p;
        if (gVar != null) {
            return gVar;
        }
        j.y("getMaxAllowedUseCase");
        return null;
    }

    public final QuestionRepository k2() {
        QuestionRepository questionRepository = this.f35829n;
        if (questionRepository != null) {
            return questionRepository;
        }
        j.y("questionRepository");
        return null;
    }

    public final ta.a l2() {
        ta.a aVar = this.f35823g;
        if (aVar != null) {
            return aVar;
        }
        j.y("tracker");
        return null;
    }

    public final UserRepository m2() {
        UserRepository userRepository = this.f35828m;
        if (userRepository != null) {
            return userRepository;
        }
        j.y("userRepository");
        return null;
    }

    public final void o2() {
        l2().c();
    }

    public final void r2(boolean z10) {
        ck.b bVar = ck.b.f24947a;
        w<String> L = m2().m().L();
        j.f(L, "userRepository.getCurrentUserId().firstOrError()");
        ((n) bVar.a(L, j2().a(QuestionGroupType.PROMPTS, 3)).q(new u(new MyAnswersInteractor$refresh$1(this))).O().M(new x(new MyAnswersInteractor$refresh$2(this, z10))).y(new y(new MyAnswersInteractor$refresh$3(this))).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new z(new MyAnswersInteractor$refresh$4(this)), new a0(new MyAnswersInteractor$refresh$5(this)));
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"AutoDispose"})
    public void y1() {
        super.y1();
        r2(false);
        ((n) g2().g(com.uber.autodispose.a.a(this))).c(new b0(new MyAnswersInteractor$didBecomeActive$1(this)));
        ((n) i2().g(com.uber.autodispose.a.a(this))).c(new c0(new MyAnswersInteractor$didBecomeActive$2(this)));
        ((p) f2().a().g(com.uber.autodispose.a.a(this))).c(new d0(new MyAnswersInteractor$didBecomeActive$3(this)));
    }
}
