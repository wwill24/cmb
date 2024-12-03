package com.coffeemeetsbagel.suggested.models;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class SuggestedLimitsNetworkResponse {
    @c("num_bagels_required_for_upsell")
    private final Integer numBagelsRequiredForUpsell;
    @c("remaining_likes")
    private final Integer remainingLikes;
    @c("remaining_views")
    private final Integer remainingViews;

    public SuggestedLimitsNetworkResponse(Integer num, Integer num2, Integer num3) {
        this.remainingLikes = num;
        this.remainingViews = num2;
        this.numBagelsRequiredForUpsell = num3;
    }

    public static /* synthetic */ SuggestedLimitsNetworkResponse copy$default(SuggestedLimitsNetworkResponse suggestedLimitsNetworkResponse, Integer num, Integer num2, Integer num3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = suggestedLimitsNetworkResponse.remainingLikes;
        }
        if ((i10 & 2) != 0) {
            num2 = suggestedLimitsNetworkResponse.remainingViews;
        }
        if ((i10 & 4) != 0) {
            num3 = suggestedLimitsNetworkResponse.numBagelsRequiredForUpsell;
        }
        return suggestedLimitsNetworkResponse.copy(num, num2, num3);
    }

    public final Integer component1() {
        return this.remainingLikes;
    }

    public final Integer component2() {
        return this.remainingViews;
    }

    public final Integer component3() {
        return this.numBagelsRequiredForUpsell;
    }

    public final SuggestedLimitsNetworkResponse copy(Integer num, Integer num2, Integer num3) {
        return new SuggestedLimitsNetworkResponse(num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuggestedLimitsNetworkResponse)) {
            return false;
        }
        SuggestedLimitsNetworkResponse suggestedLimitsNetworkResponse = (SuggestedLimitsNetworkResponse) obj;
        return j.b(this.remainingLikes, suggestedLimitsNetworkResponse.remainingLikes) && j.b(this.remainingViews, suggestedLimitsNetworkResponse.remainingViews) && j.b(this.numBagelsRequiredForUpsell, suggestedLimitsNetworkResponse.numBagelsRequiredForUpsell);
    }

    public final Integer getNumBagelsRequiredForUpsell() {
        return this.numBagelsRequiredForUpsell;
    }

    public final Integer getRemainingLikes() {
        return this.remainingLikes;
    }

    public final Integer getRemainingViews() {
        return this.remainingViews;
    }

    public int hashCode() {
        Integer num = this.remainingLikes;
        int i10 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.remainingViews;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.numBagelsRequiredForUpsell;
        if (num3 != null) {
            i10 = num3.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "SuggestedLimitsNetworkResponse(remainingLikes=" + this.remainingLikes + ", remainingViews=" + this.remainingViews + ", numBagelsRequiredForUpsell=" + this.numBagelsRequiredForUpsell + PropertyUtils.MAPPED_DELIM2;
    }
}
