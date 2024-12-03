package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.a;
import qj.f;

public final class DeletePromptAnswerUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f36202a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final QuestionRepository f36203b;

    public DeletePromptAnswerUseCase(UserRepository userRepository, QuestionRepository questionRepository) {
        j.g(userRepository, "userRepository");
        j.g(questionRepository, "repository");
        this.f36202a = userRepository;
        this.f36203b = questionRepository;
    }

    /* access modifiers changed from: private */
    public static final f d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    public final a c(String str) {
        j.g(str, "questionId");
        a w10 = this.f36202a.m().L().w(new a(new DeletePromptAnswerUseCase$invoke$1(this, str)));
        j.f(w10, "operator fun invoke(ques…    )\n            }\n    }");
        return w10;
    }
}
