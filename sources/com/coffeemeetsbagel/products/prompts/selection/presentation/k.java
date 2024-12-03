package com.coffeemeetsbagel.products.prompts.selection.presentation;

import com.coffeemeetsbagel.products.prompts.selection.presentation.h;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import fj.d;
import fj.g;
import fk.a;
import io.reactivex.subjects.PublishSubject;

public final class k implements d<PromptSelectionAdapter> {

    /* renamed from: a  reason: collision with root package name */
    private final h.b f35992a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PublishSubject<QuestionWAnswers>> f35993b;

    public k(h.b bVar, a<PublishSubject<QuestionWAnswers>> aVar) {
        this.f35992a = bVar;
        this.f35993b = aVar;
    }

    public static k a(h.b bVar, a<PublishSubject<QuestionWAnswers>> aVar) {
        return new k(bVar, aVar);
    }

    public static PromptSelectionAdapter c(h.b bVar, PublishSubject<QuestionWAnswers> publishSubject) {
        return (PromptSelectionAdapter) g.e(bVar.c(publishSubject));
    }

    /* renamed from: b */
    public PromptSelectionAdapter get() {
        return c(this.f35992a, this.f35993b.get());
    }
}
