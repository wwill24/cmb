package com.coffeemeetsbagel.likesyou;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class FetchError {
    private final String problem;
    @c("profile_id")
    private final String profileId;

    public FetchError(String str, String str2) {
        j.g(str, "profileId");
        j.g(str2, "problem");
        this.profileId = str;
        this.problem = str2;
    }

    public static /* synthetic */ FetchError copy$default(FetchError fetchError, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fetchError.profileId;
        }
        if ((i10 & 2) != 0) {
            str2 = fetchError.problem;
        }
        return fetchError.copy(str, str2);
    }

    public final String component1() {
        return this.profileId;
    }

    public final String component2() {
        return this.problem;
    }

    public final FetchError copy(String str, String str2) {
        j.g(str, "profileId");
        j.g(str2, "problem");
        return new FetchError(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FetchError)) {
            return false;
        }
        FetchError fetchError = (FetchError) obj;
        return j.b(this.profileId, fetchError.profileId) && j.b(this.problem, fetchError.problem);
    }

    public final String getProblem() {
        return this.problem;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public int hashCode() {
        return (this.profileId.hashCode() * 31) + this.problem.hashCode();
    }

    public String toString() {
        return "FetchError(profileId=" + this.profileId + ", problem=" + this.problem + PropertyUtils.MAPPED_DELIM2;
    }
}
