package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import com.coffeemeetsbagel.models.entities.EthnicityType;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.entities.Height;
import com.coffeemeetsbagel.models.entities.ProfileEducationEntity;
import com.coffeemeetsbagel.models.entities.ReligionType;
import com.leanplum.internal.Constants;
import java.util.List;
import kotlin.jvm.internal.j;

public final class ProfileDtoImplementation implements ProfileDataContract {
    private int age;
    private String city;
    private String country;
    private ProfileEducationEntity education;
    private String employer;
    private List<? extends EthnicityType> ethnicities;
    private String firstName;
    private GenderType gender;
    private Height height;

    /* renamed from: id  reason: collision with root package name */
    private String f34710id;
    private String lastName;
    private String occupation;
    private ReligionType religion;
    private ProfileEducationEntity secondaryEducation;
    private String state;

    public ProfileDtoImplementation(String str, int i10, String str2, String str3, ProfileEducationEntity profileEducationEntity, String str4, List<? extends EthnicityType> list, String str5, GenderType genderType, Height height2, String str6, String str7, ReligionType religionType, ProfileEducationEntity profileEducationEntity2, String str8) {
        String str9 = str3;
        String str10 = str4;
        List<? extends EthnicityType> list2 = list;
        String str11 = str5;
        GenderType genderType2 = genderType;
        String str12 = str6;
        String str13 = str7;
        String str14 = str8;
        j.g(str, "id");
        j.g(str2, Constants.Keys.CITY);
        j.g(str9, "country");
        j.g(str10, ProfileConstants.Field.USER_EMPLOYER);
        j.g(list2, "ethnicities");
        j.g(str11, "firstName");
        j.g(genderType2, ProfileConstants.Field.GENDER);
        j.g(str12, "lastName");
        j.g(str13, ProfileConstants.Field.USER_OCCUPATION);
        j.g(str14, "state");
        this.f34710id = str;
        this.age = i10;
        this.city = str2;
        this.country = str9;
        this.education = profileEducationEntity;
        this.employer = str10;
        this.ethnicities = list2;
        this.firstName = str11;
        this.gender = genderType2;
        this.height = height2;
        this.lastName = str12;
        this.occupation = str13;
        this.religion = religionType;
        this.secondaryEducation = profileEducationEntity2;
        this.state = str14;
    }

    public int getAge() {
        return this.age;
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
        return this.f34710id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getOccupation() {
        return this.occupation;
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

    public void setAge(int i10) {
        this.age = i10;
    }

    public void setCity(String str) {
        j.g(str, "<set-?>");
        this.city = str;
    }

    public void setCountry(String str) {
        j.g(str, "<set-?>");
        this.country = str;
    }

    public void setEducation(ProfileEducationEntity profileEducationEntity) {
        this.education = profileEducationEntity;
    }

    public void setEmployer(String str) {
        j.g(str, "<set-?>");
        this.employer = str;
    }

    public void setEthnicities(List<? extends EthnicityType> list) {
        j.g(list, "<set-?>");
        this.ethnicities = list;
    }

    public void setFirstName(String str) {
        j.g(str, "<set-?>");
        this.firstName = str;
    }

    public void setGender(GenderType genderType) {
        j.g(genderType, "<set-?>");
        this.gender = genderType;
    }

    public void setHeight(Height height2) {
        this.height = height2;
    }

    public void setId(String str) {
        j.g(str, "<set-?>");
        this.f34710id = str;
    }

    public void setLastName(String str) {
        j.g(str, "<set-?>");
        this.lastName = str;
    }

    public void setOccupation(String str) {
        j.g(str, "<set-?>");
        this.occupation = str;
    }

    public void setReligion(ReligionType religionType) {
        this.religion = religionType;
    }

    public void setSecondaryEducation(ProfileEducationEntity profileEducationEntity) {
        this.secondaryEducation = profileEducationEntity;
    }

    public void setState(String str) {
        j.g(str, "<set-?>");
        this.state = str;
    }
}
