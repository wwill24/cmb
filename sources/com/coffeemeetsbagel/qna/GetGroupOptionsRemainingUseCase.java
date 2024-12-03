package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import java.util.OptionalInt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;

public final class GetGroupOptionsRemainingUseCase {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final QuestionRepository f36204a;

    public GetGroupOptionsRemainingUseCase(QuestionRepository questionRepository) {
        j.g(questionRepository, "repository");
        this.f36204a = questionRepository;
    }

    /* access modifiers changed from: private */
    public static final a d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    public final h<OptionalInt> c(String str, QuestionGroupType questionGroupType) {
        j.g(str, "profileId");
        j.g(questionGroupType, "questionGroup");
        h<R> y10 = this.f36204a.K(questionGroupType).y(new c(new GetGroupOptionsRemainingUseCase$invoke$1(this, str, questionGroupType)));
        j.f(y10, "operator fun invoke(prof…    }\n            }\n    }");
        return y10;
    }
}
