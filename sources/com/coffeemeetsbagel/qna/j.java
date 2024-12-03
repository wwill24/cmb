package com.coffeemeetsbagel.qna;

import ab.a;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import qj.h;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final QuestionRepository f36297a;

    public j(QuestionRepository questionRepository) {
        kotlin.jvm.internal.j.g(questionRepository, "repository");
        this.f36297a = questionRepository;
    }

    public static /* synthetic */ h b(j jVar, String str, QuestionGroupType questionGroupType, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return jVar.a(str, questionGroupType, z10);
    }

    public final h<a> a(String str, QuestionGroupType questionGroupType, boolean z10) {
        kotlin.jvm.internal.j.g(str, "profileId");
        kotlin.jvm.internal.j.g(questionGroupType, "questionGroup");
        return this.f36297a.x(questionGroupType, str, z10, false);
    }
}
