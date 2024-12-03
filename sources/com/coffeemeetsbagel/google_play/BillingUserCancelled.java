package com.coffeemeetsbagel.google_play;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class BillingUserCancelled extends Throwable {
    public BillingUserCancelled(String str) {
        super(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillingUserCancelled(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str);
    }
}
