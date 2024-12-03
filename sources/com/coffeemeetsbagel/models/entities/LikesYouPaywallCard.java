package com.coffeemeetsbagel.models.entities;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouPaywallCard {
    private final String imageUrl;
    private final String profileId;
    private final Integer purchaseAttribution;

    public LikesYouPaywallCard(String str, String str2, Integer num) {
        j.g(str, "profileId");
        j.g(str2, "imageUrl");
        this.profileId = str;
        this.imageUrl = str2;
        this.purchaseAttribution = num;
    }

    public static /* synthetic */ LikesYouPaywallCard copy$default(LikesYouPaywallCard likesYouPaywallCard, String str, String str2, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = likesYouPaywallCard.profileId;
        }
        if ((i10 & 2) != 0) {
            str2 = likesYouPaywallCard.imageUrl;
        }
        if ((i10 & 4) != 0) {
            num = likesYouPaywallCard.purchaseAttribution;
        }
        return likesYouPaywallCard.copy(str, str2, num);
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

    public final LikesYouPaywallCard copy(String str, String str2, Integer num) {
        j.g(str, "profileId");
        j.g(str2, "imageUrl");
        return new LikesYouPaywallCard(str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikesYouPaywallCard)) {
            return false;
        }
        LikesYouPaywallCard likesYouPaywallCard = (LikesYouPaywallCard) obj;
        return j.b(this.profileId, likesYouPaywallCard.profileId) && j.b(this.imageUrl, likesYouPaywallCard.imageUrl) && j.b(this.purchaseAttribution, likesYouPaywallCard.purchaseAttribution);
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
        return "LikesYouPaywallCard(profileId=" + this.profileId + ", imageUrl=" + this.imageUrl + ", purchaseAttribution=" + this.purchaseAttribution + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LikesYouPaywallCard(String str, String str2, Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? null : num);
    }
}
