package com.coffeemeetsbagel.products.prompts.selection.presentation;

import ab.a;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PromptSelectionInteractor$refresh$3 extends Lambda implements Function1<a, List<? extends QuestionWAnswers>> {

    /* renamed from: a  reason: collision with root package name */
    public static final PromptSelectionInteractor$refresh$3 f35967a = new PromptSelectionInteractor$refresh$3();

    PromptSelectionInteractor$refresh$3() {
        super(1);
    }

    /* renamed from: a */
    public final List<QuestionWAnswers> invoke(a aVar) {
        j.g(aVar, "questionGroup");
        List<QuestionWAnswers> b10 = aVar.b();
        ArrayList arrayList = new ArrayList();
        for (T next : b10) {
            if (((QuestionWAnswers) next).d().isEmpty()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
