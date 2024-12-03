package com.coffeemeetsbagel.products.prompts.editor.presentation;

import android.view.View;
import com.coffeemeetsbagel.qna.QuestionWAnswers;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PromptEditPresenter f35952a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f35953b;

    public /* synthetic */ u(PromptEditPresenter promptEditPresenter, QuestionWAnswers questionWAnswers) {
        this.f35952a = promptEditPresenter;
        this.f35953b = questionWAnswers;
    }

    public final void onClick(View view) {
        PromptEditPresenter.t(this.f35952a, this.f35953b, view);
    }
}
