package com.coffeemeetsbagel.match.models;

import com.coffeemeetsbagel.models.enums.MatchAction;
import com.coffeemeetsbagel.models.enums.MatchType;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import j$.time.OffsetDateTime;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;

public final class Match {
    private final MatchAction action;
    private final OffsetDateTime endAt;

    /* renamed from: id  reason: collision with root package name */
    private final String f34508id;
    private final boolean isBlocked;
    private final boolean isRising;
    private final String likeComment;
    private final String matchToMe;
    private final String message;
    private final String profileId;
    private final PurchaseAttribution purchaseAttribution;
    private final int risingCount;
    private final Integer showOrder;
    private final OffsetDateTime startAt;
    private final MatchType type;
    private final int wooCount;
    private final int wooSeenCount;

    public Match(String str, MatchAction matchAction, String str2, OffsetDateTime offsetDateTime, boolean z10, boolean z11, String str3, String str4, int i10, Integer num, OffsetDateTime offsetDateTime2, MatchType matchType, int i11, int i12, PurchaseAttribution purchaseAttribution2, String str5) {
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
        this.f34508id = str;
        this.action = matchAction;
        this.likeComment = str2;
        this.endAt = offsetDateTime;
        this.isBlocked = z10;
        this.isRising = z11;
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
    }

    public static /* synthetic */ Match copy$default(Match match, String str, MatchAction matchAction, String str2, OffsetDateTime offsetDateTime, boolean z10, boolean z11, String str3, String str4, int i10, Integer num, OffsetDateTime offsetDateTime2, MatchType matchType, int i11, int i12, PurchaseAttribution purchaseAttribution2, String str5, int i13, Object obj) {
        Match match2 = match;
        int i14 = i13;
        return match.copy((i14 & 1) != 0 ? match2.f34508id : str, (i14 & 2) != 0 ? match2.action : matchAction, (i14 & 4) != 0 ? match2.likeComment : str2, (i14 & 8) != 0 ? match2.endAt : offsetDateTime, (i14 & 16) != 0 ? match2.isBlocked : z10, (i14 & 32) != 0 ? match2.isRising : z11, (i14 & 64) != 0 ? match2.message : str3, (i14 & 128) != 0 ? match2.profileId : str4, (i14 & 256) != 0 ? match2.risingCount : i10, (i14 & 512) != 0 ? match2.showOrder : num, (i14 & 1024) != 0 ? match2.startAt : offsetDateTime2, (i14 & 2048) != 0 ? match2.type : matchType, (i14 & Opcodes.ACC_SYNTHETIC) != 0 ? match2.wooCount : i11, (i14 & 8192) != 0 ? match2.wooSeenCount : i12, (i14 & Opcodes.ACC_ENUM) != 0 ? match2.purchaseAttribution : purchaseAttribution2, (i14 & 32768) != 0 ? match2.matchToMe : str5);
    }

    public final String component1() {
        return this.f34508id;
    }

    public final Integer component10() {
        return this.showOrder;
    }

    public final OffsetDateTime component11() {
        return this.startAt;
    }

    public final MatchType component12() {
        return this.type;
    }

    public final int component13() {
        return this.wooCount;
    }

    public final int component14() {
        return this.wooSeenCount;
    }

    public final PurchaseAttribution component15() {
        return this.purchaseAttribution;
    }

    public final String component16() {
        return this.matchToMe;
    }

    public final MatchAction component2() {
        return this.action;
    }

    public final String component3() {
        return this.likeComment;
    }

    public final OffsetDateTime component4() {
        return this.endAt;
    }

    public final boolean component5() {
        return this.isBlocked;
    }

    public final boolean component6() {
        return this.isRising;
    }

    public final String component7() {
        return this.message;
    }

    public final String component8() {
        return this.profileId;
    }

    public final int component9() {
        return this.risingCount;
    }

