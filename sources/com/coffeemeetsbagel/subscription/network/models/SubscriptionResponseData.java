package com.coffeemeetsbagel.subscription.network.models;

import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class SubscriptionResponseData {
    @c("active_subscription")
    private final NetworkActiveSubscription activeSubscription;
    @c("bundles")
    private final List<NetworkSubscriptionBundle> subscriptionBundles;

    public SubscriptionResponseData(NetworkActiveSubscription networkActiveSubscription, List<NetworkSubscriptionBundle> list) {
        j.g(list, "subscriptionBundles");
        this.activeSubscription = networkActiveSubscription;
        this.subscriptionBundles = list;
    }

    public static /* synthetic */ SubscriptionResponseData copy$default(SubscriptionResponseData subscriptionResponseData, NetworkActiveSubscription networkActiveSubscription, List<NetworkSubscriptionBundle> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            networkActiveSubscription = subscriptionResponseData.activeSubscription;
        }
        if ((i10 & 2) != 0) {
            list = subscriptionResponseData.subscriptionBundles;
        }
        return subscriptionResponseData.copy(networkActiveSubscription, list);
    }

    public final NetworkActiveSubscription component1() {
        return this.activeSubscription;
    }

    public final List<NetworkSubscriptionBundle> component2() {
        return this.subscriptionBundles;
    }

    public final SubscriptionResponseData copy(NetworkActiveSubscription networkActiveSubscription, List<NetworkSubscriptionBundle> list) {
        j.g(list, "subscriptionBundles");
        return new SubscriptionResponseData(networkActiveSubscription, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionResponseData)) {
            return false;
        }
        SubscriptionResponseData subscriptionResponseData = (SubscriptionResponseData) obj;
        return j.b(this.activeSubscription, subscriptionResponseData.activeSubscription) && j.b(this.subscriptionBundles, subscriptionResponseData.subscriptionBundles);
    }

    public final NetworkActiveSubscription getActiveSubscription() {
        return this.activeSubscription;
    }

    public final List<NetworkSubscriptionBundle> getSubscriptionBundles() {
        return this.subscriptionBundles;
    }

    public int hashCode() {
        NetworkActiveSubscription networkActiveSubscription = this.activeSubscription;
        return ((networkActiveSubscription == null ? 0 : networkActiveSubscription.hashCode()) * 31) + this.subscriptionBundles.hashCode();
    }

    public String toString() {
        return "SubscriptionResponseData(activeSubscription=" + this.activeSubscription + ", subscriptionBundles=" + this.subscriptionBundles + PropertyUtils.MAPPED_DELIM2;
    }
}
