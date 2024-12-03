package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.match_prefs.MatchPreferenceQuestions;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import ja.b;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class SaveAgePreferenceUseCase$updateQuestionAgeRange$1 extends Lambda implements Function1<b, b0<? extends Pair<? extends b, ? extends Optional<QuestionWAnswers>>>> {
    final /* synthetic */ SaveAgePreferenceUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveAgePreferenceUseCase$updateQuestionAgeRange$1(SaveAgePreferenceUseCase saveAgePreferenceUseCase) {
        super(1);
        this.this$0 = saveAgePreferenceUseCase;
    }

    /* access modifiers changed from: private */
    public static final Pair d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends Pair<b, Optional<QuestionWAnswers>>> invoke(final b bVar) {
        j.g(bVar, "user");
        return this.this$0.f35179d.I(MatchPreferenceQuestions.AGE.b(), bVar.u()).Y(new y(new Function1<Optional<QuestionWAnswers>, Pair<? extends b, ? extends Optional<QuestionWAnswers>>>() {
            /* renamed from: a */
            public final Pair<b, Optional<QuestionWAnswers>> invoke(Optional<QuestionWAnswers> optional) {
                j.g(optional, "it");
                return new Pair<>(bVar, optional);
            }
        })).L();
    }
}
