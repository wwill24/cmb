package com.coffeemeetsbagel.models;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class MultimediaInviteBody {
    private final String invitedProfile;

    public MultimediaInviteBody(String str) {
        j.g(str, "invitedProfile");
        this.invitedProfile = str;
    }

    public static /* synthetic */ MultimediaInviteBody copy$default(MultimediaInviteBody multimediaInviteBody, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multimediaInviteBody.invitedProfile;
        }
        return multimediaInviteBody.copy(str);
    }

    public final String component1() {
        return this.invitedProfile;
    }

    public final MultimediaInviteBody copy(String str) {
        j.g(str, "invitedProfile");
        return new MultimediaInviteBody(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultimediaInviteBody) && j.b(this.invitedProfile, ((MultimediaInviteBody) obj).invitedProfile);
    }

    public final String getInvitedProfile() {
        return this.invitedProfile;
    }

    public int hashCode() {
        return this.invitedProfile.hashCode();
    }

    public String toString() {
        return "MultimediaInviteBody(invitedProfile=" + this.invitedProfile + PropertyUtils.MAPPED_DELIM2;
    }
}
