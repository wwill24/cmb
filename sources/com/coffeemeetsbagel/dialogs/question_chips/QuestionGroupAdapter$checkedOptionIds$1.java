package com.coffeemeetsbagel.dialogs.question_chips;

import android.view.View;
import com.google.android.material.chip.Chip;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class QuestionGroupAdapter$checkedOptionIds$1 extends Lambda implements Function1<View, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final QuestionGroupAdapter$checkedOptionIds$1 f12138a = new QuestionGroupAdapter$checkedOptionIds$1();

    QuestionGroupAdapter$checkedOptionIds$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(View view) {
        boolean z10;
        j.g(view, "view");
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked() && chip.getTag() != null) {
                z10 = true;
                return Boolean.valueOf(z10);
            }
        }
        z10 = false;
        return Boolean.valueOf(z10);
    }
}
