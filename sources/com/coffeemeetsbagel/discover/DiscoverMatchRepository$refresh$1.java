package com.coffeemeetsbagel.discover;

import com.coffeemeetsbagel.models.responses.ResponseGiveTakes;
import com.coffeemeetsbagel.models.responses.ResponseRisingGiveTakes;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class DiscoverMatchRepository$refresh$1 extends Lambda implements Function1<Pair<? extends ResponseGiveTakes, ? extends ResponseRisingGiveTakes>, Unit> {
    final /* synthetic */ DiscoverMatchRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverMatchRepository$refresh$1(DiscoverMatchRepository discoverMatchRepository) {
        super(1);
        this.this$0 = discoverMatchRepository;
    }

    public final void a(Pair<? extends ResponseGiveTakes, ? extends ResponseRisingGiveTakes> pair) {
        this.this$0.f12168c.w("givetake_current_token", ((ResponseGiveTakes) pair.c()).getCurrentToken());
        this.this$0.f12168c.w("risinggivetakes_current_token", ((ResponseRisingGiveTakes) pair.d()).getCurrentToken());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
