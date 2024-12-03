package com.coffeemeetsbagel.new_user_experience.gender_inference;

import com.coffeemeetsbagel.models.enums.InferredGenderOptions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GenderInferenceInteractor$didBecomeActive$1 extends Lambda implements Function1<InferredGenderOptions, Unit> {
    final /* synthetic */ GenderInferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInferenceInteractor$didBecomeActive$1(GenderInferenceInteractor genderInferenceInteractor) {
        super(1);
        this.this$0 = genderInferenceInteractor;
    }

    public final void a(InferredGenderOptions inferredGenderOptions) {
        j.f(inferredGenderOptions, "genderType");
        ((GenderInferencePresenter) this.this$0.f7875e).v(inferredGenderOptions);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((InferredGenderOptions) obj);
        return Unit.f32013a;
    }
}
