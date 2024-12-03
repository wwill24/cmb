package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class k implements d<j> {

    /* renamed from: a  reason: collision with root package name */
    private final a<QuestionRepository> f36298a;

    public k(a<QuestionRepository> aVar) {
        this.f36298a = aVar;
    }

    public static k a(a<QuestionRepository> aVar) {
        return new k(aVar);
    }

    public static j c(QuestionRepository questionRepository) {
        return new j(questionRepository);
    }

    /* renamed from: b */
    public j get() {
        return c(this.f36298a.get());
    }
}
