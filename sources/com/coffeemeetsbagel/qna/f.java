package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class f implements d<e> {

    /* renamed from: a  reason: collision with root package name */
    private final a<QuestionRepository> f36289a;

    public f(a<QuestionRepository> aVar) {
        this.f36289a = aVar;
    }

    public static f a(a<QuestionRepository> aVar) {
        return new f(aVar);
    }

    public static e c(QuestionRepository questionRepository) {
        return new e(questionRepository);
    }

    /* renamed from: b */
    public e get() {
        return c(this.f36289a.get());
    }
}
