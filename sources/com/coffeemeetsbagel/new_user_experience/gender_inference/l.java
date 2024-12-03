package com.coffeemeetsbagel.new_user_experience.gender_inference;

import com.coffeemeetsbagel.models.enums.InferredGenderOptions;
import vj.a;

public final /* synthetic */ class l implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InferredGenderOptions f35050a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GenderInferenceInteractor f35051b;

    public /* synthetic */ l(InferredGenderOptions inferredGenderOptions, GenderInferenceInteractor genderInferenceInteractor) {
        this.f35050a = inferredGenderOptions;
        this.f35051b = genderInferenceInteractor;
    }

    public final void run() {
        GenderInferenceInteractor.f2(this.f35050a, this.f35051b);
    }
}
