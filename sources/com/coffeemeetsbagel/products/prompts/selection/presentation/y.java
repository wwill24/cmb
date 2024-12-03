package com.coffeemeetsbagel.products.prompts.selection.presentation;

import android.content.Intent;
import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.products.prompts.editor.presentation.PromptEditComponentActivity;
import com.coffeemeetsbagel.products.prompts.selection.presentation.h;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class y extends u<ViewGroup, h.a, PromptSelectionInteractor> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f36007f = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(ViewGroup viewGroup, h.a aVar, PromptSelectionInteractor promptSelectionInteractor) {
        super(viewGroup, aVar, promptSelectionInteractor);
        j.g(viewGroup, "view");
        j.g(aVar, "component");
        j.g(promptSelectionInteractor, "interactor");
    }

    public final void m(QuestionWAnswers questionWAnswers) {
        j.g(questionWAnswers, "questionWAnswers");
        ((h.a) e()).a().startActivityForResult(PromptEditComponentActivity.f35909j.a(((h.a) e()).a(), questionWAnswers), 324);
    }

    public final void n(int i10, int i11, Intent intent) {
        if (i10 != 324) {
            fa.a.f40771d.f(new IllegalStateException("unrecognized request code"));
        } else if (i11 == 41123) {
            ((h.a) e()).a().setResult(41123);
            ((h.a) e()).a().finish();
        }
    }
}
