package com.coffeemeetsbagel.google_play;

import kotlin.jvm.internal.j;

public final class BillingServiceDisconnected extends Throwable {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingServiceDisconnected(String str) {
        super(str);
        j.g(str, "message");
    }
}
