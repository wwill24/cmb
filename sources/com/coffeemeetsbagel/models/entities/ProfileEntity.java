package com.coffeemeetsbagel.models.entities;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import com.leanplum.internal.Constants;
import java.util.List;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;
import za.b;

public final class ProfileEntity implements ProfileDataContract {
    private final int age;
    private final List<b> answers;
    private final String city;
    private final String country;
    private final ProfileEducationEntity education;
    private final String employer;
    private final List<EthnicityType> ethnicities;
    private final String firstName;
    private final GenderType gender;
    private final Height height;

    /* renamed from: id  reason: collision with root package name */
    private final String f34724id;
    private final String lastName;
    private final String occupation;
    private final List<PhotoEntity> photos;
    private final ReligionType religion;
    private final ProfileEducationEntity secondaryEducation;
    private final String state;

    public ProfileEntity(String str, int i10, String str2, String str3, ProfileEducationEntity profileEducationEntity, String str4, List<? extends EthnicityType> list, String str5, GenderType genderType, Height height2, String str6, String str7, ReligionType religionType, ProfileEducationEntity profileEducationEntity2, String str8, List<PhotoEntity> list2, List<b> list3) {
        String str9 = str2;
        String str10 = str3;
        String str11 = str4;
        List<? extends EthnicityType> list4 = list;
        String str12 = str5;
        GenderType genderType2 = genderType;
        String str13 = str6;
        String str14 = str7;
        String str15 = str8;
        List<PhotoEntity> list5 = list2;
        List<b> list6 = list3;
        j.g(str, "id");
        j.g(str9, Constants.Keys.CITY);
        j.g(str10, "country");
        j.g(str11, ProfileConstants.Field.USER_EMPLOYER);
        j.g(list4, "ethnicities");
        j.g(str12, "firstName");
        j.g(genderType2, ProfileConstants.Field.GENDER);
        j.g(str13, "lastName");
        j.g(str14, ProfileConstants.Field.USER_OCCUPATION);
        j.g(str15, "state");
        j.g(list5, "photos");
        j.g(list6, "answers");
        this.f34724id = str;
        this.age = i10;
        this.city = str9;
        this.country = str10;
        this.education = profileEducationEntity;
        this.employer = str11;
        this.ethnicities = list4;
        this.firstName = str12;
        this.gender = genderType2;
        this.height = height2;
        this.lastName = str13;
        this.occupation = str14;
        this.religion = religionType;
        this.secondaryEducation = profileEducationEntity2;
        this.state = str15;
        this.photos = list5;
        this.answers = list6;
    }

    public static /* synthetic */ ProfileEntity copy$default(ProfileEntity profileEntity, String str, int i10, String str2, String str3, ProfileEducationEntity profileEducationEntity, String str4, List list, String str5, GenderType genderType, Height height2, String str6, String str7, ReligionType religionType, ProfileEducationEntity profileEducationEntity2, String str8, List list2, List list3, int i11, Object obj) {
        ProfileEntity profileEntity2 = profileEntity;
        int i12 = i11;
        return profileEntity.copy((i12 & 1) != 0 ? profileEntity.getId() : str, (i12 & 2) != 0 ? profileEntity.getAge() : i10, (i12 & 4) != 0 ? profileEntity.getCity() : str2, (i12 & 8) != 0 ? profileEntity.getCountry() : str3, (i12 & 16) != 0 ? profileEntity.getEducation() : profileEducationEntity, (i12 & 32) != 0 ? profileEntity.getEmployer() : str4, (i12 & 64) != 0 ? profileEntity.getEthnicities() : list, (i12 & 128) != 0 ? profileEntity.getFirstName() : str5, (i12 & 256) != 0 ? profileEntity.getGender() : genderType, (i12 & 512) != 0 ? profileEntity.getHeight() : height2, (i12 & 1024) != 0 ? profileEntity.getLastName() : str6, (i12 & 2048) != 0 ? profileEntity.getOccupation() : str7, (i12 & Opcodes.ACC_SYNTHETIC) != 0 ? profileEntity.getReligion() : religionType, (i12 & 8192) != 0 ? profileEntity.getSecondaryEducation() : profileEducationEntity2, (i12 & Opcodes.ACC_ENUM) != 0 ? profileEntity.getState() : str8, (i12 & 32768) != 0 ? profileEntity2.photos : list2, (i12 & 65536) != 0 ? profileEntity2.answers : list3);
    }

    public final String component1() {
        return getId();
    }

    public final Height component10() {
        return getHeight();
    }

    public final String component11() {
        return getLastName();
    }

    public final String component12() {
        return getOccupation();
    }

    public final ReligionType component13() {
        return getReligion();
    }

    public final ProfileEducationEntity component14() {
        return getSecondaryEducation();
    }

