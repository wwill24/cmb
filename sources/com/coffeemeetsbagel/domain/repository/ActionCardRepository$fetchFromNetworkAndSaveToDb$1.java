package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.responses.ResponseActionCards;
import com.coffeemeetsbagel.models.util.DateUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class ActionCardRepository$fetchFromNetworkAndSaveToDb$1 extends Lambda implements Function1<ResponseActionCards, Unit> {
    final /* synthetic */ ActionCardRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardRepository$fetchFromNetworkAndSaveToDb$1(ActionCardRepository actionCardRepository) {
        super(1);
        this.this$0 = actionCardRepository;
    }

    public final void a(ResponseActionCards responseActionCards) {
        this.this$0.f12388c.b("last_fetch_action_card_timestamp", DateUtils.getCurrentTimestamp());
        this.this$0.f12388c.f("action_card_shown", false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ResponseActionCards) obj);
        return Unit.f32013a;
    }
}
