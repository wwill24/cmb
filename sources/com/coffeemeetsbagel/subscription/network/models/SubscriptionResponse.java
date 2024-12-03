package com.coffeemeetsbagel.subscription.network.models;

import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class SubscriptionResponse extends ResponseGeneric {
    @c("data")
    private final SubscriptionResponseData data;

    public SubscriptionResponse(SubscriptionResponseData subscriptionResponseData) {
        j.g(subscriptionResponseData, "data");
        this.data = subscriptionResponseData;
    }

    public static /* synthetic */ SubscriptionResponse copy$default(SubscriptionResponse subscriptionResponse, SubscriptionResponseData subscriptionResponseData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            subscriptionResponseData = subscriptionResponse.data;
        }
        return subscriptionResponse.copy(subscriptionResponseData);
    }

    public final SubscriptionResponseData component1() {
        return this.data;
    }

    public final SubscriptionResponse copy(SubscriptionResponseData subscriptionResponseData) {
        j.g(subscriptionResponseData, "data");
        return new SubscriptionResponse(subscriptionResponseData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubscriptionResponse) && j.b(this.data, ((SubscriptionResponse) obj).data);
    }

    public final SubscriptionResponseData getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "SubscriptionResponse(data=" + this.data + PropertyUtils.MAPPED_DELIM2;
    }
}
