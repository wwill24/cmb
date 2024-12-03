package com.coffeemeetsbagel.products.my_answers.presentation;

import android.view.View;
import com.coffeemeetsbagel.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class MyAnswersAdapter$AnsweredPromptViewHolder$editCta$2 extends Lambda implements Function0<View> {
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyAnswersAdapter$AnsweredPromptViewHolder$editCta$2(View view) {
        super(0);
        this.$view = view;
    }

    /* renamed from: a */
    public final View invoke() {
        return this.$view.findViewById(R.id.edit_answer_cta);
    }
}
