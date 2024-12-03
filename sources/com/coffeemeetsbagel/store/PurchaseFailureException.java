package com.coffeemeetsbagel.store;

public final class PurchaseFailureException extends Throwable {
    private final PurchaseFailureType type;

    public final PurchaseFailureType a() {
        return this.type;
    }
}
