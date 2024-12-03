package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.products.my_answers.presentation.m;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import fj.d;
import fk.a;
import io.reactivex.subjects.PublishSubject;
import kotlin.Pair;
import qj.h;

public final class p implements d<h<Pair<QuestionWAnswers, Integer>>> {

    /* renamed from: a  reason: collision with root package name */
    private final m.b f35887a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PublishSubject<Pair<QuestionWAnswers, Integer>>> f35888b;

    public p(m.b bVar, a<PublishSubject<Pair<QuestionWAnswers, Integer>>> aVar) {
        this.f35887a = bVar;
        this.f35888b = aVar;
    }

    public static p a(m.b bVar, a<PublishSubject<Pair<QuestionWAnswers, Integer>>> aVar) {
        return new p(bVar, aVar);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [io.reactivex.subjects.PublishSubject, io.reactivex.subjects.PublishSubject<kotlin.Pair<com.coffeemeetsbagel.qna.QuestionWAnswers, java.lang.Integer>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static qj.h<kotlin.Pair<com.coffeemeetsbagel.qna.QuestionWAnswers, java.lang.Integer>> b(com.coffeemeetsbagel.products.my_answers.presentation.m.b r0, io.reactivex.subjects.PublishSubject<kotlin.Pair<com.coffeemeetsbagel.qna.QuestionWAnswers, java.lang.Integer>> r1) {
        /*
            qj.h r0 = r0.c(r1)
            java.lang.Object r0 = fj.g.e(r0)
            qj.h r0 = (qj.h) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.products.my_answers.presentation.p.b(com.coffeemeetsbagel.products.my_answers.presentation.m$b, io.reactivex.subjects.PublishSubject):qj.h");
    }

    /* renamed from: c */
    public h<Pair<QuestionWAnswers, Integer>> get() {
        return b(this.f35887a, this.f35888b.get());
    }
}
