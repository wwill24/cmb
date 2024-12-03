package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class h implements d<g> {

    /* renamed from: a  reason: collision with root package name */
    private final a<QuestionRepository> f36293a;

    public h(a<QuestionRepository> aVar) {
        this.f36293a = aVar;
    }

    public static h a(a<QuestionRepository> aVar) {
        return new h(aVar);
    }

    public static g c(QuestionRepository questionRepository) {
        return new g(questionRepository);
    }

    /* renamed from: b */
    public g get() {
        return c(this.f36293a.get());
    }
}
