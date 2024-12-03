package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LoadAgePreferenceUseCase$loadAnswer$1 extends Lambda implements Function2<Optional<QuestionWAnswers>, Optional<QuestionWAnswers>, Pair<? extends Optional<QuestionWAnswers>, ? extends Optional<QuestionWAnswers>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final LoadAgePreferenceUseCase$loadAnswer$1 f35175a = new LoadAgePreferenceUseCase$loadAnswer$1();

    LoadAgePreferenceUseCase$loadAnswer$1() {
        super(2);
    }

    /* renamed from: a */
    public final Pair<Optional<QuestionWAnswers>, Optional<QuestionWAnswers>> invoke(Optional<QuestionWAnswers> optional, Optional<QuestionWAnswers> optional2) {
        j.g(optional, "ageQ");
        j.g(optional2, "genderQ");
        return new Pair<>(optional, optional2);
    }
}
