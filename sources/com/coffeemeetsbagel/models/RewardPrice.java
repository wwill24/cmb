package com.coffeemeetsbagel.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class RewardPrice {
    private final String currencyCode;
    private final String price;
    private final String priceMicros;

    public RewardPrice(String str, String str2, String str3) {
        j.g(str, "currencyCode");
        j.g(str2, FirebaseAnalytics.Param.PRICE);
        j.g(str3, "priceMicros");
        this.currencyCode = str;
        this.price = str2;
        this.priceMicros = str3;
    }

    private final String component2() {
        return this.price;
    }

    public static /* synthetic */ RewardPrice copy$default(RewardPrice rewardPrice, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = rewardPrice.currencyCode;
        }
        if ((i10 & 2) != 0) {
            str2 = rewardPrice.price;
        }
        if ((i10 & 4) != 0) {
            str3 = rewardPrice.priceMicros;
        }
        return rewardPrice.copy(str, str2, str3);
    }

    public final String component1() {
        return this.currencyCode;
    }

    public final String component3() {
        return this.priceMicros;
    }

    public final RewardPrice copy(String str, String str2, String str3) {
        j.g(str, "currencyCode");
        j.g(str2, FirebaseAnalytics.Param.PRICE);
        j.g(str3, "priceMicros");
        return new RewardPrice(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardPrice)) {
            return false;
        }
        RewardPrice rewardPrice = (RewardPrice) obj;
        return j.b(this.currencyCode, rewardPrice.currencyCode) && j.b(this.price, rewardPrice.price) && j.b(this.priceMicros, rewardPrice.priceMicros);
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getPriceMicros() {
        return this.priceMicros;
    }

    public int hashCode() {
        return (((this.currencyCode.hashCode() * 31) + this.price.hashCode()) * 31) + this.priceMicros.hashCode();
    }

    public String toString() {
        return "RewardPrice(currencyCode=" + this.currencyCode + ", price=" + this.price + ", priceMicros=" + this.priceMicros + PropertyUtils.MAPPED_DELIM2;
    }
}
