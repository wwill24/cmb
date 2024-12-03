package com.coffeemeetsbagel.models.enums;

public enum BagelAction {
    NONE(0),
    LIKE(1),
    PASS(2),
    CHECK(3);
    
    private int businessId;

    private BagelAction(int i10) {
        this.businessId = i10;
    }

    public static BagelAction fromActionId(int i10) {
        for (BagelAction bagelAction : values()) {
            if (bagelAction.businessId == i10) {
                return bagelAction;
            }
        }
        throw new IllegalArgumentException("Not a valid bagel action id!");
    }

    public int getId() {
        return this.businessId;
    }
}
