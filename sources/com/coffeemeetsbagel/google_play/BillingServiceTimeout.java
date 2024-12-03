package com.coffeemeetsbagel.google_play;

import kotlin.jvm.internal.j;

public final class BillingServiceTimeout extends Throwable {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingServiceTimeout(String str, int i10) {
        super("Timeout after " + i10 + " retries. " + str);
        j.g(str, "message");
    }
}
