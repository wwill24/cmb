package com.coffeemeetsbagel.feature.profile_completion_helper.education;

import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class EducationViewModel$saveAnswers$3$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EducationViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EducationViewModel$saveAnswers$3$2(EducationViewModel educationViewModel) {
        super(0);
        this.this$0 = educationViewModel;
    }

    public final void invoke() {
        a.C0491a aVar = a.f40771d;
        String i10 = this.this$0.f13214f;
        j.f(i10, "tag");
        String apiKey = ProfileQuestion.DEGREE_ONE.getApiKey();
        aVar.b(i10, apiKey + " question not present ");
    }
}
