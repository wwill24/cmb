package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.products.my_answers.presentation.m;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import fj.d;
import fj.g;
import fk.a;
import io.reactivex.subjects.PublishSubject;
import kotlin.Pair;

public final class s implements d<MyAnswersAdapter> {

    /* renamed from: a  reason: collision with root package name */
    private final m.b f35893a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PublishSubject<Pair<QuestionWAnswers, Integer>>> f35894b;

    public s(m.b bVar, a<PublishSubject<Pair<QuestionWAnswers, Integer>>> aVar) {
        this.f35893a = bVar;
        this.f35894b = aVar;
    }

    public static s a(m.b bVar, a<PublishSubject<Pair<QuestionWAnswers, Integer>>> aVar) {
        return new s(bVar, aVar);
    }

    public static MyAnswersAdapter c(m.b bVar, PublishSubject<Pair<QuestionWAnswers, Integer>> publishSubject) {
        return (MyAnswersAdapter) g.e(bVar.f(publishSubject));
    }

    /* renamed from: b */
    public MyAnswersAdapter get() {
        return c(this.f35893a, this.f35894b.get());
    }
}
