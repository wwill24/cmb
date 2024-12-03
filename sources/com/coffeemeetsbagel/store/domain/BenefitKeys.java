package com.coffeemeetsbagel.store.domain;

import kotlin.jvm.internal.DefaultConstructorMarker;

public enum BenefitKeys {
    LIKES_YOU("likes_you"),
    READ_RECEIPTS("read_receipts"),
    ACTIVITY_REPORTS("activity_reports"),
    BOOST_IN_PREMIUM("boost_in_premium"),
    UNLIMITED_REWINDS("unlimited_rewinds"),
    SIX_THOUSAND_BEANS("beans_six_thousand"),
    UNLIMITED_SKIP_THE_LINE("unlimited_skip_the_line"),
    PREMIUM_PREFERENCES("premium_preferences"),
    PAID_LIKE("paid_likes_eight_per_month"),
    UNLIMITED_SUGGESTED_VIEWS("unlimited_suggested_views"),
    UNDEFINED("undefined");
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f36786a = null;
    private final String key;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f36786a = new a((DefaultConstructorMarker) null);
    }

    private BenefitKeys(String str) {
        this.key = str;
    }

    public final String b() {
        return this.key;
    }
}
