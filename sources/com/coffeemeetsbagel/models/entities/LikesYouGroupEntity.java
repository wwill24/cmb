package com.coffeemeetsbagel.models.entities;

import java.util.List;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouGroupEntity {
    private final String contextualRecommendationDesc;
    private final String contextualRecommendationIcon;
    private final String contextualRecommendationText;
    private final int count;
    private final String emptyStateAction;
    private final String emptyStateCtaText;
    private final String emptyStateDescription;
    private final String emptyStateImageUrl;
    private final String emptyStateTitleText;
    private List<String> freeProfileIds;
    private final int groupOrdinal;

    /* renamed from: id  reason: collision with root package name */
    private final String f34721id;
    private final Integer maxDisplayCounts;
    private final String name;

    public LikesYouGroupEntity(String str, String str2, int i10, int i11, List<String> list, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        j.g(str, "id");
        j.g(str2, "name");
        j.g(list, "freeProfileIds");
        this.f34721id = str;
        this.name = str2;
        this.count = i10;
        this.groupOrdinal = i11;
        this.freeProfileIds = list;
        this.maxDisplayCounts = num;
        this.contextualRecommendationIcon = str3;
        this.contextualRecommendationText = str4;
        this.contextualRecommendationDesc = str5;
        this.emptyStateAction = str6;
        this.emptyStateCtaText = str7;
        this.emptyStateDescription = str8;
        this.emptyStateImageUrl = str9;
        this.emptyStateTitleText = str10;
    }

    public static /* synthetic */ LikesYouGroupEntity copy$default(LikesYouGroupEntity likesYouGroupEntity, String str, String str2, int i10, int i11, List list, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i12, Object obj) {
        LikesYouGroupEntity likesYouGroupEntity2 = likesYouGroupEntity;
        int i13 = i12;
        return likesYouGroupEntity.copy((i13 & 1) != 0 ? likesYouGroupEntity2.f34721id : str, (i13 & 2) != 0 ? likesYouGroupEntity2.name : str2, (i13 & 4) != 0 ? likesYouGroupEntity2.count : i10, (i13 & 8) != 0 ? likesYouGroupEntity2.groupOrdinal : i11, (i13 & 16) != 0 ? likesYouGroupEntity2.freeProfileIds : list, (i13 & 32) != 0 ? likesYouGroupEntity2.maxDisplayCounts : num, (i13 & 64) != 0 ? likesYouGroupEntity2.contextualRecommendationIcon : str3, (i13 & 128) != 0 ? likesYouGroupEntity2.contextualRecommendationText : str4, (i13 & 256) != 0 ? likesYouGroupEntity2.contextualRecommendationDesc : str5, (i13 & 512) != 0 ? likesYouGroupEntity2.emptyStateAction : str6, (i13 & 1024) != 0 ? likesYouGroupEntity2.emptyStateCtaText : str7, (i13 & 2048) != 0 ? likesYouGroupEntity2.emptyStateDescription : str8, (i13 & Opcodes.ACC_SYNTHETIC) != 0 ? likesYouGroupEntity2.emptyStateImageUrl : str9, (i13 & 8192) != 0 ? likesYouGroupEntity2.emptyStateTitleText : str10);
    }

    public final String component1() {
        return this.f34721id;
    }

    public final String component10() {
        return this.emptyStateAction;
    }

    public final String component11() {
        return this.emptyStateCtaText;
    }

    public final String component12() {
        return this.emptyStateDescription;
    }

    public final String component13() {
        return this.emptyStateImageUrl;
    }

    public final String component14() {
        return this.emptyStateTitleText;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.count;
    }

    public final int component4() {
        return this.groupOrdinal;
    }

    public final List<String> component5() {
        return this.freeProfileIds;
    }

    public final Integer component6() {
        return this.maxDisplayCounts;
    }

    public final String component7() {
        return this.contextualRecommendationIcon;
    }

    public final String component8() {
        return this.contextualRecommendationText;
    }

    public final String component9() {
        return this.contextualRecommendationDesc;
    }

    public final LikesYouGroupEntity copy(String str, String str2, int i10, int i11, List<String> list, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        String str11 = str;
        j.g(str11, "id");
        String str12 = str2;
        j.g(str12, "name");
        List<String> list2 = list;
        j.g(list2, "freeProfileIds");
        return new LikesYouGroupEntity(str11, str12, i10, i11, list2, num, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikesYouGroupEntity)) {
            return false;
        }
        LikesYouGroupEntity likesYouGroupEntity = (LikesYouGroupEntity) obj;
        return j.b(this.f34721id, likesYouGroupEntity.f34721id) && j.b(this.name, likesYouGroupEntity.name) && this.count == likesYouGroupEntity.count && this.groupOrdinal == likesYouGroupEntity.groupOrdinal && j.b(this.freeProfileIds, likesYouGroupEntity.freeProfileIds) && j.b(this.maxDisplayCounts, likesYouGroupEntity.maxDisplayCounts) && j.b(this.contextualRecommendationIcon, likesYouGroupEntity.contextualRecommendationIcon) && j.b(this.contextualRecommendationText, likesYouGroupEntity.contextualRecommendationText) && j.b(this.contextualRecommendationDesc, likesYouGroupEntity.contextualRecommendationDesc) && j.b(this.emptyStateAction, likesYouGroupEntity.emptyStateAction) && j.b(this.emptyStateCtaText, likesYouGroupEntity.emptyStateCtaText) && j.b(this.emptyStateDescription, likesYouGroupEntity.emptyStateDescription) && j.b(this.emptyStateImageUrl, likesYouGroupEntity.emptyStateImageUrl) && j.b(this.emptyStateTitleText, likesYouGroupEntity.emptyStateTitleText);
    }

    public final String getContextualRecommendationDesc() {
        return this.contextualRecommendationDesc;
    }

    public final String getContextualRecommendationIcon() {
        return this.contextualRecommendationIcon;
    }

    public final String getContextualRecommendationText() {
        return this.contextualRecommendationText;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getEmptyStateAction() {
        return this.emptyStateAction;
    }

    public final String getEmptyStateCtaText() {
        return this.emptyStateCtaText;
    }

    public final String getEmptyStateDescription() {
        return this.emptyStateDescription;
    }

    public final String getEmptyStateImageUrl() {
        return this.emptyStateImageUrl;
    }

    public final String getEmptyStateTitleText() {
        return this.emptyStateTitleText;
    }

    public final List<String> getFreeProfileIds() {
        return this.freeProfileIds;
    }

    public final int getGroupOrdinal() {
        return this.groupOrdinal;
    }

    public final String getId() {
        return this.f34721id;
    }

    public final Integer getMaxDisplayCounts() {
        return this.maxDisplayCounts;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f34721id.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.groupOrdinal)) * 31) + this.freeProfileIds.hashCode()) * 31;
        Integer num = this.maxDisplayCounts;
        int i10 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.contextualRecommendationIcon;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.contextualRecommendationText;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.contextualRecommendationDesc;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.emptyStateAction;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.emptyStateCtaText;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.emptyStateDescription;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.emptyStateImageUrl;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.emptyStateTitleText;
        if (str8 != null) {
            i10 = str8.hashCode();
        }
        return hashCode9 + i10;
    }

    public final void setFreeProfileIds(List<String> list) {
        j.g(list, "<set-?>");
        this.freeProfileIds = list;
    }

    public String toString() {
        return "LikesYouGroupEntity(id=" + this.f34721id + ", name=" + this.name + ", count=" + this.count + ", groupOrdinal=" + this.groupOrdinal + ", freeProfileIds=" + this.freeProfileIds + ", maxDisplayCounts=" + this.maxDisplayCounts + ", contextualRecommendationIcon=" + this.contextualRecommendationIcon + ", contextualRecommendationText=" + this.contextualRecommendationText + ", contextualRecommendationDesc=" + this.contextualRecommendationDesc + ", emptyStateAction=" + this.emptyStateAction + ", emptyStateCtaText=" + this.emptyStateCtaText + ", emptyStateDescription=" + this.emptyStateDescription + ", emptyStateImageUrl=" + this.emptyStateImageUrl + ", emptyStateTitleText=" + this.emptyStateTitleText + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LikesYouGroupEntity(java.lang.String r19, java.lang.String r20, int r21, int r22, java.util.List r23, java.lang.Integer r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r9 = r2
            goto L_0x000b
        L_0x0009:
            r9 = r24
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0011
            r10 = r2
            goto L_0x0013
        L_0x0011:
            r10 = r25
        L_0x0013:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0019
            r11 = r2
            goto L_0x001b
        L_0x0019:
            r11 = r26
        L_0x001b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0021
            r12 = r2
            goto L_0x0023
        L_0x0021:
            r12 = r27
        L_0x0023:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0029
            r13 = r2
            goto L_0x002b
        L_0x0029:
            r13 = r28
        L_0x002b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0031
            r14 = r2
            goto L_0x0033
        L_0x0031:
            r14 = r29
        L_0x0033:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0039
            r15 = r2
            goto L_0x003b
        L_0x0039:
            r15 = r30
        L_0x003b:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0042
            r16 = r2
            goto L_0x0044
        L_0x0042:
            r16 = r31
        L_0x0044:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x004b
            r17 = r2
            goto L_0x004d
        L_0x004b:
            r17 = r32
        L_0x004d:
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.models.entities.LikesYouGroupEntity.<init>(java.lang.String, java.lang.String, int, int, java.util.List, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
