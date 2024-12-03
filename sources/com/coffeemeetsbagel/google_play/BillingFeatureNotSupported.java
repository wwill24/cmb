package com.coffeemeetsbagel.google_play;

import kotlin.jvm.internal.j;

public final class BillingFeatureNotSupported extends Throwable {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingFeatureNotSupported(String str) {
        super(str);
        j.g(str, "message");
    }
}
