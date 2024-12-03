package com.coffeemeetsbagel.models.entities;

import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouCardEntity {
    private final int age;
    private final String bagelId;
    private final String city;
    private final String education;
    private final List<String> groupIds;
    private final String imageUrl;
    private final String occupation;
    private final String pairLikeComment;
    private final String profileId;
    private final PurchaseAttribution purchaseAttribution;

    public LikesYouCardEntity(String str, List<String> list, int i10, String str2, String str3, String str4, String str5, String str6, String str7, PurchaseAttribution purchaseAttribution2) {
        j.g(str, "profileId");
        j.g(list, "groupIds");
        j.g(str2, "bagelId");
        this.profileId = str;
        this.groupIds = list;
        this.age = i10;
        this.bagelId = str2;
        this.city = str3;
        this.education = str4;
        this.occupation = str5;
        this.pairLikeComment = str6;
        this.imageUrl = str7;
        this.purchaseAttribution = purchaseAttribution2;
    }

    public static /* synthetic */ LikesYouCardEntity copy$default(LikesYouCardEntity likesYouCardEntity, String str, List list, int i10, String str2, String str3, String str4, String str5, String str6, String str7, PurchaseAttribution purchaseAttribution2, int i11, Object obj) {
        LikesYouCardEntity likesYouCardEntity2 = likesYouCardEntity;
        int i12 = i11;
        return likesYouCardEntity.copy((i12 & 1) != 0 ? likesYouCardEntity2.profileId : str, (i12 & 2) != 0 ? likesYouCardEntity2.groupIds : list, (i12 & 4) != 0 ? likesYouCardEntity2.age : i10, (i12 & 8) != 0 ? likesYouCardEntity2.bagelId : str2, (i12 & 16) != 0 ? likesYouCardEntity2.city : str3, (i12 & 32) != 0 ? likesYouCardEntity2.education : str4, (i12 & 64) != 0 ? likesYouCardEntity2.occupation : str5, (i12 & 128) != 0 ? likesYouCardEntity2.pairLikeComment : str6, (i12 & 256) != 0 ? likesYouCardEntity2.imageUrl : str7, (i12 & 512) != 0 ? likesYouCardEntity2.purchaseAttribution : purchaseAttribution2);
    }

    public final String component1() {
        return this.profileId;
    }

    public final PurchaseAttribution component10() {
        return this.purchaseAttribution;
    }

    public final List<String> component2() {
        return this.groupIds;
    }

    public final int component3() {
        return this.age;
    }

    public final String component4() {
        return this.bagelId;
    }

    public final String component5() {
        return this.city;
    }

    public final String component6() {
        return this.education;
    }

    public final String component7() {
        return this.occupation;
    }

    public final String component8() {
        return this.pairLikeComment;
    }

    public final String component9() {
        return this.imageUrl;
    }

    public final LikesYouCardEntity copy(String str, List<String> list, int i10, String str2, String str3, String str4, String str5, String str6, String str7, PurchaseAttribution purchaseAttribution2) {
        j.g(str, "profileId");
        j.g(list, "groupIds");
        String str8 = str2;
        j.g(str8, "bagelId");
        return new LikesYouCardEntity(str, list, i10, str8, str3, str4, str5, str6, str7, purchaseAttribution2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikesYouCardEntity)) {
            return false;
        }
        LikesYouCardEntity likesYouCardEntity = (LikesYouCardEntity) obj;
        return j.b(this.profileId, likesYouCardEntity.profileId) && j.b(this.groupIds, likesYouCardEntity.groupIds) && this.age == likesYouCardEntity.age && j.b(this.bagelId, likesYouCardEntity.bagelId) && j.b(this.city, likesYouCardEntity.city) && j.b(this.education, likesYouCardEntity.education) && j.b(this.occupation, likesYouCardEntity.occupation) && j.b(this.pairLikeComment, likesYouCardEntity.pairLikeComment) && j.b(this.imageUrl, likesYouCardEntity.imageUrl) && this.purchaseAttribution == likesYouCardEntity.purchaseAttribution;
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

    public final String getEducation() {
        return this.education;
    }

    public final List<String> getGroupIds() {
        return this.groupIds;
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

    public final PurchaseAttribution getPurchaseAttribution() {
        return this.purchaseAttribution;
    }

    public int hashCode() {
        int hashCode = ((((((this.profileId.hashCode() * 31) + this.groupIds.hashCode()) * 31) + Integer.hashCode(this.age)) * 31) + this.bagelId.hashCode()) * 31;
        String str = this.city;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.education;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.occupation;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.pairLikeComment;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.imageUrl;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        PurchaseAttribution purchaseAttribution2 = this.purchaseAttribution;
        if (purchaseAttribution2 != null) {
            i10 = purchaseAttribution2.hashCode();
        }
        return hashCode6 + i10;
    }

    public String toString() {
        return "LikesYouCardEntity(profileId=" + this.profileId + ", groupIds=" + this.groupIds + ", age=" + this.age + ", bagelId=" + this.bagelId + ", city=" + this.city + ", education=" + this.education + ", occupation=" + this.occupation + ", pairLikeComment=" + this.pairLikeComment + ", imageUrl=" + this.imageUrl + ", purchaseAttribution=" + this.purchaseAttribution + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LikesYouCardEntity(java.lang.String r15, java.util.List r16, int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, com.coffeemeetsbagel.models.enums.PurchaseAttribution r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = r2
            goto L_0x000b
        L_0x0009:
            r8 = r19
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r9 = r2
            goto L_0x0013
        L_0x0011:
            r9 = r20
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            r10 = r2
            goto L_0x001b
        L_0x0019:
            r10 = r21
        L_0x001b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0021
            r11 = r2
            goto L_0x0023
        L_0x0021:
            r11 = r22
        L_0x0023:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0029
            r12 = r2
            goto L_0x002b
        L_0x0029:
            r12 = r23
        L_0x002b:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0031
            r13 = r2
            goto L_0x0033
        L_0x0031:
            r13 = r24
        L_0x0033:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.models.entities.LikesYouCardEntity.<init>(java.lang.String, java.util.List, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.coffeemeetsbagel.models.enums.PurchaseAttribution, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
