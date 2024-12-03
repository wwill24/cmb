package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.models.Bagel;
import fa.a;
import j5.x;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class ActionCardInteractor$purchaseBonusBagel$bonusBagelListener$1$1 extends Lambda implements Function1<List<? extends Long>, b0<? extends x>> {
    final /* synthetic */ Bagel $bagel;
    final /* synthetic */ ActionCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardInteractor$purchaseBonusBagel$bonusBagelListener$1$1(Bagel bagel, ActionCardInteractor actionCardInteractor) {
        super(1);
        this.$bagel = bagel;
        this.this$0 = actionCardInteractor;
    }

    /* renamed from: a */
    public final b0<? extends x> invoke(List<Long> list) {
        boolean z10;
        j.g(list, "it");
        String lastUpdated = this.$bagel.getLastUpdated();
        if (lastUpdated == null || lastUpdated.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String str = "missing last updated for bonus bagel " + this.$bagel.getId();
            a.f40771d.c(this.this$0.H, str, new IllegalArgumentException(str));
        }
        return this.this$0.o2().h(this.$bagel);
    }
}
