package com.coffeemeetsbagel.products.my_answers.presentation;

import android.view.View;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class MyAnswersAdapter$AnsweredPromptViewHolder$answer$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyAnswersAdapter$AnsweredPromptViewHolder$answer$2(View view) {
        super(0);
        this.$view = view;
    }

    /* renamed from: a */
    public final TextView invoke() {
        return (TextView) this.$view.findViewById(R.id.answer);
    }
}
