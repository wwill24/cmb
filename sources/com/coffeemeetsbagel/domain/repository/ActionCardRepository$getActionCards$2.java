package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.dto.ActionCard;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class ActionCardRepository$getActionCards$2 extends Lambda implements Function1<Long, b0<? extends List<? extends ActionCard>>> {
    final /* synthetic */ ActionCardRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardRepository$getActionCards$2(ActionCardRepository actionCardRepository) {
        super(1);
        this.this$0 = actionCardRepository;
    }

    /* renamed from: a */
    public final b0<? extends List<ActionCard>> invoke(Long l10) {
        j.g(l10, "previousDateInMillis");
        if (l10.longValue() < DateUtils.getTimestampForLastNoon()) {
            return this.this$0.h();
        }
        return this.this$0.f12387b.a();
    }
}
