package com.coffeemeetsbagel.deactivate;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.b0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DeactivateCompRouter$dialogRatingFeedback$2 extends Lambda implements Function0<b0> {
    final /* synthetic */ DeactivateCompRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompRouter$dialogRatingFeedback$2(DeactivateCompRouter deactivateCompRouter) {
        super(0);
        this.this$0 = deactivateCompRouter;
    }

    /* renamed from: a */
    public final b0 invoke() {
        return new b0(this.this$0.f12005f, R.string.congratulations, R.string.dialog_rating_prompt, R.string.dialog_button_right_give_rating_dls);
    }
}
