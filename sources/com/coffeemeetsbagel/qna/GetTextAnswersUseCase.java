package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;

public final class GetTextAnswersUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final QuestionRepository f36205a;

    public GetTextAnswersUseCase(QuestionRepository questionRepository) {
        j.g(questionRepository, "repository");
        this.f36205a = questionRepository;
    }

    /* access modifiers changed from: private */
    public static final List c(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    public final h<List<QnaPair>> b(QuestionGroupType questionGroupType, String str, boolean z10) {
        j.g(questionGroupType, "questionGroup");
        j.g(str, "profileId");
        h<R> Y = this.f36205a.R(str, questionGroupType, z10).Y(new l(GetTextAnswersUseCase$invoke$1.f36206a));
        j.f(Y, "repository.getTextQuesti…)\n            }\n        }");
        return Y;
    }
}
