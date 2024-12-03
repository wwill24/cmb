package com.coffeemeetsbagel.products.prompts.selection.presentation;

import com.coffeemeetsbagel.products.prompts.selection.presentation.h;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import fj.d;
import fk.a;
import io.reactivex.subjects.PublishSubject;
import qj.h;

public final class i implements d<h<QuestionWAnswers>> {

    /* renamed from: a  reason: collision with root package name */
    private final h.b f35989a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PublishSubject<QuestionWAnswers>> f35990b;

    public i(h.b bVar, a<PublishSubject<QuestionWAnswers>> aVar) {
        this.f35989a = bVar;
        this.f35990b = aVar;
    }

    public static i a(h.b bVar, a<PublishSubject<QuestionWAnswers>> aVar) {
        return new i(bVar, aVar);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [io.reactivex.subjects.PublishSubject<com.coffeemeetsbagel.qna.QuestionWAnswers>, io.reactivex.subjects.PublishSubject] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static qj.h<com.coffeemeetsbagel.qna.QuestionWAnswers> c(com.coffeemeetsbagel.products.prompts.selection.presentation.h.b r0, io.reactivex.subjects.PublishSubject<com.coffeemeetsbagel.qna.QuestionWAnswers> r1) {
        /*
            qj.h r0 = r0.a(r1)
            java.lang.Object r0 = fj.g.e(r0)
            qj.h r0 = (qj.h) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.products.prompts.selection.presentation.i.c(com.coffeemeetsbagel.products.prompts.selection.presentation.h$b, io.reactivex.subjects.PublishSubject):qj.h");
    }

    /* renamed from: b */
    public qj.h<QuestionWAnswers> get() {
        return c(this.f35989a, this.f35990b.get());
    }
}
