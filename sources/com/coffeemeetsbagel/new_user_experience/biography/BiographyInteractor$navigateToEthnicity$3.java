package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.models.ProfileDtoImplementation;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.entities.EthnicityType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BiographyInteractor$navigateToEthnicity$3 extends Lambda implements Function1<List<? extends Resource>, Unit> {
    final /* synthetic */ boolean $goingForwards;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$navigateToEthnicity$3(BiographyInteractor biographyInteractor, boolean z10) {
        super(1);
        this.this$0 = biographyInteractor;
        this.$goingForwards = z10;
    }

    public final void a(List<Resource> list) {
        List list2;
        List<EthnicityType> ethnicities;
        BiographyPresenter biographyPresenter = (BiographyPresenter) this.this$0.f7875e;
        ProfileDtoImplementation t22 = this.this$0.f34823y;
        if (t22 == null || (ethnicities = t22.getEthnicities()) == null) {
            list2 = q.j();
        } else {
            list2 = new ArrayList(r.t(ethnicities, 10));
            for (EthnicityType name : ethnicities) {
                list2.add(name.name());
            }
        }
        biographyPresenter.H(list, list2, this.$goingForwards);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
