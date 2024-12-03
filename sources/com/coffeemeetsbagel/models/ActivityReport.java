package com.coffeemeetsbagel.models;

import java.io.Serializable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ActivityReport implements Serializable, Model {
    private final Float avgResponseTime;
    private final Float chatInitiationLevel;
    private final String expirationDate;
    private final Boolean hasLoggedInRecently;
    private final Float overallChatActivity;
    private final String profileId;

    public ActivityReport(String str, Boolean bool, Float f10, Float f11, Float f12, String str2) {
        j.g(str, "profileId");
        this.profileId = str;
        this.hasLoggedInRecently = bool;
        this.overallChatActivity = f10;
        this.chatInitiationLevel = f11;
        this.avgResponseTime = f12;
        this.expirationDate = str2;
    }

    public static /* synthetic */ ActivityReport copy$default(ActivityReport activityReport, String str, Boolean bool, Float f10, Float f11, Float f12, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = activityReport.profileId;
        }
        if ((i10 & 2) != 0) {
            bool = activityReport.hasLoggedInRecently;
        }
        Boolean bool2 = bool;
        if ((i10 & 4) != 0) {
            f10 = activityReport.overallChatActivity;
        }
        Float f13 = f10;
        if ((i10 & 8) != 0) {
            f11 = activityReport.chatInitiationLevel;
        }
        Float f14 = f11;
        if ((i10 & 16) != 0) {
            f12 = activityReport.avgResponseTime;
        }
        Float f15 = f12;
        if ((i10 & 32) != 0) {
            str2 = activityReport.expirationDate;
        }
        return activityReport.copy(str, bool2, f13, f14, f15, str2);
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

    public final String component6() {
        return this.expirationDate;
    }

    public final ActivityReport copy(String str, Boolean bool, Float f10, Float f11, Float f12, String str2) {
        j.g(str, "profileId");
        return new ActivityReport(str, bool, f10, f11, f12, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityReport)) {
            return false;
        }
        ActivityReport activityReport = (ActivityReport) obj;
        return j.b(this.profileId, activityReport.profileId) && j.b(this.hasLoggedInRecently, activityReport.hasLoggedInRecently) && j.b(this.overallChatActivity, activityReport.overallChatActivity) && j.b(this.chatInitiationLevel, activityReport.chatInitiationLevel) && j.b(this.avgResponseTime, activityReport.avgResponseTime) && j.b(this.expirationDate, activityReport.expirationDate);
    }

    public final Float getAvgResponseTime() {
        return this.avgResponseTime;
    }

    public final Float getChatInitiationLevel() {
        return this.chatInitiationLevel;
    }

    public final String getExpirationDate() {
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
        int hashCode5 = (hashCode4 + (f12 == null ? 0 : f12.hashCode())) * 31;
        String str = this.expirationDate;
        if (str != null) {
            i10 = str.hashCode();
        }
        return hashCode5 + i10;
    }

    public String toString() {
        return "ActivityReport(profileId=" + this.profileId + ", hasLoggedInRecently=" + this.hasLoggedInRecently + ", overallChatActivity=" + this.overallChatActivity + ", chatInitiationLevel=" + this.chatInitiationLevel + ", avgResponseTime=" + this.avgResponseTime + ", expirationDate=" + this.expirationDate + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ActivityReport(java.lang.String r7, java.lang.Boolean r8, java.lang.Float r9, java.lang.Float r10, java.lang.Float r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r6 = this;
            r0 = r13 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r8
        L_0x0008:
            r2 = r13 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r9
        L_0x000f:
            r3 = r13 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r10
        L_0x0016:
            r4 = r13 & 16
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r11
        L_0x001d:
            r5 = r13 & 32
            if (r5 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r12
        L_0x0023:
            r8 = r6
            r9 = r7
            r10 = r0
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.models.ActivityReport.<init>(java.lang.String, java.lang.Boolean, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
