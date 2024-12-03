package com.coffeemeetsbagel.products.my_answers.presentation;

import android.view.View;
import com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersAdapter;
import com.coffeemeetsbagel.qna.QuestionWAnswers;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyAnswersAdapter.AnsweredPromptViewHolder f35880a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f35881b;

    public /* synthetic */ l(MyAnswersAdapter.AnsweredPromptViewHolder answeredPromptViewHolder, QuestionWAnswers questionWAnswers) {
        this.f35880a = answeredPromptViewHolder;
        this.f35881b = questionWAnswers;
    }

    public final void onClick(View view) {
        MyAnswersAdapter.AnsweredPromptViewHolder.X(this.f35880a, this.f35881b, view);
    }
}
