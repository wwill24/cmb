package com.coffeemeetsbagel.products.prompts.selection.presentation;

import android.view.View;
import com.coffeemeetsbagel.products.prompts.selection.presentation.PromptSelectionAdapter;
import com.coffeemeetsbagel.qna.QuestionWAnswers;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PromptSelectionAdapter.ViewHolder f35986a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f35987b;

    public /* synthetic */ g(PromptSelectionAdapter.ViewHolder viewHolder, QuestionWAnswers questionWAnswers) {
        this.f35986a = viewHolder;
        this.f35987b = questionWAnswers;
    }

    public final void onClick(View view) {
        PromptSelectionAdapter.ViewHolder.X(this.f35986a, this.f35987b, view);
    }
}
