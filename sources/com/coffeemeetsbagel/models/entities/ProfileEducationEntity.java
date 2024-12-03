package com.coffeemeetsbagel.models.entities;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ProfileEducationEntity {
    private final String degreeId;
    private final String school;

    public ProfileEducationEntity(String str, String str2) {
        j.g(str, "school");
        j.g(str2, "degreeId");
        this.school = str;
        this.degreeId = str2;
    }

    public static /* synthetic */ ProfileEducationEntity copy$default(ProfileEducationEntity profileEducationEntity, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = profileEducationEntity.school;
        }
        if ((i10 & 2) != 0) {
            str2 = profileEducationEntity.degreeId;
        }
        return profileEducationEntity.copy(str, str2);
    }

    public final String component1() {
        return this.school;
    }

    public final String component2() {
        return this.degreeId;
    }

    public final ProfileEducationEntity copy(String str, String str2) {
        j.g(str, "school");
        j.g(str2, "degreeId");
        return new ProfileEducationEntity(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileEducationEntity)) {
            return false;
        }
        ProfileEducationEntity profileEducationEntity = (ProfileEducationEntity) obj;
        return j.b(this.school, profileEducationEntity.school) && j.b(this.degreeId, profileEducationEntity.degreeId);
    }

    public final String getDegreeId() {
        return this.degreeId;
    }

    public final String getSchool() {
        return this.school;
    }

    public int hashCode() {
        return (this.school.hashCode() * 31) + this.degreeId.hashCode();
    }

    public String toString() {
        return "ProfileEducationEntity(school=" + this.school + ", degreeId=" + this.degreeId + PropertyUtils.MAPPED_DELIM2;
    }
}
