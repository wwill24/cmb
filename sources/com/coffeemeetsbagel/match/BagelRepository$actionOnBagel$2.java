package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.match.models.ActionOnBagelNetworkRequest;
import com.coffeemeetsbagel.models.Bagel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class BagelRepository$actionOnBagel$2 extends Lambda implements Function1<ActionOnBagelNetworkRequest, b0<? extends Bagel>> {
    final /* synthetic */ Bagel $bagel;
    final /* synthetic */ BagelRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BagelRepository$actionOnBagel$2(BagelRepository bagelRepository, Bagel bagel) {
        super(1);
        this.this$0 = bagelRepository;
        this.$bagel = bagel;
    }

    /* renamed from: a */
    public final b0<? extends Bagel> invoke(ActionOnBagelNetworkRequest actionOnBagelNetworkRequest) {
        j.g(actionOnBagelNetworkRequest, "it");
        return this.this$0.f34486b.c(this.$bagel.getId(), actionOnBagelNetworkRequest);
    }
}
