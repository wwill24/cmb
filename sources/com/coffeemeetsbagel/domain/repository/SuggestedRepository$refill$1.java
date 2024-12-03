package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.suggested.models.RefillBagelsNetwork;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SuggestedRepository$refill$1 extends Lambda implements Function1<RefillBagelsNetwork, Unit> {
    final /* synthetic */ long $timestamp;
    final /* synthetic */ SuggestedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedRepository$refill$1(SuggestedRepository suggestedRepository, long j10) {
        super(1);
        this.this$0 = suggestedRepository;
        this.$timestamp = j10;
    }

    public final void a(RefillBagelsNetwork refillBagelsNetwork) {
        this.this$0.f12453c.b("LAST_REFILL_DATETIME", this.$timestamp);
        this.this$0.f12453c.f("OUT_OF_BAGELS", refillBagelsNetwork.getOutOfBagels());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((RefillBagelsNetwork) obj);
        return Unit.f32013a;
    }
}
