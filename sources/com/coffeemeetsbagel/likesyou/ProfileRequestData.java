package com.coffeemeetsbagel.likesyou;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class ProfileRequestData {

    /* renamed from: id  reason: collision with root package name */
    private final String f34334id;
    @c("last_updated")
    private final String lastUpdated;

    public ProfileRequestData(String str, String str2) {
        j.g(str, "id");
        this.f34334id = str;
        this.lastUpdated = str2;
    }

    public static /* synthetic */ ProfileRequestData copy$default(ProfileRequestData profileRequestData, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = profileRequestData.f34334id;
        }
        if ((i10 & 2) != 0) {
            str2 = profileRequestData.lastUpdated;
        }
        return profileRequestData.copy(str, str2);
    }

    public final String component1() {
        return this.f34334id;
    }

    public final String component2() {
        return this.lastUpdated;
    }

    public final ProfileRequestData copy(String str, String str2) {
        j.g(str, "id");
        return new ProfileRequestData(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileRequestData)) {
            return false;
        }
        ProfileRequestData profileRequestData = (ProfileRequestData) obj;
        return j.b(this.f34334id, profileRequestData.f34334id) && j.b(this.lastUpdated, profileRequestData.lastUpdated);
    }

    public final String getId() {
        return this.f34334id;
    }

    public final String getLastUpdated() {
        return this.lastUpdated;
    }

    public int hashCode() {
        int hashCode = this.f34334id.hashCode() * 31;
        String str = this.lastUpdated;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ProfileRequestData(id=" + this.f34334id + ", lastUpdated=" + this.lastUpdated + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProfileRequestData(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : str2);
    }
}
