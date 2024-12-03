package com.coffeemeetsbagel.new_user_experience.gender;

import ab.a;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GenderInteractor$updateInferredGenderQuestion$1 extends Lambda implements Function1<a, QuestionWAnswers> {

    /* renamed from: a  reason: collision with root package name */
    public static final GenderInteractor$updateInferredGenderQuestion$1 f34994a = new GenderInteractor$updateInferredGenderQuestion$1();

    GenderInteractor$updateInferredGenderQuestion$1() {
        super(1);
    }

    /* renamed from: a */
    public final QuestionWAnswers invoke(a aVar) {
        j.g(aVar, "group");
        for (QuestionWAnswers questionWAnswers : aVar.b()) {
            if (j.b(questionWAnswers.e().getName(), ProfileQuestion.GENDER.getApiKey())) {
                return questionWAnswers;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
