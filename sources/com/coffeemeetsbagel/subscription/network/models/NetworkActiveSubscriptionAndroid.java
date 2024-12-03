package com.coffeemeetsbagel.subscription.network.models;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkActiveSubscriptionAndroid {
    @c("purchase_token")
    private final String purchaseToken;

    public NetworkActiveSubscriptionAndroid(String str) {
        this.purchaseToken = str;
    }

    public static /* synthetic */ NetworkActiveSubscriptionAndroid copy$default(NetworkActiveSubscriptionAndroid networkActiveSubscriptionAndroid, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = networkActiveSubscriptionAndroid.purchaseToken;
        }
        return networkActiveSubscriptionAndroid.copy(str);
    }

    public final String component1() {
        return this.purchaseToken;
    }

    public final NetworkActiveSubscriptionAndroid copy(String str) {
        return new NetworkActiveSubscriptionAndroid(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkActiveSubscriptionAndroid) && j.b(this.purchaseToken, ((NetworkActiveSubscriptionAndroid) obj).purchaseToken);
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public int hashCode() {
        String str = this.purchaseToken;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "NetworkActiveSubscriptionAndroid(purchaseToken=" + this.purchaseToken + PropertyUtils.MAPPED_DELIM2;
    }
}
