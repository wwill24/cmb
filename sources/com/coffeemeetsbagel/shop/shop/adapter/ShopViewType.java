package com.coffeemeetsbagel.shop.shop.adapter;

public enum ShopViewType {
    HEADER,
    NON_PURCHASED_SUBSCRIPTION,
    DYNAMIC_PRE_SUBSCRIPTION_BENEFITS,
    DYNAMIC_POST_SUBSCRIPTION_BENEFITS,
    PURCHASE,
    FREE,
    ERROR_NO_PLAY,
    ERROR_NO_SKUS,
    SUBSCRIPTION_COMPARISONS,
    f36500k;

    public static ShopViewType a(int i10) {
        if (i10 >= 0 && i10 < values().length) {
            return values()[i10];
        }
        throw new IllegalArgumentException("Position " + i10 + " is not valid for Shop View Type\nValid positions are 0 through " + values().length);
    }
}
