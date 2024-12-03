package com.coffeemeetsbagel.instant_like;

public enum InstantLikePaymentType {
    GRANT("free_item"),
    BEANS("beans");
    
    private final String value;

    private InstantLikePaymentType(String str) {
        this.value = str;
    }

    public final String b() {
        return this.value;
    }
}
