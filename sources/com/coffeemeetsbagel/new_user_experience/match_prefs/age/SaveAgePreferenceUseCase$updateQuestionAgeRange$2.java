package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import ja.b;
import java.util.List;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class SaveAgePreferenceUseCase$updateQuestionAgeRange$2 extends Lambda implements Function1<Pair<? extends b, ? extends Optional<QuestionWAnswers>>, f> {
    final /* synthetic */ int $ageFrom;
    final /* synthetic */ int $ageTo;
    final /* synthetic */ boolean $isDealbreaker;
    final /* synthetic */ SaveAgePreferenceUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveAgePreferenceUseCase$updateQuestionAgeRange$2(SaveAgePreferenceUseCase saveAgePreferenceUseCase, int i10, int i11, boolean z10) {
        super(1);
        this.this$0 = saveAgePreferenceUseCase;
        this.$ageFrom = i10;
        this.$ageTo = i11;
        this.$isDealbreaker = z10;
    }

    /* renamed from: a */
    public final f invoke(Pair<b, Optional<QuestionWAnswers>> pair) {
        j.g(pair, "pair");
        String id2 = ((QuestionWAnswers) pair.d().get()).e().getId();
        return QuestionRepository.V(this.this$0.f35179d, pair.c().u(), (List) null, (String) null, (Integer) null, (Float) null, id2, ((QuestionWAnswers) pair.d().get()).e().getGroup().getQuestionGroupApiString(), Float.valueOf((float) this.$ageFrom), Float.valueOf((float) this.$ageTo), this.$isDealbreaker, (Location) null, 1054, (Object) null);
    }
}
