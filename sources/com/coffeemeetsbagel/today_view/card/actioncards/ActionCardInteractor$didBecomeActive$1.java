package com.coffeemeetsbagel.today_view.card.actioncards;

import android.content.Intent;
import c6.a;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class ActionCardInteractor$didBecomeActive$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ ActionCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardInteractor$didBecomeActive$1(ActionCardInteractor actionCardInteractor) {
        super(1);
        this.this$0 = actionCardInteractor;
    }

    public final void a(a aVar) {
        Serializable serializable;
        Intent a10 = aVar.a();
        if (a10 != null) {
            serializable = a10.getSerializableExtra(Extra.PURCHASE_TYPE);
        } else {
            serializable = null;
        }
        if (-1 == aVar.c() && PurchaseType.BOOST == serializable) {
            ((ActionCardPresenter) this.this$0.f7875e).u();
            this.this$0.V2();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return Unit.f32013a;
    }
}
