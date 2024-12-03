package com.coffeemeetsbagel.new_user_experience.gender_preference;

import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.new_user_experience.gender_preference.GenderPreferencePresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GenderPreferencePresenter$didLoad$3 extends Lambda implements Function1<GenderType, Unit> {
    final /* synthetic */ GenderPreferencePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderPreferencePresenter$didLoad$3(GenderPreferencePresenter genderPreferencePresenter) {
        super(1);
        this.this$0 = genderPreferencePresenter;
    }

    public final void a(GenderType genderType) {
        GenderPreferencePresenter.a m10 = this.this$0.f35057e;
        j.f(genderType, "genderType");
        m10.o(genderType);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((GenderType) obj);
        return Unit.f32013a;
    }
}
