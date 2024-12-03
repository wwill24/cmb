package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView;
import com.coffeemeetsbagel.view.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BiographyPresenter$showSchoolName$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ DelayAutoCompleteTextView $autoCompleteTextView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyPresenter$showSchoolName$2(DelayAutoCompleteTextView delayAutoCompleteTextView) {
        super(1);
        this.$autoCompleteTextView = delayAutoCompleteTextView;
    }

    public final void a(String str) {
        j.g(str, "it");
        DelayAutoCompleteTextView delayAutoCompleteTextView = this.$autoCompleteTextView;
        j.f(delayAutoCompleteTextView, "autoCompleteTextView");
        e.c(delayAutoCompleteTextView);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