    public final String component15() {
        return getState();
    }

    public final List<PhotoEntity> component16() {
        return this.photos;
    }

    public final List<b> component17() {
        return this.answers;
    }

    public final int component2() {
        return getAge();
    }

    public final String component3() {
        return getCity();
    }

    public final String component4() {
        return getCountry();
    }

    public final ProfileEducationEntity component5() {
        return getEducation();
    }

    public final String component6() {
        return getEmployer();
    }

    public final List<EthnicityType> component7() {
        return getEthnicities();
    }

    public final String component8() {
        return getFirstName();
    }

    public final GenderType component9() {
        return getGender();
    }

    public final ProfileEntity copy(String str, int i10, String str2, String str3, ProfileEducationEntity profileEducationEntity, String str4, List<? extends EthnicityType> list, String str5, GenderType genderType, Height height2, String str6, String str7, ReligionType religionType, ProfileEducationEntity profileEducationEntity2, String str8, List<PhotoEntity> list2, List<b> list3) {
        String str9 = str;
        j.g(str9, "id");
        j.g(str2, Constants.Keys.CITY);
        j.g(str3, "country");
        j.g(str4, ProfileConstants.Field.USER_EMPLOYER);
        j.g(list, "ethnicities");
        j.g(str5, "firstName");
        j.g(genderType, ProfileConstants.Field.GENDER);
        j.g(str6, "lastName");
        j.g(str7, ProfileConstants.Field.USER_OCCUPATION);
        j.g(str8, "state");
        j.g(list2, "photos");
        j.g(list3, "answers");
        return new ProfileEntity(str9, i10, str2, str3, profileEducationEntity, str4, list, str5, genderType, height2, str6, str7, religionType, profileEducationEntity2, str8, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileEntity)) {
            return false;
        }
        ProfileEntity profileEntity = (ProfileEntity) obj;
        return j.b(getId(), profileEntity.getId()) && getAge() == profileEntity.getAge() && j.b(getCity(), profileEntity.getCity()) && j.b(getCountry(), profileEntity.getCountry()) && j.b(getEducation(), profileEntity.getEducation()) && j.b(getEmployer(), profileEntity.getEmployer()) && j.b(getEthnicities(), profileEntity.getEthnicities()) && j.b(getFirstName(), profileEntity.getFirstName()) && getGender() == profileEntity.getGender() && j.b(getHeight(), profileEntity.getHeight()) && j.b(getLastName(), profileEntity.getLastName()) && j.b(getOccupation(), profileEntity.getOccupation()) && getReligion() == profileEntity.getReligion() && j.b(getSecondaryEducation(), profileEntity.getSecondaryEducation()) && j.b(getState(), profileEntity.getState()) && j.b(this.photos, profileEntity.photos) && j.b(this.answers, profileEntity.answers);
    }

    public int getAge() {
        return this.age;
    }

    public final List<b> getAnswers() {
        return this.answers;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public ProfileEducationEntity getEducation() {
        return this.education;
    }

    public String getEmployer() {
        return this.employer;
    }

    public List<EthnicityType> getEthnicities() {
        return this.ethnicities;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public GenderType getGender() {
        return this.gender;
    }

    public Height getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f34724id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public final List<PhotoEntity> getPhotos() {
        return this.photos;
    }

    public ReligionType getReligion() {
        return this.religion;
    }

    public ProfileEducationEntity getSecondaryEducation() {
        return this.secondaryEducation;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        int i10 = 0;
        int hashCode = ((((((((((((((((((((((((getId().hashCode() * 31) + Integer.hashCode(getAge())) * 31) + getCity().hashCode()) * 31) + getCountry().hashCode()) * 31) + (getEducation() == null ? 0 : getEducation().hashCode())) * 31) + getEmployer().hashCode()) * 31) + getEthnicities().hashCode()) * 31) + getFirstName().hashCode()) * 31) + getGender().hashCode()) * 31) + (getHeight() == null ? 0 : getHeight().hashCode())) * 31) + getLastName().hashCode()) * 31) + getOccupation().hashCode()) * 31) + (getReligion() == null ? 0 : getReligion().hashCode())) * 31;
        if (getSecondaryEducation() != null) {
            i10 = getSecondaryEducation().hashCode();
        }
        return ((((((hashCode + i10) * 31) + getState().hashCode()) * 31) + this.photos.hashCode()) * 31) + this.answers.hashCode();
    }

    public String toString() {
        return "ProfileEntity(id=" + getId() + ", age=" + getAge() + ", city=" + getCity() + ", country=" + getCountry() + ", education=" + getEducation() + ", employer=" + getEmployer() + ", ethnicities=" + getEthnicities() + ", firstName=" + getFirstName() + ", gender=" + getGender() + ", height=" + getHeight() + ", lastName=" + getLastName() + ", occupation=" + getOccupation() + ", religion=" + getReligion() + ", secondaryEducation=" + getSecondaryEducation() + ", state=" + getState() + ", photos=" + this.photos + ", answers=" + this.answers + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ProfileEntity(java.lang.String r22, int r23, java.lang.String r24, java.lang.String r25, com.coffeemeetsbagel.models.entities.ProfileEducationEntity r26, java.lang.String r27, java.util.List r28, java.lang.String r29, com.coffeemeetsbagel.models.entities.GenderType r30, com.coffeemeetsbagel.models.entities.Height r31, java.lang.String r32, java.lang.String r33, com.coffeemeetsbagel.models.entities.ReligionType r34, com.coffeemeetsbagel.models.entities.ProfileEducationEntity r35, java.lang.String r36, java.util.List r37, java.util.List r38, int r39, kotlin.jvm.internal.DefaultConstructorMarker r40) {
        /*
            r21 = this;
            r0 = r39
            r1 = r0 & 4
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r6 = r2
            goto L_0x000c
        L_0x000a:
            r6 = r24
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0012
            r7 = r2
            goto L_0x0014
        L_0x0012:
            r7 = r25
        L_0x0014:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001a
            r9 = r2
            goto L_0x001c
        L_0x001a:
            r9 = r27
        L_0x001c:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0022
            r11 = r2
            goto L_0x0024
        L_0x0022:
            r11 = r29
        L_0x0024:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x002a
            r14 = r2
            goto L_0x002c
        L_0x002a:
            r14 = r32
        L_0x002c:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0032
            r15 = r2
            goto L_0x0034
        L_0x0032:
            r15 = r33
        L_0x0034:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x003b
            r18 = r2
            goto L_0x003d
        L_0x003b:
            r18 = r36
        L_0x003d:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x004a
            java.util.List r1 = kotlin.collections.q.j()
            r19 = r1
            goto L_0x004c
        L_0x004a:
            r19 = r37
        L_0x004c:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0058
            java.util.List r0 = kotlin.collections.q.j()
            r20 = r0
            goto L_0x005a
        L_0x0058:
            r20 = r38
        L_0x005a:
            r3 = r21
            r4 = r22
            r5 = r23
            r8 = r26
            r10 = r28
            r12 = r30
            r13 = r31
            r16 = r34
            r17 = r35
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.models.entities.ProfileEntity.<init>(java.lang.String, int, java.lang.String, java.lang.String, com.coffeemeetsbagel.models.entities.ProfileEducationEntity, java.lang.String, java.util.List, java.lang.String, com.coffeemeetsbagel.models.entities.GenderType, com.coffeemeetsbagel.models.entities.Height, java.lang.String, java.lang.String, com.coffeemeetsbagel.models.entities.ReligionType, com.coffeemeetsbagel.models.entities.ProfileEducationEntity, java.lang.String, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProfileEntity(java.lang.String r21, int r22, java.lang.String r23, java.lang.String r24, com.coffeemeetsbagel.models.entities.ProfileEducationEntity r25, java.lang.String r26, java.util.List<? extends com.coffeemeetsbagel.models.entities.EthnicityType> r27, java.lang.String r28, com.coffeemeetsbagel.models.entities.GenderType r29, com.coffeemeetsbagel.models.entities.Height r30, java.lang.String r31, java.lang.String r32, com.coffeemeetsbagel.models.entities.ReligionType r33, com.coffeemeetsbagel.models.entities.ProfileEducationEntity r34, java.lang.String r35) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r10 = r30
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r18 = r0
            java.lang.String r0 = "id"
            r19 = r1
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "city"
            r1 = r23
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "country"
            r1 = r24
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "employer"
            r1 = r26
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "ethnicities"
            r1 = r27
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "firstName"
            r1 = r28
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "gender"
            r1 = r29
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "lastName"
            r1 = r31
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "occupation"
            r1 = r32
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "state"
            r1 = r35
            kotlin.jvm.internal.j.g(r1, r0)
            java.util.List r16 = kotlin.collections.q.j()
            java.util.List r17 = kotlin.collections.q.j()
            r0 = r18
            r1 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.models.entities.ProfileEntity.<init>(java.lang.String, int, java.lang.String, java.lang.String, com.coffeemeetsbagel.models.entities.ProfileEducationEntity, java.lang.String, java.util.List, java.lang.String, com.coffeemeetsbagel.models.entities.GenderType, com.coffeemeetsbagel.models.entities.Height, java.lang.String, java.lang.String, com.coffeemeetsbagel.models.entities.ReligionType, com.coffeemeetsbagel.models.entities.ProfileEducationEntity, java.lang.String):void");
    }
}
