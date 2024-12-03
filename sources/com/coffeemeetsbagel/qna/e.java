package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.h;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final QuestionRepository f36287a;

    public e(QuestionRepository questionRepository) {
        j.g(questionRepository, "repository");
        this.f36287a = questionRepository;
    }

    public final h<List<String>> a(String str, QuestionGroupType questionGroupType) {
        j.g(str, "profileId");
        j.g(questionGroupType, "questionGroupType");
        h<List<String>> v10 = this.f36287a.H(str, questionGroupType).v();
        j.f(v10, "repository.getMCQAnswers…e).distinctUntilChanged()");
        return v10;
    }
}
