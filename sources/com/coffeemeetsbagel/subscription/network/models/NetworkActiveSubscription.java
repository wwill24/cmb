package com.coffeemeetsbagel.subscription.network.models;

import com.coffeemeetsbagel.models.entities.SubscriptionState;
import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkActiveSubscription {
    @c("android")
    private final NetworkActiveSubscriptionAndroid androidData;
    @c("auto_renew")
    private final boolean autoRenew;
    @c("benefits")
    private final List<String> benefits;
    @c("bundle_id")
    private final String bundleId;
    @c("expiry_date")
    private final String expiryDate;
    @c("sku")
    private final String sku;
    @c("start_date")
    private final String startDate;
    private SubscriptionState subscriptionState;
    @c("subscription_state_android")
    private final Integer subscription_state_android;
    @c("tier")
    private final int tier;

    public NetworkActiveSubscription(Integer num, boolean z10, List<String> list, String str, String str2, String str3, String str4, SubscriptionState subscriptionState2, int i10, NetworkActiveSubscriptionAndroid networkActiveSubscriptionAndroid) {
        j.g(list, "benefits");
        j.g(str, "bundleId");
        j.g(str2, "expiryDate");
        j.g(str3, "sku");
        j.g(str4, "startDate");
        this.subscription_state_android = num;
        this.autoRenew = z10;
        this.benefits = list;
        this.bundleId = str;
        this.expiryDate = str2;
        this.sku = str3;
        this.startDate = str4;
        this.subscriptionState = subscriptionState2;
        this.tier = i10;
        this.androidData = networkActiveSubscriptionAndroid;
    }

    public static /* synthetic */ NetworkActiveSubscription copy$default(NetworkActiveSubscription networkActiveSubscription, Integer num, boolean z10, List list, String str, String str2, String str3, String str4, SubscriptionState subscriptionState2, int i10, NetworkActiveSubscriptionAndroid networkActiveSubscriptionAndroid, int i11, Object obj) {
        NetworkActiveSubscription networkActiveSubscription2 = networkActiveSubscription;
        int i12 = i11;
        return networkActiveSubscription.copy((i12 & 1) != 0 ? networkActiveSubscription2.subscription_state_android : num, (i12 & 2) != 0 ? networkActiveSubscription2.autoRenew : z10, (i12 & 4) != 0 ? networkActiveSubscription2.benefits : list, (i12 & 8) != 0 ? networkActiveSubscription2.bundleId : str, (i12 & 16) != 0 ? networkActiveSubscription2.expiryDate : str2, (i12 & 32) != 0 ? networkActiveSubscription2.sku : str3, (i12 & 64) != 0 ? networkActiveSubscription2.startDate : str4, (i12 & 128) != 0 ? networkActiveSubscription2.subscriptionState : subscriptionState2, (i12 & 256) != 0 ? networkActiveSubscription2.tier : i10, (i12 & 512) != 0 ? networkActiveSubscription2.androidData : networkActiveSubscriptionAndroid);
    }

    public final Integer component1() {
        return this.subscription_state_android;
    }

    public final NetworkActiveSubscriptionAndroid component10() {
        return this.androidData;
    }

    public final boolean component2() {
        return this.autoRenew;
    }

    public final List<String> component3() {
        return this.benefits;
    }

    public final String component4() {
        return this.bundleId;
    }

    public final String component5() {
        return this.expiryDate;
    }

    public final String component6() {
        return this.sku;
    }

    public final String component7() {
        return this.startDate;
    }

    public final SubscriptionState component8() {
        return this.subscriptionState;
    }

    public final int component9() {
        return this.tier;
    }

    public final NetworkActiveSubscription copy(Integer num, boolean z10, List<String> list, String str, String str2, String str3, String str4, SubscriptionState subscriptionState2, int i10, NetworkActiveSubscriptionAndroid networkActiveSubscriptionAndroid) {
        j.g(list, "benefits");
        String str5 = str;
        j.g(str5, "bundleId");
        String str6 = str2;
        j.g(str6, "expiryDate");
        String str7 = str3;
        j.g(str7, "sku");
        String str8 = str4;
        j.g(str8, "startDate");
        return new NetworkActiveSubscription(num, z10, list, str5, str6, str7, str8, subscriptionState2, i10, networkActiveSubscriptionAndroid);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkActiveSubscription)) {
            return false;
        }
        NetworkActiveSubscription networkActiveSubscription = (NetworkActiveSubscription) obj;
        return j.b(this.subscription_state_android, networkActiveSubscription.subscription_state_android) && this.autoRenew == networkActiveSubscription.autoRenew && j.b(this.benefits, networkActiveSubscription.benefits) && j.b(this.bundleId, networkActiveSubscription.bundleId) && j.b(this.expiryDate, networkActiveSubscription.expiryDate) && j.b(this.sku, networkActiveSubscription.sku) && j.b(this.startDate, networkActiveSubscription.startDate) && this.subscriptionState == networkActiveSubscription.subscriptionState && this.tier == networkActiveSubscription.tier && j.b(this.androidData, networkActiveSubscription.androidData);
    }

    public final NetworkActiveSubscriptionAndroid getAndroidData() {
        return this.androidData;
    }

    public final boolean getAutoRenew() {
        return this.autoRenew;
    }

    public final List<String> getBenefits() {
        return this.benefits;
    }

    public final String getBundleId() {
        return this.bundleId;
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final String getSku() {
        return this.sku;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final SubscriptionState getSubscriptionState() {
        return this.subscriptionState;
    }

    public final Integer getSubscription_state_android() {
        return this.subscription_state_android;
    }

    public final int getTier() {
        return this.tier;
    }

    public int hashCode() {
        Integer num = this.subscription_state_android;
        int i10 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        boolean z10 = this.autoRenew;
        if (z10) {
            z10 = true;
        }
        int hashCode2 = (((((((((((hashCode + (z10 ? 1 : 0)) * 31) + this.benefits.hashCode()) * 31) + this.bundleId.hashCode()) * 31) + this.expiryDate.hashCode()) * 31) + this.sku.hashCode()) * 31) + this.startDate.hashCode()) * 31;
        SubscriptionState subscriptionState2 = this.subscriptionState;
        int hashCode3 = (((hashCode2 + (subscriptionState2 == null ? 0 : subscriptionState2.hashCode())) * 31) + Integer.hashCode(this.tier)) * 31;
        NetworkActiveSubscriptionAndroid networkActiveSubscriptionAndroid = this.androidData;
        if (networkActiveSubscriptionAndroid != null) {
            i10 = networkActiveSubscriptionAndroid.hashCode();
        }
        return hashCode3 + i10;
    }

    public final void setSubscriptionState(SubscriptionState subscriptionState2) {
        this.subscriptionState = subscriptionState2;
    }

    public String toString() {
        return "NetworkActiveSubscription(subscription_state_android=" + this.subscription_state_android + ", autoRenew=" + this.autoRenew + ", benefits=" + this.benefits + ", bundleId=" + this.bundleId + ", expiryDate=" + this.expiryDate + ", sku=" + this.sku + ", startDate=" + this.startDate + ", subscriptionState=" + this.subscriptionState + ", tier=" + this.tier + ", androidData=" + this.androidData + PropertyUtils.MAPPED_DELIM2;
    }
}