    public final Match copy(String str, MatchAction matchAction, String str2, OffsetDateTime offsetDateTime, boolean z10, boolean z11, String str3, String str4, int i10, Integer num, OffsetDateTime offsetDateTime2, MatchType matchType, int i11, int i12, PurchaseAttribution purchaseAttribution2, String str5) {
        String str6 = str;
        j.g(str6, "id");
        j.g(matchAction, "action");
        j.g(offsetDateTime, "endAt");
        j.g(str4, "profileId");
        j.g(offsetDateTime2, "startAt");
        j.g(matchType, "type");
        j.g(str5, "matchToMe");
        return new Match(str6, matchAction, str2, offsetDateTime, z10, z11, str3, str4, i10, num, offsetDateTime2, matchType, i11, i12, purchaseAttribution2, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Match)) {
            return false;
        }
        Match match = (Match) obj;
        return j.b(this.f34508id, match.f34508id) && this.action == match.action && j.b(this.likeComment, match.likeComment) && j.b(this.endAt, match.endAt) && this.isBlocked == match.isBlocked && this.isRising == match.isRising && j.b(this.message, match.message) && j.b(this.profileId, match.profileId) && this.risingCount == match.risingCount && j.b(this.showOrder, match.showOrder) && j.b(this.startAt, match.startAt) && this.type == match.type && this.wooCount == match.wooCount && this.wooSeenCount == match.wooSeenCount && this.purchaseAttribution == match.purchaseAttribution && j.b(this.matchToMe, match.matchToMe);
    }

    public final MatchAction getAction() {
        return this.action;
    }

    public final OffsetDateTime getEndAt() {
        return this.endAt;
    }

    public final String getId() {
        return this.f34508id;
    }

    public final String getLikeComment() {
        return this.likeComment;
    }

    public final String getMatchToMe() {
        return this.matchToMe;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final PurchaseAttribution getPurchaseAttribution() {
        return this.purchaseAttribution;
    }

    public final int getRisingCount() {
        return this.risingCount;
    }

    public final Integer getShowOrder() {
        return this.showOrder;
    }

    public final OffsetDateTime getStartAt() {
        return this.startAt;
    }

    public final MatchType getType() {
        return this.type;
    }

    public final int getWooCount() {
        return this.wooCount;
    }

    public final int getWooSeenCount() {
        return this.wooSeenCount;
    }

    public int hashCode() {
        int hashCode = ((this.f34508id.hashCode() * 31) + this.action.hashCode()) * 31;
        String str = this.likeComment;
        int i10 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.endAt.hashCode()) * 31;
        boolean z10 = this.isBlocked;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i11 = (hashCode2 + (z10 ? 1 : 0)) * 31;
        boolean z12 = this.isRising;
        if (!z12) {
            z11 = z12;
        }
        int i12 = (i11 + (z11 ? 1 : 0)) * 31;
        String str2 = this.message;
        int hashCode3 = (((((i12 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.profileId.hashCode()) * 31) + Integer.hashCode(this.risingCount)) * 31;
        Integer num = this.showOrder;
        int hashCode4 = (((((((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + this.startAt.hashCode()) * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.wooCount)) * 31) + Integer.hashCode(this.wooSeenCount)) * 31;
        PurchaseAttribution purchaseAttribution2 = this.purchaseAttribution;
        if (purchaseAttribution2 != null) {
            i10 = purchaseAttribution2.hashCode();
        }
        return ((hashCode4 + i10) * 31) + this.matchToMe.hashCode();
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final boolean isRising() {
        return this.isRising;
    }

    public String toString() {
        return "Match(id=" + this.f34508id + ", action=" + this.action + ", likeComment=" + this.likeComment + ", endAt=" + this.endAt + ", isBlocked=" + this.isBlocked + ", isRising=" + this.isRising + ", message=" + this.message + ", profileId=" + this.profileId + ", risingCount=" + this.risingCount + ", showOrder=" + this.showOrder + ", startAt=" + this.startAt + ", type=" + this.type + ", wooCount=" + this.wooCount + ", wooSeenCount=" + this.wooSeenCount + ", purchaseAttribution=" + this.purchaseAttribution + ", matchToMe=" + this.matchToMe + PropertyUtils.MAPPED_DELIM2;
    }
}
