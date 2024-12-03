package com.coffeemeetsbagel.today_view.card.actioncards;

import kotlin.jvm.internal.j;

public final class NoEligibleActionCardFound extends Throwable {
    private final int actionCardCount;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoEligibleActionCardFound(int i10, String str) {
        super(str);
        j.g(str, "s");
        this.actionCardCount = i10;
    }

    public final int a() {
        return this.actionCardCount;
    }
}
