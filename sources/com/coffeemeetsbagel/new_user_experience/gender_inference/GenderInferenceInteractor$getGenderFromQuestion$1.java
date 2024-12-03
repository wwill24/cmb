package com.coffeemeetsbagel.new_user_experience.gender_inference;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import ja.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class GenderInferenceInteractor$getGenderFromQuestion$1 extends Lambda implements Function1<b, a<? extends ab.a>> {
    final /* synthetic */ GenderInferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInferenceInteractor$getGenderFromQuestion$1(GenderInferenceInteractor genderInferenceInteractor) {
        super(1);
        this.this$0 = genderInferenceInteractor;
    }

    /* renamed from: a */
    public final a<? extends ab.a> invoke(b bVar) {
        j.g(bVar, "user");
        return com.coffeemeetsbagel.qna.j.b(this.this$0.b2(), bVar.u(), QuestionGroupType.ONBOARDING, false, 4, (Object) null);
    }
}
