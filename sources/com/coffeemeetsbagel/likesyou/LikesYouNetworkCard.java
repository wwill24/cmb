package com.coffeemeetsbagel.likesyou;

import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouNetworkCard {
    private final int age;
    @c("bagel_id")
    private final String bagelId;
    private final String city;
    private final List<String> education;
    @c("image_url")
    private final String imageUrl;
    private final String occupation;
    @c("pair_like_comment")
    private final String pairLikeComment;
    @c("profile_id")
    private final String profileId;
    @c("purchase_attribution")
    private final Integer purchaseAttribution;

    public LikesYouNetworkCard(String str, int i10, String str2, String str3, List<String> list, String str4, String str5, String str6, Integer num) {
        j.g(str, "profileId");
        j.g(str2, "bagelId");
        this.profileId = str;
        this.age = i10;
        this.bagelId = str2;
        this.city = str3;
        this.education = list;
        this.occupation = str4;
        this.pairLikeComment = str5;
        this.imageUrl = str6;
        this.purchaseAttribution = num;
    }

    public static /* synthetic */ LikesYouNetworkCard copy$default(LikesYouNetworkCard likesYouNetworkCard, String str, int i10, String str2, String str3, List list, String str4, String str5, String str6, Integer num, int i11, Object obj) {
        LikesYouNetworkCard likesYouNetworkCard2 = likesYouNetworkCard;
        int i12 = i11;
        return likesYouNetworkCard.copy((i12 & 1) != 0 ? likesYouNetworkCard2.profileId : str, (i12 & 2) != 0 ? likesYouNetworkCard2.age : i10, (i12 & 4) != 0 ? likesYouNetworkCard2.bagelId : str2, (i12 & 8) != 0 ? likesYouNetworkCard2.city : str3, (i12 & 16) != 0 ? likesYouNetworkCard2.education : list, (i12 & 32) != 0 ? likesYouNetworkCard2.occupation : str4, (i12 & 64) != 0 ? likesYouNetworkCard2.pairLikeComment : str5, (i12 & 128) != 0 ? likesYouNetworkCard2.imageUrl : str6, (i12 & 256) != 0 ? likesYouNetworkCard2.purchaseAttribution : num);
    }

    public final String component1() {
        return this.profileId;
    }

    public final int component2() {
        return this.age;
    }

    public final String component3() {
        return this.bagelId;
    }

    public final String component4() {
        return this.city;
    }

    public final List<String> component5() {
        return this.education;
    }

    public final String component6() {
        return this.occupation;
    }

    public final String component7() {
        return this.pairLikeComment;
    }

    public final String component8() {
        return this.imageUrl;
    }

    public final Integer component9() {
        return this.purchaseAttribution;
    }

    public final LikesYouNetworkCard copy(String str, int i10, String str2, String str3, List<String> list, String str4, String str5, String str6, Integer num) {
        j.g(str, "profileId");
        j.g(str2, "bagelId");
        return new LikesYouNetworkCard(str, i10, str2, str3, list, str4, str5, str6, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikesYouNetworkCard)) {
            return false;
        }
        LikesYouNetworkCard likesYouNetworkCard = (LikesYouNetworkCard) obj;
        return j.b(this.profileId, likesYouNetworkCard.profileId) && this.age == likesYouNetworkCard.age && j.b(this.bagelId, likesYouNetworkCard.bagelId) && j.b(this.city, likesYouNetworkCard.city) && j.b(this.education, likesYouNetworkCard.education) && j.b(this.occupation, likesYouNetworkCard.occupation) && j.b(this.pairLikeComment, likesYouNetworkCard.pairLikeComment) && j.b(this.imageUrl, likesYouNetworkCard.imageUrl) && j.b(this.purchaseAttribution, likesYouNetworkCard.purchaseAttribution);
    }

    public final int getAge() {
        return this.age;
    }

    public final String getBagelId() {
        return this.bagelId;
    }

    public final String getCity() {
        return this.city;
    }

    public final List<String> getEducation() {
        return this.education;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getOccupation() {
        return this.occupation;
    }

    public final String getPairLikeComment() {
        return this.pairLikeComment;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final Integer getPurchaseAttribution() {
        return this.purchaseAttribution;
    }

    public int hashCode() {
        int hashCode = ((((this.profileId.hashCode() * 31) + Integer.hashCode(this.age)) * 31) + this.bagelId.hashCode()) * 31;
        String str = this.city;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.education;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.occupation;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.pairLikeComment;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.imageUrl;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.purchaseAttribution;
        if (num != null) {
            i10 = num.hashCode();
        }
        return hashCode6 + i10;
    }

    public String toString() {
        return "LikesYouNetworkCard(profileId=" + this.profileId + ", age=" + this.age + ", bagelId=" + this.bagelId + ", city=" + this.city + ", education=" + this.education + ", occupation=" + this.occupation + ", pairLikeComment=" + this.pairLikeComment + ", imageUrl=" + this.imageUrl + ", purchaseAttribution=" + this.purchaseAttribution + PropertyUtils.MAPPED_DELIM2;
    }
}
