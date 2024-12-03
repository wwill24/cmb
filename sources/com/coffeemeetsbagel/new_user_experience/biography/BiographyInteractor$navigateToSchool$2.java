package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.models.School;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BiographyInteractor$navigateToSchool$2 extends Lambda implements Function1<List<? extends School>, Unit> {
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$navigateToSchool$2(BiographyInteractor biographyInteractor) {
        super(1);
        this.this$0 = biographyInteractor;
    }

    public final void a(List<School> list) {
        j.f(list, "schoolList");
        ((BiographyPresenter) this.this$0.f7875e).w(list);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
