package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BiographyInteractor$navigateToSchool$schoolNameSource$1 extends Lambda implements Function1<QuestionWAnswers, Optional<String>> {

    /* renamed from: a  reason: collision with root package name */
    public static final BiographyInteractor$navigateToSchool$schoolNameSource$1 f34829a = new BiographyInteractor$navigateToSchool$schoolNameSource$1();

    BiographyInteractor$navigateToSchool$schoolNameSource$1() {
        super(1);
    }

    /* renamed from: a */
    public final Optional<String> invoke(QuestionWAnswers questionWAnswers) {
        String textValue;
        Optional<String> e10;
        j.g(questionWAnswers, "questionWAnswers");
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer == null || (textValue = answer.getTextValue()) == null || (e10 = Optional.e(textValue)) == null) {
            return Optional.a();
        }
        return e10;
    }
}
