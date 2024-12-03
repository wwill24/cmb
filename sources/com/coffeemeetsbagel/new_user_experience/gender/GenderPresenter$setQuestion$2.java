package com.coffeemeetsbagel.new_user_experience.gender;

import com.coffeemeetsbagel.models.entities.GenderType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GenderPresenter$setQuestion$2 extends Lambda implements Function1<GenderType, Unit> {
    final /* synthetic */ GenderPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderPresenter$setQuestion$2(GenderPresenter genderPresenter) {
        super(1);
        this.this$0 = genderPresenter;
    }

    public final void a(GenderType genderType) {
        GenderPresenter genderPresenter = this.this$0;
        j.f(genderType, "genderType");
        genderPresenter.f34999h = genderType;
        this.this$0.f34996e.o(genderType);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((GenderType) obj);
        return Unit.f32013a;
    }
}
