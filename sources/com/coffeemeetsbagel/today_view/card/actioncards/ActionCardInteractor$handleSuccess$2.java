package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.models.util.DateUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class ActionCardInteractor$handleSuccess$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ ActionCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardInteractor$handleSuccess$2(ActionCardInteractor actionCardInteractor) {
        super(1);
        this.this$0 = actionCardInteractor;
    }

    public final void a(Boolean bool) {
        ((a0) this.this$0.B1()).q(this.this$0.f37229f, this.this$0.f37230g, this.this$0.p2().a("ProfileMigration.Enabled.Android"));
        this.this$0.w2().b("last_show_like_pass_flow", DateUtils.getCurrentTimestamp());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Boolean) obj);
        return Unit.f32013a;
    }
}
