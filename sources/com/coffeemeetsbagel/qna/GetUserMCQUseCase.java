package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;

public final class GetUserMCQUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f36207a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final QuestionRepository f36208b;

    public GetUserMCQUseCase(UserRepository userRepository, QuestionRepository questionRepository) {
        j.g(userRepository, "userRepository");
        j.g(questionRepository, "questionRepository");
        this.f36207a = userRepository;
        this.f36208b = questionRepository;
    }

    /* access modifiers changed from: private */
    public static final a d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    public final h<List<QuestionWAnswers>> c(QuestionGroupType questionGroupType, boolean z10) {
        j.g(questionGroupType, "questionGroup");
        h<R> M = this.f36207a.m().M(new n(new GetUserMCQUseCase$invoke$1(this, questionGroupType, z10)));
        j.f(M, "operator fun invoke(\n   …    }\n            }\n    }");
        return M;
    }
}
