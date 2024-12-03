package com.coffeemeetsbagel.products.prompts.selection.presentation;

import com.coffeemeetsbagel.products.prompts.selection.presentation.h;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import fj.d;
import fj.g;
import io.reactivex.subjects.PublishSubject;

public final class j implements d<PublishSubject<QuestionWAnswers>> {

    /* renamed from: a  reason: collision with root package name */
    private final h.b f35991a;

    public j(h.b bVar) {
        this.f35991a = bVar;
    }

    public static j a(h.b bVar) {
        return new j(bVar);
    }

    public static PublishSubject<QuestionWAnswers> c(h.b bVar) {
        return (PublishSubject) g.e(bVar.b());
    }

    /* renamed from: b */
    public PublishSubject<QuestionWAnswers> get() {
        return c(this.f35991a);
    }
}
