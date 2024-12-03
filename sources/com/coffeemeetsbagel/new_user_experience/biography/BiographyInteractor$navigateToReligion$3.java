package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.models.ProfileDtoImplementation;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.entities.ReligionType;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BiographyInteractor$navigateToReligion$3 extends Lambda implements Function1<List<? extends Resource>, Unit> {
    final /* synthetic */ boolean $goingForwards;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$navigateToReligion$3(BiographyInteractor biographyInteractor, boolean z10) {
        super(1);
        this.this$0 = biographyInteractor;
        this.$goingForwards = z10;
    }

    public final void a(List<Resource> list) {
        String str;
        ReligionType religion;
        BiographyPresenter biographyPresenter = (BiographyPresenter) this.this$0.f7875e;
        ProfileDtoImplementation t22 = this.this$0.f34823y;
        if (t22 == null || (religion = t22.getReligion()) == null) {
            str = null;
        } else {
            str = religion.getApiKey();
        }
        biographyPresenter.R(list, str, this.$goingForwards);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
