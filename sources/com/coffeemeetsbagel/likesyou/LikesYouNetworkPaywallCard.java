package com.coffeemeetsbagel.likesyou;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouNetworkPaywallCard {
    @c("image_url")
    private final String imageUrl;
    @c("profile_id")
    private final String profileId;
    @c("purchase_attribution")
    private final Integer purchaseAttribution;

    public LikesYouNetworkPaywallCard(String str, String str2, Integer num) {
        j.g(str, "profileId");
        j.g(str2, "imageUrl");
        this.profileId = str;
        this.imageUrl = str2;
        this.purchaseAttribution = num;
    }

    public static /* synthetic */ LikesYouNetworkPaywallCard copy$default(LikesYouNetworkPaywallCard likesYouNetworkPaywallCard, String str, String str2, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = likesYouNetworkPaywallCard.profileId;
        }
        if ((i10 & 2) != 0) {
            str2 = likesYouNetworkPaywallCard.imageUrl;
        }
        if ((i10 & 4) != 0) {
            num = likesYouNetworkPaywallCard.purchaseAttribution;
        }
        return likesYouNetworkPaywallCard.copy(str, str2, num);
    }

    public final String component1() {
        return this.profileId;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final Integer component3() {
        return this.purchaseAttribution;
    }

    public final LikesYouNetworkPaywallCard copy(String str, String str2, Integer num) {
        j.g(str, "profileId");
        j.g(str2, "imageUrl");
        return new LikesYouNetworkPaywallCard(str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikesYouNetworkPaywallCard)) {
            return false;
        }
        LikesYouNetworkPaywallCard likesYouNetworkPaywallCard = (LikesYouNetworkPaywallCard) obj;
        return j.b(this.profileId, likesYouNetworkPaywallCard.profileId) && j.b(this.imageUrl, likesYouNetworkPaywallCard.imageUrl) && j.b(this.purchaseAttribution, likesYouNetworkPaywallCard.purchaseAttribution);
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final Integer getPurchaseAttribution() {
        return this.purchaseAttribution;
    }

    public int hashCode() {
        int hashCode = ((this.profileId.hashCode() * 31) + this.imageUrl.hashCode()) * 31;
        Integer num = this.purchaseAttribution;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "LikesYouNetworkPaywallCard(profileId=" + this.profileId + ", imageUrl=" + this.imageUrl + ", purchaseAttribution=" + this.purchaseAttribution + PropertyUtils.MAPPED_DELIM2;
    }
}
