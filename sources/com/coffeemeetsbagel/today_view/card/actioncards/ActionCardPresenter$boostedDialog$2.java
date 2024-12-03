package com.coffeemeetsbagel.today_view.card.actioncards;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import o9.b;

final class ActionCardPresenter$boostedDialog$2 extends Lambda implements Function0<b> {
    final /* synthetic */ ActionCardPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardPresenter$boostedDialog$2(ActionCardPresenter actionCardPresenter) {
        super(0);
        this.this$0 = actionCardPresenter;
    }

    /* renamed from: a */
    public final b invoke() {
        return new b(this.this$0.f7869c.getContext(), true, (DialogInterface.OnCancelListener) null);
    }
}
