package com.coffeemeetsbagel.store.alc;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.store.r0;

public enum PurchaseType {
    TIME_TURNER("TimeTurner", 0, 0, "time turner", "Time Turner"),
    DISCOVER_LIKES("Take", 385, r1, "discover likes", "Discover Likes"),
    UNLIMITED_BEANS("UnlimitedBeans", 0, r0.getting_unlimited_beans, "unlimited beans", "Unlimited Beans"),
    BONUS_BAGEL("BonusBagel2", 250, r0.unlocking_bonus_bagel, "bonus bagel", "Bonus Bagel"),
    WOO("Woo", 180, r0.sending_no_ellipse, "woo", "Woo"),
    UNKNOWN("Unknown", 0, 0, "unknown", ""),
    DISCOVER_SEARCH_RESULT("DiscoverSearchResult", 385, r1, "discover search result", "Discover Search Result"),
    SKIP_THE_LINE("SkipTheLine", 0, r7, "skip the line", "Skip the Line"),
    REOPEN_CHAT("ReopenChat", 199, r16, "reopen chat", "Reopen Chat"),
    PRICE_ERROR("PriceError", 385, r0.price_error, "price error", "Price Error"),
    BOOST("Boost", 0, r16, ModelDeeplinkData.VALUE_PAGE_BOOST, "Boost"),
    INSTANT_LIKE("InstantLike", 0, r16, "instant like", "Instant Like"),
    PAID_LIKE("PaidLike", 385, r0.sending_paid_like, "paid like", "Flower");
    
    private final String displayName;
    private final String mAnalyticsItemName;
    private final int mGettingStringId;
    private final String mItemName;
    private final long mPrice;

    private PurchaseType(String str, long j10, int i10, String str2, String str3) {
        this.mItemName = str;
        this.mPrice = j10;
        this.mGettingStringId = i10;
        this.mAnalyticsItemName = str2;
        this.displayName = str3;
    }

    public String a() {
        return this.mAnalyticsItemName;
    }

    public String b() {
        return this.displayName;
    }

    public int c() {
        return this.mGettingStringId;
    }

    public String d() {
        return this.mItemName;
    }

    public long e() {
        return this.mPrice;
    }
}
