package com.coffeemeetsbagel.instant_like;

import org.jivesoftware.smack.sm.packet.StreamManagement;

public enum InstantLikeResultType {
    SUCCESSFUL("purchased"),
    FAIlED(StreamManagement.Failed.ELEMENT),
    CANCELLED_INSUFFICIENT_FUNDS("cancelled_insufficient_funds"),
    CANCELLED_SUFFICIENT_FUNDS("cancelled_sufficient_funds");
    
    private final String value;

    private InstantLikeResultType(String str) {
        this.value = str;
    }

    public final String b() {
        return this.value;
    }
}
