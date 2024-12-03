package com.coffeemeetsbagel.new_user_experience.gender_inference;

import com.coffeemeetsbagel.models.enums.InferredGenderOptions;
import com.coffeemeetsbagel.new_user_experience.gender_inference.GenderInferencePresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GenderInferencePresenter$didLoad$3 extends Lambda implements Function1<InferredGenderOptions, Unit> {
    final /* synthetic */ GenderInferencePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInferencePresenter$didLoad$3(GenderInferencePresenter genderInferencePresenter) {
        super(1);
        this.this$0 = genderInferencePresenter;
    }

    public final void a(InferredGenderOptions inferredGenderOptions) {
        GenderInferencePresenter.a n10 = this.this$0.f35031e;
        j.f(inferredGenderOptions, "it");
        n10.r1(inferredGenderOptions);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((InferredGenderOptions) obj);
        return Unit.f32013a;
    }
}
