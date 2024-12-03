package com.coffeemeetsbagel.likesyou.db;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouGroupPaywallCardCrossRef {

    /* renamed from: id  reason: collision with root package name */
    private final String f34336id;
    private final String profileId;

    public LikesYouGroupPaywallCardCrossRef(String str, String str2) {
        j.g(str, "id");
        j.g(str2, "profileId");
        this.f34336id = str;
        this.profileId = str2;
    }

    public static /* synthetic */ LikesYouGroupPaywallCardCrossRef copy$default(LikesYouGroupPaywallCardCrossRef likesYouGroupPaywallCardCrossRef, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = likesYouGroupPaywallCardCrossRef.f34336id;
        }
        if ((i10 & 2) != 0) {
            str2 = likesYouGroupPaywallCardCrossRef.profileId;
        }
        return likesYouGroupPaywallCardCrossRef.copy(str, str2);
    }

    public final String component1() {
        return this.f34336id;
    }

    public final String component2() {
        return this.profileId;
    }

    public final LikesYouGroupPaywallCardCrossRef copy(String str, String str2) {
        j.g(str, "id");
        j.g(str2, "profileId");
        return new LikesYouGroupPaywallCardCrossRef(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikesYouGroupPaywallCardCrossRef)) {
            return false;
        }
        LikesYouGroupPaywallCardCrossRef likesYouGroupPaywallCardCrossRef = (LikesYouGroupPaywallCardCrossRef) obj;
        return j.b(this.f34336id, likesYouGroupPaywallCardCrossRef.f34336id) && j.b(this.profileId, likesYouGroupPaywallCardCrossRef.profileId);
    }

    public final String getId() {
        return this.f34336id;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public int hashCode() {
        return (this.f34336id.hashCode() * 31) + this.profileId.hashCode();
    }

    public String toString() {
        return "LikesYouGroupPaywallCardCrossRef(id=" + this.f34336id + ", profileId=" + this.profileId + PropertyUtils.MAPPED_DELIM2;
    }
}
