package com.coffeemeetsbagel.products.prompts.editor.presentation;

import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.uber.autodispose.m;
import com.uber.autodispose.n;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import qj.h;

public final class PromptEditInteractor extends s<PromptEditPresenter, v> implements w {

    /* renamed from: k  reason: collision with root package name */
    public static final a f35910k = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    public UserRepository f35911f;

    /* renamed from: g  reason: collision with root package name */
    public xa.a f35912g;

    /* renamed from: h  reason: collision with root package name */
    public h<Unit> f35913h;

    /* renamed from: j  reason: collision with root package name */
    public SaveAnswerUseCase f35914j;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public static final void N1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void R1(Throwable th2) {
        fa.a.f40771d.c("PromptEditInteractor", "", th2);
        ((PromptEditPresenter) this.f7875e).u(R.string.generic_error);
    }

    private final void S1() {
        ((v) B1()).n();
    }

    /* access modifiers changed from: private */
    public static final void U1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void V1(PromptEditInteractor promptEditInteractor) {
        j.g(promptEditInteractor, "this$0");
        promptEditInteractor.X1(false);
        promptEditInteractor.S1();
    }

    /* access modifiers changed from: private */
    public static final void W1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void X1(boolean z10) {
        ((PromptEditPresenter) this.f7875e).v(z10);
    }

    public void G(String str, String str2) {
        String str3 = str;
        j.g(str3, "questionId");
        String str4 = str2;
        j.g(str4, "answerText");
        ((m) SaveAnswerUseCase.d(P1(), (List) null, str4, str3, QuestionGroupType.PROMPTS.getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1009, (Object) null).t(new p(new PromptEditInteractor$onSubmit$1(this))).z(sj.a.a()).j(com.uber.autodispose.a.a(this))).f(new q(this), new r(new PromptEditInteractor$onSubmit$3(this)));
    }

    public final h<Unit> O1() {
        h<Unit> hVar = this.f35913h;
        if (hVar != null) {
            return hVar;
        }
        j.y("backNavClicks");
        return null;
    }

    public final SaveAnswerUseCase P1() {
        SaveAnswerUseCase saveAnswerUseCase = this.f35914j;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        j.y("saveAnswerUseCase");
        return null;
    }

    public final xa.a Q1() {
        xa.a aVar = this.f35912g;
        if (aVar != null) {
            return aVar;
        }
        j.y("tracker");
        return null;
    }

    public final void T1(QuestionWAnswers questionWAnswers) {
        j.g(questionWAnswers, "questionWAnswers");
        ((PromptEditPresenter) this.f7875e).q(questionWAnswers);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        Q1().a();
        ((n) O1().g(com.uber.autodispose.a.a(this))).c(new o(new PromptEditInteractor$didBecomeActive$1(this)));
    }
}
