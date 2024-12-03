package com.coffeemeetsbagel.boost;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import r7.h;

final class BoostDialogFragment$processDialog$2 extends Lambda implements Function0<h> {
    final /* synthetic */ BoostDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoostDialogFragment$processDialog$2(BoostDialogFragment boostDialogFragment) {
        super(0);
        this.this$0 = boostDialogFragment;
    }

    /* renamed from: a */
    public final h invoke() {
        return new h(this.this$0.getActivity());
    }
}
