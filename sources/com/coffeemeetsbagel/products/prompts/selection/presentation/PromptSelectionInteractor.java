package com.coffeemeetsbagel.products.prompts.selection.presentation;

import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.j;
import com.uber.autodispose.n;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import qj.h;

public final class PromptSelectionInteractor extends s<PromptSelectionPresenter, y> {

    /* renamed from: l  reason: collision with root package name */
    public static final a f35961l = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    public h<QuestionWAnswers> f35962f;

    /* renamed from: g  reason: collision with root package name */
    public j f35963g;

    /* renamed from: h  reason: collision with root package name */
    public ya.a f35964h;

    /* renamed from: j  reason: collision with root package name */
    public UserRepository f35965j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f35966k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public static final void R1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void W1(Throwable th2) {
        fa.a.f40771d.c("PromptSelectionInteractor", "", th2);
        ((PromptSelectionPresenter) this.f7875e).l(R.string.generic_error);
    }

    /* access modifiers changed from: private */
    public final void X1(List<QuestionWAnswers> list) {
        if (!this.f35966k) {
            this.f35966k = true;
            T1().a();
        }
        ((PromptSelectionPresenter) this.f7875e).n(list);
    }

    /* access modifiers changed from: private */
    public static final rn.a Z1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void a2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List b2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void c2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void d2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void e2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void f2(boolean z10) {
        ((PromptSelectionPresenter) this.f7875e).m(z10);
    }

    public final h<QuestionWAnswers> S1() {
        h<QuestionWAnswers> hVar = this.f35962f;
        if (hVar != null) {
            return hVar;
        }
        kotlin.jvm.internal.j.y("itemClickRead");
        return null;
    }

    public final ya.a T1() {
        ya.a aVar = this.f35964h;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("tracker");
        return null;
    }

    public final j U1() {
        j jVar = this.f35963g;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("useCase");
        return null;
    }

    public final UserRepository V1() {
        UserRepository userRepository = this.f35965j;
        if (userRepository != null) {
            return userRepository;
        }
        kotlin.jvm.internal.j.y("userRepository");
        return null;
    }

    public final void Y1() {
        ((n) V1().m().M(new r(new PromptSelectionInteractor$refresh$1(this))).D(new s(new PromptSelectionInteractor$refresh$2(this))).Y(new t(PromptSelectionInteractor$refresh$3.f35967a)).y(new u(new PromptSelectionInteractor$refresh$4(this))).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new v(new PromptSelectionInteractor$refresh$5(this)), new w(new PromptSelectionInteractor$refresh$6(this)));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        T1().c();
        Y1();
        ((n) S1().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new q(new PromptSelectionInteractor$didBecomeActive$1(this)));
    }
}
