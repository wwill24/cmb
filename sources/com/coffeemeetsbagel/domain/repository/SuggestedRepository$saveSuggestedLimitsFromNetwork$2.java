package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.suggested.models.SuggestedLimitsNetworkResponse;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SuggestedRepository$saveSuggestedLimitsFromNetwork$2 extends Lambda implements Function1<Pair<? extends SuggestedLimitsNetworkResponse, ? extends Boolean>, Unit> {
    final /* synthetic */ SuggestedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedRepository$saveSuggestedLimitsFromNetwork$2(SuggestedRepository suggestedRepository) {
        super(1);
        this.this$0 = suggestedRepository;
    }

    public final void a(Pair<SuggestedLimitsNetworkResponse, Boolean> pair) {
        this.this$0.f12453c.b("last_fetch_suggested_limits_timestamps", DateUtils.getCurrentTimestamp());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
