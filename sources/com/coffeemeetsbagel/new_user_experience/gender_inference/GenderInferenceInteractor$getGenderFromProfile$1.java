package com.coffeemeetsbagel.new_user_experience.gender_inference;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import ja.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;
import x6.d;

final class GenderInferenceInteractor$getGenderFromProfile$1 extends Lambda implements Function1<b, a<? extends d<ProfileDataContract>>> {
    final /* synthetic */ GenderInferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInferenceInteractor$getGenderFromProfile$1(GenderInferenceInteractor genderInferenceInteractor) {
        super(1);
        this.this$0 = genderInferenceInteractor;
    }

    /* renamed from: a */
    public final a<? extends d<ProfileDataContract>> invoke(b bVar) {
        j.g(bVar, "user");
        return this.this$0.a2().h(bVar.u());
    }
}
