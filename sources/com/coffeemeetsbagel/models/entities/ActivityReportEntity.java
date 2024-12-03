package com.coffeemeetsbagel.models.entities;

import j$.time.OffsetDateTime;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ActivityReportEntity {
    private final Float avgResponseTime;
    private final Float chatInitiationLevel;
    private final OffsetDateTime expirationDate;
    private final Boolean hasLoggedInRecently;
    private final Float overallChatActivity;
    private final String profileId;

    public ActivityReportEntity(String str, Boolean bool, Float f10, Float f11, Float f12, OffsetDateTime offsetDateTime) {
        j.g(str, "profileId");
        j.g(offsetDateTime, "expirationDate");
        this.profileId = str;
        this.hasLoggedInRecently = bool;
        this.overallChatActivity = f10;
        this.chatInitiationLevel = f11;
        this.avgResponseTime = f12;
        this.expirationDate = offsetDateTime;
    }

    public static /* synthetic */ ActivityReportEntity copy$default(ActivityReportEntity activityReportEntity, String str, Boolean bool, Float f10, Float f11, Float f12, OffsetDateTime offsetDateTime, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = activityReportEntity.profileId;
        }
        if ((i10 & 2) != 0) {
            bool = activityReportEntity.hasLoggedInRecently;
        }
        Boolean bool2 = bool;
        if ((i10 & 4) != 0) {
            f10 = activityReportEntity.overallChatActivity;
        }
        Float f13 = f10;
        if ((i10 & 8) != 0) {
            f11 = activityReportEntity.chatInitiationLevel;
        }
        Float f14 = f11;
        if ((i10 & 16) != 0) {
            f12 = activityReportEntity.avgResponseTime;
        }
        Float f15 = f12;
        if ((i10 & 32) != 0) {
            offsetDateTime = activityReportEntity.expirationDate;
        }
        return activityReportEntity.copy(str, bool2, f13, f14, f15, offsetDateTime);
    }

    public final String component1() {
        return this.profileId;
    }

    public final Boolean component2() {
        return this.hasLoggedInRecently;
    }

    public final Float component3() {
        return this.overallChatActivity;
    }

    public final Float component4() {
        return this.chatInitiationLevel;
    }

    public final Float component5() {
        return this.avgResponseTime;
    }

    public final OffsetDateTime component6() {
        return this.expirationDate;
    }

    public final ActivityReportEntity copy(String str, Boolean bool, Float f10, Float f11, Float f12, OffsetDateTime offsetDateTime) {
        j.g(str, "profileId");
        j.g(offsetDateTime, "expirationDate");
        return new ActivityReportEntity(str, bool, f10, f11, f12, offsetDateTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityReportEntity)) {
            return false;
        }
        ActivityReportEntity activityReportEntity = (ActivityReportEntity) obj;
        return j.b(this.profileId, activityReportEntity.profileId) && j.b(this.hasLoggedInRecently, activityReportEntity.hasLoggedInRecently) && j.b(this.overallChatActivity, activityReportEntity.overallChatActivity) && j.b(this.chatInitiationLevel, activityReportEntity.chatInitiationLevel) && j.b(this.avgResponseTime, activityReportEntity.avgResponseTime) && j.b(this.expirationDate, activityReportEntity.expirationDate);
    }

    public final Float getAvgResponseTime() {
        return this.avgResponseTime;
    }

    public final Float getChatInitiationLevel() {
        return this.chatInitiationLevel;
    }

    public final OffsetDateTime getExpirationDate() {
        return this.expirationDate;
    }

    public final Boolean getHasLoggedInRecently() {
        return this.hasLoggedInRecently;
    }

    public final Float getOverallChatActivity() {
        return this.overallChatActivity;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public int hashCode() {
        int hashCode = this.profileId.hashCode() * 31;
        Boolean bool = this.hasLoggedInRecently;
        int i10 = 0;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Float f10 = this.overallChatActivity;
        int hashCode3 = (hashCode2 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Float f11 = this.chatInitiationLevel;
        int hashCode4 = (hashCode3 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.avgResponseTime;
        if (f12 != null) {
            i10 = f12.hashCode();
        }
        return ((hashCode4 + i10) * 31) + this.expirationDate.hashCode();
    }

    public String toString() {
        return "ActivityReportEntity(profileId=" + this.profileId + ", hasLoggedInRecently=" + this.hasLoggedInRecently + ", overallChatActivity=" + this.overallChatActivity + ", chatInitiationLevel=" + this.chatInitiationLevel + ", avgResponseTime=" + this.avgResponseTime + ", expirationDate=" + this.expirationDate + PropertyUtils.MAPPED_DELIM2;
    }
}
