package com.coffeemeetsbagel.dialogs.question_chips;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class QuestionGroupAdapter$checkedOptionIds$2 extends Lambda implements Function1<View, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final QuestionGroupAdapter$checkedOptionIds$2 f12139a = new QuestionGroupAdapter$checkedOptionIds$2();

    QuestionGroupAdapter$checkedOptionIds$2() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(View view) {
        j.g(view, "it");
        Object tag = view.getTag();
        j.e(tag, "null cannot be cast to non-null type kotlin.String");
        return (String) tag;
    }
}
