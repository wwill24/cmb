package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.qna.data.QuestionRepository;
import java.util.Optional;
import kotlin.jvm.internal.j;
import qj.h;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final QuestionRepository f36296a;

    public i(QuestionRepository questionRepository) {
        j.g(questionRepository, "repository");
        this.f36296a = questionRepository;
    }

    public final h<Optional<QuestionWAnswers>> a(String str, String str2) {
        j.g(str, "profileId");
        j.g(str2, "name");
        return this.f36296a.I(str2, str);
    }
}
