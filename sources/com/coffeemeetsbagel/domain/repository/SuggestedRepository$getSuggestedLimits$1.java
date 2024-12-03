package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;

final class SuggestedRepository$getSuggestedLimits$1 extends Lambda implements Function1<List<? extends SuggestedLimitsEntity>, a<? extends Optional<SuggestedLimitsEntity>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final SuggestedRepository$getSuggestedLimits$1 f12459a = new SuggestedRepository$getSuggestedLimits$1();

    SuggestedRepository$getSuggestedLimits$1() {
        super(1);
    }

    /* renamed from: a */
    public final a<? extends Optional<SuggestedLimitsEntity>> invoke(List<SuggestedLimitsEntity> list) {
        j.g(list, "limitsList");
        if (!list.isEmpty()) {
            return h.X(Optional.e(list.get(0)));
        }
        return h.X(Optional.a());
    }
}
