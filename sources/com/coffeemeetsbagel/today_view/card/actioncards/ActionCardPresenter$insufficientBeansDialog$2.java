package com.coffeemeetsbagel.today_view.card.actioncards;

import android.view.View;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.b0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ActionCardPresenter$insufficientBeansDialog$2 extends Lambda implements Function0<b0> {
    final /* synthetic */ ActionCardPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardPresenter$insufficientBeansDialog$2(ActionCardPresenter actionCardPresenter) {
        super(0);
        this.this$0 = actionCardPresenter;
    }

    /* access modifiers changed from: private */
    public static final void d(ActionCardPresenter actionCardPresenter, View view) {
        j.g(actionCardPresenter, "this$0");
        actionCardPresenter.f37250g.d(Unit.f32013a);
    }

    /* renamed from: c */
    public final b0 invoke() {
        b0 b0Var = new b0(this.this$0.f7869c.getContext(), R.string.dialog_notenoughbeans_title, R.string.dialog_notenoughbeans_content, R.string.dialog_notenoughbeans_button_dls);
        b0Var.b(new y(this.this$0));
        return b0Var;
    }
}
