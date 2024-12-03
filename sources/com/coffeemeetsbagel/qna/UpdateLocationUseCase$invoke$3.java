package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class UpdateLocationUseCase$invoke$3 extends Lambda implements Function1<String, a<? extends Optional<QuestionWAnswers>>> {
    final /* synthetic */ UpdateLocationUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdateLocationUseCase$invoke$3(UpdateLocationUseCase updateLocationUseCase) {
        super(1);
        this.this$0 = updateLocationUseCase;
    }

    /* renamed from: a */
    public final a<? extends Optional<QuestionWAnswers>> invoke(String str) {
        j.g(str, "profileId");
        return this.this$0.f36225b.I(ProfileQuestion.LOCATION.getApiKey(), str);
    }
}
