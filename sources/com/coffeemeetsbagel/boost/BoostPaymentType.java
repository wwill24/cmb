package com.coffeemeetsbagel.boost;

public enum BoostPaymentType {
    GRANT("free_item"),
    BEANS("beans"),
    NONE("");
    
    private final String value;

    private BoostPaymentType(String str) {
        this.value = str;
    }

    public final String b() {
        return this.value;
    }
}
