package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import kotlin.jvm.internal.j;
import qj.w;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final QuestionRepository f36291a;

    public g(QuestionRepository questionRepository) {
        j.g(questionRepository, "repository");
        this.f36291a = questionRepository;
    }

    public final w<Integer> a(QuestionGroupType questionGroupType, int i10) {
        j.g(questionGroupType, "questionGroupType");
        return this.f36291a.L(questionGroupType, i10);
    }
}
