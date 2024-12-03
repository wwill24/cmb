package com.coffeemeetsbagel.products.my_answers.presentation;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.HorizontalPrimarySecondaryDialog;
import com.coffeemeetsbagel.products.my_answers.presentation.m;
import com.coffeemeetsbagel.products.prompts.editor.presentation.PromptEditComponentActivity;
import com.coffeemeetsbagel.products.prompts.selection.presentation.PromptSelectionComponentActivity;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.util.RequestCode;
import kotlin.Pair;
import kotlin.jvm.internal.j;
import r5.e;

public final class j0 extends u<View, m.a, MyAnswersInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private e f35875f;

    public static final class a implements HorizontalPrimarySecondaryDialog.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j0 f35876a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Pair<QuestionWAnswers, Integer> f35877b;

        a(j0 j0Var, Pair<QuestionWAnswers, Integer> pair) {
            this.f35876a = j0Var;
            this.f35877b = pair;
        }

        public void a() {
            ((MyAnswersInteractor) this.f35876a.f()).X1(this.f35877b);
        }

        public void b() {
        }
    }

    public static final class b implements e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j0 f35878a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Pair<QuestionWAnswers, Integer> f35879b;

        b(j0 j0Var, Pair<QuestionWAnswers, Integer> pair) {
            this.f35878a = j0Var;
            this.f35879b = pair;
        }

        public void a() {
            this.f35878a.p();
            this.f35878a.q(this.f35879b);
        }

        public void b() {
            this.f35878a.p();
            ((m.a) this.f35878a.e()).n().startActivityForResult(PromptEditComponentActivity.f35909j.a(((m.a) this.f35878a.e()).n(), this.f35879b.c()), RequestCode.EDIT_PROMPT);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(View view, m.a aVar, MyAnswersInteractor myAnswersInteractor) {
        super(view, aVar, myAnswersInteractor);
        j.g(view, "view");
        j.g(aVar, "component");
        j.g(myAnswersInteractor, "interactor");
    }

    /* access modifiers changed from: private */
    public final void q(Pair<QuestionWAnswers, Integer> pair) {
        String string = ((m.a) e()).n().getString(R.string.prompt_delete_confirmation_title);
        j.f(string, "component.appCompatActiv…elete_confirmation_title)");
        String string2 = ((m.a) e()).n().getString(R.string.prompt_delete_confirmation_message);
        j.f(string2, "component.appCompatActiv…ete_confirmation_message)");
        String string3 = ((m.a) e()).n().getString(R.string.delete);
        j.f(string3, "component.appCompatActiv…etString(R.string.delete)");
        String string4 = ((m.a) e()).n().getString(R.string.cancel);
        j.f(string4, "component.appCompatActiv…etString(R.string.cancel)");
        new HorizontalPrimarySecondaryDialog(((m.a) e()).n(), new a(this, pair), string, string2, string4, string3).show();
    }

    public final void n() {
        ((m.a) e()).n().startActivityForResult(PromptSelectionComponentActivity.f35960m.a(((m.a) e()).n()), RequestCode.ADD_PROMPT);
    }

    public final void o(int i10, int i11, Intent intent) {
        if (i11 != 41123) {
            return;
        }
        if (i10 == 9302) {
            ((MyAnswersInteractor) f()).r2(true);
        } else if (i10 != 9303) {
            fa.a.f40771d.f(new IllegalStateException("unrecognized request code"));
        } else {
            ((MyAnswersInteractor) f()).o2();
            ((MyAnswersInteractor) f()).r2(true);
        }
    }

    public final void p() {
        e eVar = this.f35875f;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    public final void r(Pair<QuestionWAnswers, Integer> pair) {
        j.g(pair, "questionWAnswer");
        b bVar = new b(this, pair);
        String string = ((m.a) e()).n().getString(R.string.prompt_edit);
        j.f(string, "component.appCompatActiv…ing(R.string.prompt_edit)");
        String string2 = ((m.a) e()).n().getString(R.string.delete);
        j.f(string2, "component.appCompatActiv…etString(R.string.delete)");
        FragmentManager supportFragmentManager = ((m.a) e()).n().getSupportFragmentManager();
        j.f(supportFragmentManager, "component.appCompatActiv…().supportFragmentManager");
        e eVar = new e(supportFragmentManager, string, string2, bVar);
        eVar.H0();
        this.f35875f = eVar;
    }
}
