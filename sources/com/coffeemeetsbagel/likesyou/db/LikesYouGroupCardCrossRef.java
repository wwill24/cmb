package com.coffeemeetsbagel.likesyou.db;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouGroupCardCrossRef {

    /* renamed from: id  reason: collision with root package name */
    private final String f34335id;
    private final String profileId;

    public LikesYouGroupCardCrossRef(String str, String str2) {
        j.g(str, "id");
        j.g(str2, "profileId");
        this.f34335id = str;
        this.profileId = str2;
    }

    public static /* synthetic */ LikesYouGroupCardCrossRef copy$default(LikesYouGroupCardCrossRef likesYouGroupCardCrossRef, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = likesYouGroupCardCrossRef.f34335id;
        }
        if ((i10 & 2) != 0) {
            str2 = likesYouGroupCardCrossRef.profileId;
        }
        return likesYouGroupCardCrossRef.copy(str, str2);
    }

    public final String component1() {
        return this.f34335id;
    }

    public final String component2() {
        return this.profileId;
    }

    public final LikesYouGroupCardCrossRef copy(String str, String str2) {
        j.g(str, "id");
        j.g(str2, "profileId");
        return new LikesYouGroupCardCrossRef(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikesYouGroupCardCrossRef)) {
            return false;
        }
        LikesYouGroupCardCrossRef likesYouGroupCardCrossRef = (LikesYouGroupCardCrossRef) obj;
        return j.b(this.f34335id, likesYouGroupCardCrossRef.f34335id) && j.b(this.profileId, likesYouGroupCardCrossRef.profileId);
    }

    public final String getId() {
        return this.f34335id;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public int hashCode() {
        return (this.f34335id.hashCode() * 31) + this.profileId.hashCode();
    }

    public String toString() {
        return "LikesYouGroupCardCrossRef(id=" + this.f34335id + ", profileId=" + this.profileId + PropertyUtils.MAPPED_DELIM2;
    }
}
