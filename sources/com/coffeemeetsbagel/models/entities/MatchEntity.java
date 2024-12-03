package com.coffeemeetsbagel.models.entities;

import com.coffeemeetsbagel.models.dto.MatchContract;
import com.coffeemeetsbagel.models.enums.MatchAction;
import com.coffeemeetsbagel.models.enums.MatchType;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import j$.time.OffsetDateTime;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;

public final class MatchEntity implements MatchContract {
    private final MatchAction action;
    private final OffsetDateTime endAt;

    /* renamed from: id  reason: collision with root package name */
    private final String f34722id;
    private final boolean isBlocked;
    private final boolean isRising;
    private final String likeComment;
    private final String matchToMe;
    private final String message;
    private final ProfileEntity profile;
    private final String profileId;
    private final PurchaseAttribution purchaseAttribution;
    private final int risingCount;
    private final Integer showOrder;
    private final OffsetDateTime startAt;
    private final MatchType type;
    private final int wooCount;
    private final int wooSeenCount;

    public MatchEntity(String str, MatchAction matchAction, OffsetDateTime offsetDateTime, boolean z10, boolean z11, String str2, String str3, String str4, int i10, Integer num, OffsetDateTime offsetDateTime2, MatchType matchType, int i11, int i12, PurchaseAttribution purchaseAttribution2, String str5, ProfileEntity profileEntity) {
        String str6 = str4;
        OffsetDateTime offsetDateTime3 = offsetDateTime2;
        MatchType matchType2 = matchType;
        String str7 = str5;
        j.g(str, "id");
        j.g(matchAction, "action");
        j.g(offsetDateTime, "endAt");
        j.g(str6, "profileId");
        j.g(offsetDateTime3, "startAt");
        j.g(matchType2, "type");
        j.g(str7, "matchToMe");
        this.f34722id = str;
        this.action = matchAction;
        this.endAt = offsetDateTime;
        this.isBlocked = z10;
        this.isRising = z11;
        this.likeComment = str2;
        this.message = str3;
        this.profileId = str6;
        this.risingCount = i10;
        this.showOrder = num;
        this.startAt = offsetDateTime3;
        this.type = matchType2;
        this.wooCount = i11;
        this.wooSeenCount = i12;
        this.purchaseAttribution = purchaseAttribution2;
        this.matchToMe = str7;
        this.profile = profileEntity;
    }

    public static /* synthetic */ MatchEntity copy$default(MatchEntity matchEntity, String str, MatchAction matchAction, OffsetDateTime offsetDateTime, boolean z10, boolean z11, String str2, String str3, String str4, int i10, Integer num, OffsetDateTime offsetDateTime2, MatchType matchType, int i11, int i12, PurchaseAttribution purchaseAttribution2, String str5, ProfileEntity profileEntity, int i13, Object obj) {
        PurchaseAttribution purchaseAttribution3;
        ProfileEntity profileEntity2;
        int i14 = i13;
        String id2 = (i14 & 1) != 0 ? matchEntity.getId() : str;
        MatchAction action2 = (i14 & 2) != 0 ? matchEntity.getAction() : matchAction;
        OffsetDateTime endAt2 = (i14 & 4) != 0 ? matchEntity.getEndAt() : offsetDateTime;
        boolean isBlocked2 = (i14 & 8) != 0 ? matchEntity.isBlocked() : z10;
        boolean isRising2 = (i14 & 16) != 0 ? matchEntity.isRising() : z11;
        String likeComment2 = (i14 & 32) != 0 ? matchEntity.getLikeComment() : str2;
        String message2 = (i14 & 64) != 0 ? matchEntity.getMessage() : str3;
        String profileId2 = (i14 & 128) != 0 ? matchEntity.getProfileId() : str4;
        int risingCount2 = (i14 & 256) != 0 ? matchEntity.getRisingCount() : i10;
        Integer showOrder2 = (i14 & 512) != 0 ? matchEntity.getShowOrder() : num;
        OffsetDateTime startAt2 = (i14 & 1024) != 0 ? matchEntity.getStartAt() : offsetDateTime2;
        MatchType type2 = (i14 & 2048) != 0 ? matchEntity.getType() : matchType;
        int wooCount2 = (i14 & Opcodes.ACC_SYNTHETIC) != 0 ? matchEntity.getWooCount() : i11;
        int wooSeenCount2 = (i14 & 8192) != 0 ? matchEntity.getWooSeenCount() : i12;
        PurchaseAttribution purchaseAttribution4 = (i14 & Opcodes.ACC_ENUM) != 0 ? matchEntity.getPurchaseAttribution() : purchaseAttribution2;
        String matchToMe2 = (i14 & 32768) != 0 ? matchEntity.getMatchToMe() : str5;
        if ((i14 & 65536) != 0) {
            purchaseAttribution3 = purchaseAttribution4;
            profileEntity2 = matchEntity.profile;
        } else {
            MatchEntity matchEntity2 = matchEntity;
            purchaseAttribution3 = purchaseAttribution4;
            profileEntity2 = profileEntity;
        }
        return matchEntity.copy(id2, action2, endAt2, isBlocked2, isRising2, likeComment2, message2, profileId2, risingCount2, showOrder2, startAt2, type2, wooCount2, wooSeenCount2, purchaseAttribution3, matchToMe2, profileEntity2);
    }

