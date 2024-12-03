package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.models.School;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class BiographyInteractor$navigateToSchool$1 extends Lambda implements Function1<Optional<String>, b0<? extends List<? extends School>>> {
    final /* synthetic */ boolean $goingForwards;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$navigateToSchool$1(BiographyInteractor biographyInteractor, boolean z10) {
        super(1);
        this.this$0 = biographyInteractor;
        this.$goingForwards = z10;
    }

    /* renamed from: a */
    public final b0<? extends List<School>> invoke(Optional<String> optional) {
        j.g(optional, "nameOptional");
        ((BiographyPresenter) this.this$0.f7875e).T(optional.g(), this.$goingForwards);
        return this.this$0.D2().b();
    }
}
