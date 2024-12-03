package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.suggested.models.SuggestedLimitsNetworkResponse;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedRepository$saveSuggestedLimitsFromNetwork$1 extends Lambda implements Function1<SuggestedLimitsNetworkResponse, Pair<? extends SuggestedLimitsNetworkResponse, ? extends Boolean>> {

    /* renamed from: a  reason: collision with root package name */
    public static final SuggestedRepository$saveSuggestedLimitsFromNetwork$1 f12460a = new SuggestedRepository$saveSuggestedLimitsFromNetwork$1();

    SuggestedRepository$saveSuggestedLimitsFromNetwork$1() {
        super(1);
    }

    /* renamed from: a */
    public final Pair<SuggestedLimitsNetworkResponse, Boolean> invoke(SuggestedLimitsNetworkResponse suggestedLimitsNetworkResponse) {
        j.g(suggestedLimitsNetworkResponse, "limits");
        return new Pair<>(suggestedLimitsNetworkResponse, Boolean.TRUE);
    }
}