    public final String component1() {
        return getId();
    }

    public final Integer component10() {
        return getShowOrder();
    }

    public final OffsetDateTime component11() {
        return getStartAt();
    }

    public final MatchType component12() {
        return getType();
    }

    public final int component13() {
        return getWooCount();
    }

    public final int component14() {
        return getWooSeenCount();
    }

    public final PurchaseAttribution component15() {
        return getPurchaseAttribution();
    }

    public final String component16() {
        return getMatchToMe();
    }

    public final ProfileEntity component17() {
        return this.profile;
    }

    public final MatchAction component2() {
        return getAction();
    }

    public final OffsetDateTime component3() {
        return getEndAt();
    }

    public final boolean component4() {
        return isBlocked();
    }

    public final boolean component5() {
        return isRising();
    }

    public final String component6() {
        return getLikeComment();
    }

    public final String component7() {
        return getMessage();
    }

    public final String component8() {
        return getProfileId();
    }

    public final int component9() {
        return getRisingCount();
    }

    public final MatchEntity copy(String str, MatchAction matchAction, OffsetDateTime offsetDateTime, boolean z10, boolean z11, String str2, String str3, String str4, int i10, Integer num, OffsetDateTime offsetDateTime2, MatchType matchType, int i11, int i12, PurchaseAttribution purchaseAttribution2, String str5, ProfileEntity profileEntity) {
        String str6 = str;
        j.g(str6, "id");
        j.g(matchAction, "action");
        j.g(offsetDateTime, "endAt");
        j.g(str4, "profileId");
        j.g(offsetDateTime2, "startAt");
        j.g(matchType, "type");
        j.g(str5, "matchToMe");
        return new MatchEntity(str6, matchAction, offsetDateTime, z10, z11, str2, str3, str4, i10, num, offsetDateTime2, matchType, i11, i12, purchaseAttribution2, str5, profileEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchEntity)) {
            return false;
        }
        MatchEntity matchEntity = (MatchEntity) obj;
        return j.b(getId(), matchEntity.getId()) && getAction() == matchEntity.getAction() && j.b(getEndAt(), matchEntity.getEndAt()) && isBlocked() == matchEntity.isBlocked() && isRising() == matchEntity.isRising() && j.b(getLikeComment(), matchEntity.getLikeComment()) && j.b(getMessage(), matchEntity.getMessage()) && j.b(getProfileId(), matchEntity.getProfileId()) && getRisingCount() == matchEntity.getRisingCount() && j.b(getShowOrder(), matchEntity.getShowOrder()) && j.b(getStartAt(), matchEntity.getStartAt()) && getType() == matchEntity.getType() && getWooCount() == matchEntity.getWooCount() && getWooSeenCount() == matchEntity.getWooSeenCount() && getPurchaseAttribution() == matchEntity.getPurchaseAttribution() && j.b(getMatchToMe(), matchEntity.getMatchToMe()) && j.b(this.profile, matchEntity.profile);
    }

    public MatchAction getAction() {
        return this.action;
    }

    public OffsetDateTime getEndAt() {
        return this.endAt;
    }

    public String getId() {
        return this.f34722id;
    }

    public String getLikeComment() {
        return this.likeComment;
    }

    public String getMatchToMe() {
        return this.matchToMe;
    }

    public String getMessage() {
        return this.message;
    }

    public final ProfileEntity getProfile() {
        return this.profile;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public PurchaseAttribution getPurchaseAttribution() {
        return this.purchaseAttribution;
    }

    public int getRisingCount() {
        return this.risingCount;
    }

    public Integer getShowOrder() {
        return this.showOrder;
    }

    public OffsetDateTime getStartAt() {
        return this.startAt;
    }

    public MatchType getType() {
        return this.type;
    }

    public int getWooCount() {
        return this.wooCount;
    }

    public int getWooSeenCount() {
        return this.wooSeenCount;
    }

    public int hashCode() {
        int hashCode = ((((getId().hashCode() * 31) + getAction().hashCode()) * 31) + getEndAt().hashCode()) * 31;
        boolean isBlocked2 = isBlocked();
        boolean z10 = true;
        if (isBlocked2) {
            isBlocked2 = true;
        }
        int i10 = (hashCode + (isBlocked2 ? 1 : 0)) * 31;
        boolean isRising2 = isRising();
        if (!isRising2) {
            z10 = isRising2;
        }
        int i11 = (i10 + (z10 ? 1 : 0)) * 31;
        int i12 = 0;
        int hashCode2 = (((((((((((((((((((((i11 + (getLikeComment() == null ? 0 : getLikeComment().hashCode())) * 31) + (getMessage() == null ? 0 : getMessage().hashCode())) * 31) + getProfileId().hashCode()) * 31) + Integer.hashCode(getRisingCount())) * 31) + (getShowOrder() == null ? 0 : getShowOrder().hashCode())) * 31) + getStartAt().hashCode()) * 31) + getType().hashCode()) * 31) + Integer.hashCode(getWooCount())) * 31) + Integer.hashCode(getWooSeenCount())) * 31) + (getPurchaseAttribution() == null ? 0 : getPurchaseAttribution().hashCode())) * 31) + getMatchToMe().hashCode()) * 31;
        ProfileEntity profileEntity = this.profile;
        if (profileEntity != null) {
            i12 = profileEntity.hashCode();
        }
        return hashCode2 + i12;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public boolean isRising() {
        return this.isRising;
    }

    public String toString() {
        return "MatchEntity(id=" + getId() + ", action=" + getAction() + ", endAt=" + getEndAt() + ", isBlocked=" + isBlocked() + ", isRising=" + isRising() + ", likeComment=" + getLikeComment() + ", message=" + getMessage() + ", profileId=" + getProfileId() + ", risingCount=" + getRisingCount() + ", showOrder=" + getShowOrder() + ", startAt=" + getStartAt() + ", type=" + getType() + ", wooCount=" + getWooCount() + ", wooSeenCount=" + getWooSeenCount() + ", purchaseAttribution=" + getPurchaseAttribution() + ", matchToMe=" + getMatchToMe() + ", profile=" + this.profile + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MatchEntity(java.lang.String r21, com.coffeemeetsbagel.models.enums.MatchAction r22, j$.time.OffsetDateTime r23, boolean r24, boolean r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, int r29, java.lang.Integer r30, j$.time.OffsetDateTime r31, com.coffeemeetsbagel.models.enums.MatchType r32, int r33, int r34, com.coffeemeetsbagel.models.enums.PurchaseAttribution r35, java.lang.String r36, com.coffeemeetsbagel.models.entities.ProfileEntity r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r20 = this;
            r0 = r38
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            com.coffeemeetsbagel.models.enums.MatchAction r1 = com.coffeemeetsbagel.models.enums.MatchAction.NONE
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r22
        L_0x000c:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r6 = r2
            goto L_0x0015
        L_0x0013:
            r6 = r24
        L_0x0015:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x001b
            r7 = r2
            goto L_0x001d
        L_0x001b:
            r7 = r25
        L_0x001d:
            r1 = r0 & 32
            r3 = 0
            if (r1 == 0) goto L_0x0024
            r8 = r3
            goto L_0x0026
        L_0x0024:
            r8 = r26
        L_0x0026:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002c
            r9 = r3
            goto L_0x002e
        L_0x002c:
            r9 = r27
        L_0x002e:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0034
            r11 = r2
            goto L_0x0036
        L_0x0034:
            r11 = r29
        L_0x0036:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x003c
            r12 = r3
            goto L_0x003e
        L_0x003c:
            r12 = r30
        L_0x003e:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0044
            r15 = r2
            goto L_0x0046
        L_0x0044:
            r15 = r33
        L_0x0046:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x004d
            r16 = r2
            goto L_0x004f
        L_0x004d:
            r16 = r34
        L_0x004f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0056
            r17 = r3
            goto L_0x0058
        L_0x0056:
            r17 = r35
        L_0x0058:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0067
            com.coffeemeetsbagel.models.enums.MatchToMe r1 = com.coffeemeetsbagel.models.enums.MatchToMe.OTHER
            java.lang.String r1 = r1.getValue()
            r18 = r1
            goto L_0x0069
        L_0x0067:
            r18 = r36
        L_0x0069:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0071
            r19 = r3
            goto L_0x0073
        L_0x0071:
            r19 = r37
        L_0x0073:
            r2 = r20
            r3 = r21
            r5 = r23
            r10 = r28
            r13 = r31
            r14 = r32
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.models.entities.MatchEntity.<init>(java.lang.String, com.coffeemeetsbagel.models.enums.MatchAction, j$.time.OffsetDateTime, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Integer, j$.time.OffsetDateTime, com.coffeemeetsbagel.models.enums.MatchType, int, int, com.coffeemeetsbagel.models.enums.PurchaseAttribution, java.lang.String, com.coffeemeetsbagel.models.entities.ProfileEntity, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MatchEntity(java.lang.String r21, com.coffeemeetsbagel.models.enums.MatchAction r22, j$.time.OffsetDateTime r23, boolean r24, boolean r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, int r29, java.lang.Integer r30, j$.time.OffsetDateTime r31, com.coffeemeetsbagel.models.enums.MatchType r32, int r33, int r34, com.coffeemeetsbagel.models.enums.PurchaseAttribution r35, java.lang.String r36) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r7 = r26
            r6 = r27
            r8 = r28
            r9 = r29
            r10 = r30
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r18 = r0
            java.lang.String r0 = "id"
            r19 = r1
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "action"
            r1 = r22
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "endAt"
            r1 = r23
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "profileId"
            r1 = r28
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "startAt"
            r1 = r31
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "type"
            r1 = r32
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "matchToMe"
            r1 = r36
            kotlin.jvm.internal.j.g(r1, r0)
            r17 = 0
            r0 = r18
            r1 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.models.entities.MatchEntity.<init>(java.lang.String, com.coffeemeetsbagel.models.enums.MatchAction, j$.time.OffsetDateTime, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Integer, j$.time.OffsetDateTime, com.coffeemeetsbagel.models.enums.MatchType, int, int, com.coffeemeetsbagel.models.enums.PurchaseAttribution, java.lang.String):void");
    }
}
