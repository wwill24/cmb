package com.coffeemeetsbagel.new_user_experience.gender;

import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class GenderInteractor$onNext$1 extends Lambda implements Function1<Boolean, f> {
    final /* synthetic */ GenderInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInteractor$onNext$1(GenderInteractor genderInteractor) {
        super(1);
        this.this$0 = genderInteractor;
    }

    /* renamed from: a */
    public final f invoke(Boolean bool) {
        j.g(bool, "profileUpToDate");
        if (bool.booleanValue()) {
            SaveAnswerUseCase b22 = this.this$0.b2();
            List e10 = p.e(this.this$0.f34990q);
            QuestionWAnswers Q1 = this.this$0.f34991t;
            j.d(Q1);
            String id2 = Q1.e().getId();
            QuestionWAnswers Q12 = this.this$0.f34991t;
            j.d(Q12);
            return SaveAnswerUseCase.d(b22, e10, (String) null, id2, Q12.e().getGroup().getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 960, (Object) null);
        }
        throw new Exception("Failed to update profile, didn't submit answers.");
    }
}
