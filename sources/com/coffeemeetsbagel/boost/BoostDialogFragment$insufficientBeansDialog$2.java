package com.coffeemeetsbagel.boost;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.b0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class BoostDialogFragment$insufficientBeansDialog$2 extends Lambda implements Function0<b0> {
    final /* synthetic */ BoostDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoostDialogFragment$insufficientBeansDialog$2(BoostDialogFragment boostDialogFragment) {
        super(0);
        this.this$0 = boostDialogFragment;
    }

    /* renamed from: a */
    public final b0 invoke() {
        return new b0(this.this$0.requireActivity(), R.string.dialog_notenoughbeans_title, R.string.dialog_notenoughbeans_content, R.string.dialog_notenoughbeans_button);
    }
}
