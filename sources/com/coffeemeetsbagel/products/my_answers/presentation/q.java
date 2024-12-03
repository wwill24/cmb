package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.products.my_answers.presentation.m;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import fj.d;
import fj.g;
import io.reactivex.subjects.PublishSubject;
import kotlin.Pair;

public final class q implements d<PublishSubject<Pair<QuestionWAnswers, Integer>>> {

    /* renamed from: a  reason: collision with root package name */
    private final m.b f35889a;

    public q(m.b bVar) {
        this.f35889a = bVar;
    }

    public static q a(m.b bVar) {
        return new q(bVar);
    }

    public static PublishSubject<Pair<QuestionWAnswers, Integer>> b(m.b bVar) {
        return (PublishSubject) g.e(bVar.d());
    }

    /* renamed from: c */
    public PublishSubject<Pair<QuestionWAnswers, Integer>> get() {
        return b(this.f35889a);
    }
}
