package com.coffeemeetsbagel.models.responses;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class ResponseBoostReport {

    /* renamed from: id  reason: collision with root package name */
    private final String f34732id;
    @c("liked_count")
    private final int likedCount;
    @c("profile_id")
    private final String profileId;
    @c("seen_percent")
    private final int seenPercent;

    public ResponseBoostReport(String str, String str2, int i10, int i11) {
        j.g(str, "id");
        j.g(str2, "profileId");
        this.f34732id = str;
        this.profileId = str2;
        this.seenPercent = i10;
        this.likedCount = i11;
    }

    public static /* synthetic */ ResponseBoostReport copy$default(ResponseBoostReport responseBoostReport, String str, String str2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = responseBoostReport.f34732id;
        }
        if ((i12 & 2) != 0) {
            str2 = responseBoostReport.profileId;
        }
        if ((i12 & 4) != 0) {
            i10 = responseBoostReport.seenPercent;
        }
        if ((i12 & 8) != 0) {
            i11 = responseBoostReport.likedCount;
        }
        return responseBoostReport.copy(str, str2, i10, i11);
    }

    public final String component1() {
        return this.f34732id;
    }

    public final String component2() {
        return this.profileId;
    }

    public final int component3() {
        return this.seenPercent;
    }

    public final int component4() {
        return this.likedCount;
    }

    public final ResponseBoostReport copy(String str, String str2, int i10, int i11) {
        j.g(str, "id");
        j.g(str2, "profileId");
        return new ResponseBoostReport(str, str2, i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseBoostReport)) {
            return false;
        }
        ResponseBoostReport responseBoostReport = (ResponseBoostReport) obj;
        return j.b(this.f34732id, responseBoostReport.f34732id) && j.b(this.profileId, responseBoostReport.profileId) && this.seenPercent == responseBoostReport.seenPercent && this.likedCount == responseBoostReport.likedCount;
    }

    public final String getId() {
        return this.f34732id;
    }

    public final int getLikedCount() {
        return this.likedCount;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final int getSeenPercent() {
        return this.seenPercent;
    }

    public int hashCode() {
        return (((((this.f34732id.hashCode() * 31) + this.profileId.hashCode()) * 31) + Integer.hashCode(this.seenPercent)) * 31) + Integer.hashCode(this.likedCount);
    }

    public String toString() {
        return "ResponseBoostReport(id=" + this.f34732id + ", profileId=" + this.profileId + ", seenPercent=" + this.seenPercent + ", likedCount=" + this.likedCount + PropertyUtils.MAPPED_DELIM2;
    }
}
