package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.models.ModelDeeplinkData;

public enum ActionType {
    BAGEL_PREFS("bagel_preferences"),
    DISCOVER(ModelDeeplinkData.VALUE_PAGE_DISCOVER),
    DISCOVER_SEARCH("discover_search"),
    INVITE_FRIENDS("invite_friends"),
    LIMELIGHT("limelight"),
    PURCHASE_BOOST("purchase_boost"),
    PURCHASE_BONUS_BAGEL("purchase_bonus_bagel"),
    LIKE_PASS_FLOW("like_pass_flow"),
    PERIODIC_QUESTIONS("periodic_questions"),
    SUGGEST_PAYWALL_UPSELL("suggested_paywall_upsell"),
    SUGGEST_PAYWALL_INVENTORY("suggested_paywall_inventory"),
    DEFAULT("no_bagel");
    
    private final String value;

    private ActionType(String str) {
        this.value = str;
    }

    public final String b() {
        return this.value;
    }
}
