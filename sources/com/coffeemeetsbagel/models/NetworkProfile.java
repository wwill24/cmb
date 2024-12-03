package com.coffeemeetsbagel.models;

import android.text.TextUtils;
import com.coffeemeetsbagel.models.enums.Ethnicity;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.coffeemeetsbagel.qna.data.network.NetworkQuestionGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lg.c;

public class NetworkProfile implements Serializable, Model {
    public static final String BISEXUAL = "b";
    private static final String BISEXUAL_ORIENTATION = "bisexual";
    public static final String FEMALE = "f";
    private static final String GAY_ORIENTATION = "gay";
    public static final String MALE = "m";
    private static final int MAX_NUM_ICEBREAKERS = 3;
    public static final String STRAIGHT_ORIENTATION = "straight";
    public static final String TAG = "ProfileNetwork";
    private ActivityReport activityReport;
    private int age;
    @c("appsflyer_id")
    private String appsFlyerId;
    private int attendanceAwardDaysForNewUser;
    private int badgeCount;
    private long beans;
    private String birthday;
    @c("boost_report_id")
    private String boostReportId;
    private String city;
    private String country;
    @c("criteria__age_from")
    private int criteriaAgeFrom;
    @c("criteria__age_to")
    private int criteriaAgeTo;
    @c("criteria__ethnicity")
    private String criteriaEthnicity;
    @c("criteria__gender")
    private String criteriaGender;
    @c("criteria__height_cm_from")
    private int criteriaHeightCentimetersFrom;
    @c("criteria__height_cm_to")
    private int criteriaHeightCentimetersTo;
    @c("criteria__height_feet_from")
    private int criteriaHeightFeetFrom;
    @c("criteria__height_feet_to")
    private int criteriaHeightFeetTo;
    @c("criteria__height_inches_from")
    private int criteriaHeightInchesFrom;
    @c("criteria__height_inches_to")
    private int criteriaHeightInchesTo;
    @c("criteria__max_distance_km")
    private int criteriaMaxDistanceKm;
    @c("criteria__max_distance_miles")
    private int criteriaMaxDistanceMiles;
    @c("criteria__religion")
    private String criteriaReligion;
    private String employer;
    private String ethnicity;
    private String gender;
    @c("has_active_boost")
    private boolean hasActiveBoost;
    @c("has_limelight")
    private boolean hasLimelight;
    @c("has_premium_preferences")
    private boolean hasPremiumPreferences;
    @c("has_prioritized_likes")
    private boolean hasPrioritizedLikes;
    private boolean hasUnlimitedBeans;
    private float heightCm;
    private int heightFeet;
    private int heightInches;
    private boolean heightUnitIsMetric;
    private ArrayList<String> icebreakers = new ArrayList<>(3);

    /* renamed from: id  reason: collision with root package name */
    private String f34709id;
    @c("is_eligible_for_free_trial")
    private boolean isEligibleForFreeTrial;
    @c("on_hold")
    private boolean isOnHold;
    @c("degree")
    private List<String> listDegrees;
    @c("education")
    private List<String> listSchools;
    private String location;
    private String matchRegionName;
    private NotificationSettings notificationSettings;
    private int numRisingBagels;
    private String occupation;
    private String personalReferralCode;
    @c("phone_number")
    private String phone;
    private List<NetworkPhoto> photos;
    @c("question_groups")
    private List<NetworkQuestionGroup> questionGroups;
    private String reactivateDate;
    private String registeredDate;
    private String religion;
    private String state;
    private String textReason;
    @c("user__email")
    private String userEmail;
    @c("user__first_name")
    private String userFirstName;
    @c("user__last_name")
    private String userLastName;
    private List<String> viewedCoachmarks;
    private String zipcode;

    public static class NotificationSettings implements Serializable {
        public boolean chatPush;
        public boolean customersPush;
        public boolean dailyPush;
        public boolean newLikesPush;
        public boolean videoPush = true;
    }

    private static boolean isListEmptyOrEntriesEmpty(List<String> list) {
        if (CollectionUtils.isEmpty((List) list)) {
            return true;
        }
        for (String isEmpty : list) {
            if (!TextUtils.isEmpty(isEmpty)) {
                return false;
            }
        }
        return true;
    }

    private boolean isMissingEthnicity() {
        return TextUtils.isEmpty(this.ethnicity);
    }

    private boolean isMissingHeight() {
        return this.heightFeet == 0 && this.heightCm == 0.0f;
    }

    private boolean isMissingIcebreakers() {
        return isListEmptyOrEntriesEmpty(this.icebreakers);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$setPhotos$0(NetworkPhoto networkPhoto, NetworkPhoto networkPhoto2) {
        return networkPhoto.getPosition() - networkPhoto2.getPosition();
    }

    public NetworkPhoto addReplacePhoto(NetworkPhoto networkPhoto) {
        if (this.photos == null) {
            this.photos = new ArrayList();
        }
        if (this.photos.size() > networkPhoto.getPosition()) {
            NetworkPhoto networkPhoto2 = this.photos.get(networkPhoto.getPosition());
            this.photos.set(networkPhoto.getPosition(), networkPhoto);
            return networkPhoto2;
        }
        this.photos.add(networkPhoto);
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f34709id, ((NetworkProfile) obj).f34709id);
    }

    public ActivityReport getActivityReport() {
        return this.activityReport;
    }

    public int getAge() {
        return this.age;
    }

    public int getAgeInteger() {
        int i10 = this.age;
        return i10 > 0 ? i10 : DateUtils.getAgeFromBirthday(this.birthday);
    }

    public String getAgeString() {
        int i10 = this.age;
        if (i10 > 0) {
            return String.valueOf(i10);
        }
        return String.valueOf(DateUtils.getAgeFromBirthday(this.birthday));
    }

    public String getAppsFlyerId() {
        return this.appsFlyerId;
    }

    public int getAttendanceAwardDaysForNewUser() {
        return this.attendanceAwardDaysForNewUser;
    }

    public int getBadgeCount() {
        return this.badgeCount;
    }

    public long getBeans() {
        return this.beans;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getBoostReportId() {
        return this.boostReportId;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public int getCriteriaAgeFrom() {
        return this.criteriaAgeFrom;
    }

    public int getCriteriaAgeTo() {
        return this.criteriaAgeTo;
    }

    public int getCriteriaDistanceKm() {
        return this.criteriaMaxDistanceKm;
    }

    public int getCriteriaDistanceMiles() {
        return this.criteriaMaxDistanceMiles;
    }

    public String getCriteriaEthnicity() {
        return this.criteriaEthnicity;
    }

    public List<String> getCriteriaEthnicityAsApiParamsList() {
        return StringUtils.splitStringByComma(this.criteriaEthnicity);
    }

    public String getCriteriaGender() {
        return this.criteriaGender;
    }

    public int getCriteriaHeightCentimetersFrom() {
        return this.criteriaHeightCentimetersFrom;
    }

    public int getCriteriaHeightCentimetersTo() {
        return this.criteriaHeightCentimetersTo;
    }

    public int getCriteriaHeightFeetFrom() {
        return this.criteriaHeightFeetFrom;
    }

    public int getCriteriaHeightFeetTo() {
        return this.criteriaHeightFeetTo;
    }

    public int getCriteriaHeightInchesFrom() {
        return this.criteriaHeightInchesFrom;
    }

    public int getCriteriaHeightInchesTo() {
        return this.criteriaHeightInchesTo;
    }

    public String getCriteriaReligion() {
        return this.criteriaReligion;
    }

    public List<String> getCriteriaReligionAsApiParamsList() {
        return StringUtils.splitStringByComma(this.criteriaReligion);
    }

    public int getDefaultMaxHeightCm() {
        if (!isGay() && this.heightCm != 0.0f && isMale()) {
            return (int) Math.min(this.heightCm + ((float) Height.convertToCentimetres(0, 2)), 272.0f);
        }
        return Height.CENTIMETRES_MAX;
    }

    public int getDefaultMinHeightCm() {
        if (!isGay() && !isMale()) {
            return (int) Math.max(this.heightCm, 122.0f);
        }
        return 122;
    }

    public String getEmployer() {
        return this.employer;
    }

    public String getEthnicity() {
        return this.ethnicity;
    }

    public List<String> getEthnicityAsApiParamsList() {
        return StringUtils.splitStringByComma(this.ethnicity);
    }

    public List<Ethnicity> getEthnicityAsList() {
        ArrayList arrayList = new ArrayList();
        for (String fromApiParam : getEthnicityAsApiParamsList()) {
            arrayList.add(Ethnicity.fromApiParam(fromApiParam));
        }
        return arrayList;
    }

    public String getGender() {
        return this.gender;
    }

    public int getHeightCm() {
        return Math.round(this.heightCm);
    }

    public int getHeightFeet() {
        return this.heightFeet;
    }

    public int getHeightInches() {
        return this.heightInches;
    }

    public ArrayList<String> getIcebreakers() {
        return this.icebreakers;
    }

    public String getId() {
        return this.f34709id;
    }

    public List<String> getListDegrees() {
        return this.listDegrees;
    }

    public List<String> getListSchools() {
        return this.listSchools;
    }

    public String getLocation() {
        return this.location;
    }

    @Deprecated
    public String getMatchRegionName() {
        return this.matchRegionName;
    }

    public NotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    public int getNumRisingBagels() {
        return this.numRisingBagels;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public String getOrientation() {
        if (isStraight()) {
            return STRAIGHT_ORIENTATION;
        }
        if (isGay()) {
            return GAY_ORIENTATION;
        }
        return BISEXUAL_ORIENTATION;
    }

    public String getPersonalReferralCode() {
        return this.personalReferralCode;
    }

    public String getPhone() {
        return this.phone;
    }

    public List<NetworkPhoto> getPhotos() {
        if (this.photos == null) {
            this.photos = new ArrayList();
        }
        return this.photos;
    }

    public NetworkPhoto getProfilePhoto() {
        if (CollectionUtils.isEmpty((List) this.photos)) {
            return null;
        }
        return this.photos.get(0);
    }

    public List<NetworkQuestionGroup> getQuestionGroups() {
        if (this.questionGroups == null) {
            this.questionGroups = new ArrayList();
        }
        return this.questionGroups;
    }

    public String getReactivateDate() {
        return this.reactivateDate;
    }

    public String getRegisteredDate() {
        return this.registeredDate;
    }

    public String getReligionApiParam() {
        return this.religion;
    }

    public String getState() {
        return this.state;
    }

    public String getTextReason() {
        return this.textReason;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserFirstName() {
        return this.userFirstName;
    }

    public String getUserLastName() {
        return this.userLastName;
    }

    public List<String> getViewedCoachmarks() {
        return this.viewedCoachmarks;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public boolean hasActiveBoost() {
        return this.hasActiveBoost;
    }

    public boolean hasLimelight() {
        return this.hasLimelight;
    }

    public boolean hasPremiumPreferences() {
        return this.hasPremiumPreferences;
    }

    public boolean hasPrioritizedLikes() {
        return this.hasPrioritizedLikes;
    }

    public boolean hasUnlimitedBeans() {
        return this.hasUnlimitedBeans;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f34709id});
    }

    public boolean isEligibleForFreeTrial() {
        return this.isEligibleForFreeTrial;
    }

    public boolean isFemale() {
        return this.gender.equals(FEMALE);
    }

    public boolean isGay() {
        return this.gender.equals(this.criteriaGender);
    }

    public boolean isHeightUnitMetric() {
        return this.heightUnitIsMetric;
    }

    public boolean isMale() {
        return this.gender.equals(MALE);
    }

    public boolean isMissingAllPhotos() {
        List<NetworkPhoto> list = this.photos;
        return list != null && list.size() == 0;
    }

    public boolean isMissingBasicInfo() {
        if (isMissingEmail() || TextUtils.isEmpty(this.birthday) || isMissingGenderInfo() || isMissingLocation() || TextUtils.isEmpty(this.userFirstName)) {
            return true;
        }
        return false;
    }

    public boolean isMissingDetailedInfo() {
        if (isMissingAllPhotos() || isMissingEthnicity() || isMissingHeight() || isMissingReligion() || isMissingEducation() || isMissingOccupation() || isMissingIcebreakers()) {
            return true;
        }
        return false;
    }

    public boolean isMissingEducation() {
        return isListEmptyOrEntriesEmpty(this.listSchools) || isListEmptyOrEntriesEmpty(this.listDegrees);
    }

    public boolean isMissingEmail() {
        return TextUtils.isEmpty(this.userEmail) || this.userEmail.endsWith("@coffeemeetsbagel.com");
    }

    /* access modifiers changed from: package-private */
    public boolean isMissingGenderInfo() {
        return TextUtils.isEmpty(this.gender) || TextUtils.isEmpty(this.criteriaGender);
    }

    public boolean isMissingLocation() {
        return TextUtils.isEmpty(this.location);
    }

    public boolean isMissingOccupation() {
        return TextUtils.isEmpty(this.occupation);
    }

    public boolean isMissingReligion() {
        return TextUtils.isEmpty(this.religion);
    }

    public boolean isOnHold() {
        return this.isOnHold;
    }

    public boolean isOver80() {
        return DateUtils.getTimeElapsed(this.birthday) > 2515968000000L;
    }

    public boolean isStraight() {
        return !this.gender.equals(this.criteriaGender) && !this.criteriaGender.equals(BISEXUAL);
    }

    public void setActivityReport(ActivityReport activityReport2) {
        this.activityReport = activityReport2;
    }

    public void setAge(int i10) {
        this.age = i10;
    }

    public void setAppsFlyerId(String str) {
        this.appsFlyerId = str;
    }

    public void setAttendanceAwardDaysForNewUser(int i10) {
        this.attendanceAwardDaysForNewUser = i10;
    }

    public void setBadgeCount(int i10) {
        this.badgeCount = i10;
    }

    public void setBeans(long j10) {
        this.beans = j10;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setBoostReportId(String str) {
        this.boostReportId = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCriteriaAgeFrom(int i10) {
        this.criteriaAgeFrom = i10;
    }

    public void setCriteriaAgeTo(int i10) {
        this.criteriaAgeTo = i10;
    }

    public void setCriteriaDistanceKm(int i10) {
        this.criteriaMaxDistanceKm = i10;
    }

    public void setCriteriaDistanceMiles(int i10) {
        this.criteriaMaxDistanceMiles = i10;
    }

    public void setCriteriaEthnicity(String str) {
        this.criteriaEthnicity = str;
    }

    public void setCriteriaGender(String str) {
        this.criteriaGender = str;
    }

    public void setCriteriaHeightCentimetersFrom(int i10) {
        this.criteriaHeightCentimetersFrom = i10;
    }

    public void setCriteriaHeightCentimetersTo(int i10) {
        this.criteriaHeightCentimetersTo = i10;
    }

    public void setCriteriaHeightFeetFrom(int i10) {
        this.criteriaHeightFeetFrom = i10;
    }

    public void setCriteriaHeightFeetTo(int i10) {
        this.criteriaHeightFeetTo = i10;
    }

    public void setCriteriaHeightFrom(Height height) {
        this.criteriaHeightInchesFrom = height.getHeightInches();
        this.criteriaHeightFeetFrom = height.getHeightFeet();
        this.criteriaHeightCentimetersFrom = height.getHeightCentimetres();
    }

    public void setCriteriaHeightInchesFrom(int i10) {
        this.criteriaHeightInchesFrom = i10;
    }

    public void setCriteriaHeightInchesTo(int i10) {
        this.criteriaHeightInchesTo = i10;
    }

    public void setCriteriaHeightTo(Height height) {
        this.criteriaHeightInchesTo = height.getHeightInches();
        this.criteriaHeightFeetTo = height.getHeightFeet();
        this.criteriaHeightCentimetersTo = height.getHeightCentimetres();
    }

    public void setCriteriaReligion(String str) {
        this.criteriaReligion = str;
    }

    public void setDegrees(String str, String str2) {
        List<String> list = this.listDegrees;
        if (list == null) {
            this.listDegrees = new ArrayList();
        } else {
            list.clear();
        }
        this.listDegrees.add(str);
        this.listDegrees.add(str2);
    }

    public void setEducation(String str, String str2) {
        List<String> list = this.listSchools;
        if (list == null) {
            this.listSchools = new ArrayList();
        } else {
            list.clear();
        }
        this.listSchools.add(str);
        this.listSchools.add(str2);
    }

    public void setEligibleForFreeTrial(boolean z10) {
        this.isEligibleForFreeTrial = z10;
    }

    public void setEmployer(String str) {
        this.employer = str;
    }

    public void setEthnicity(String str) {
        this.ethnicity = str;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setHasActiveBoost(boolean z10) {
        this.hasActiveBoost = z10;
    }

    public void setHasLimelight(boolean z10) {
        this.hasLimelight = z10;
    }

    public void setHasPremiumPreferences(boolean z10) {
        this.hasPremiumPreferences = z10;
    }

    public void setHasPrioritizedLikes(boolean z10) {
        this.hasPrioritizedLikes = z10;
    }

    public void setHasUnlimitedBeans(boolean z10) {
        this.hasUnlimitedBeans = z10;
    }

    public void setHeight(Height height) {
        this.heightInches = height.getHeightInches();
        this.heightFeet = height.getHeightFeet();
        this.heightCm = (float) height.getHeightCentimetres();
    }

    public void setHeightCm(float f10) {
        this.heightCm = f10;
    }

    public void setHeightFeet(int i10) {
        this.heightFeet = i10;
    }

    public void setHeightInches(int i10) {
        this.heightInches = i10;
    }

    public void setHeightUnitIsMetric(boolean z10) {
        this.heightUnitIsMetric = z10;
    }

    public void setIcebreakers(ArrayList<String> arrayList) {
        this.icebreakers = arrayList;
    }

    public void setId(String str) {
        this.f34709id = str;
    }

    public void setListDegrees(List<String> list) {
        this.listDegrees = list;
    }

    public void setListSchools(List<String> list) {
        this.listSchools = list;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setMatchRegionName(String str) {
        this.matchRegionName = str;
    }

    public void setNotificationSettings(NotificationSettings notificationSettings2) {
        this.notificationSettings = notificationSettings2;
    }

    public void setNumRisingBagels(int i10) {
        this.numRisingBagels = i10;
    }

    public void setOccupation(String str) {
        this.occupation = str;
    }

    public void setOnHold(boolean z10) {
        this.isOnHold = z10;
    }

    public void setOnHoldReasonManual(String str) {
        this.textReason = str;
    }

    public void setPeronalReferralCode(String str) {
        this.personalReferralCode = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPhotos(List<NetworkPhoto> list) {
        this.photos = list;
        if (list != null) {
            Collections.sort(list, new a());
        }
    }

    public void setReactivateDate(String str) {
        this.reactivateDate = str;
    }

    public void setRegisteredDate(String str) {
        this.registeredDate = str;
    }

    public void setReligion(String str) {
        this.religion = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setTextReason(String str) {
        this.textReason = str;
    }

    public void setUserEmail(String str) {
        this.userEmail = str;
    }

    public void setUserFirstName(String str) {
        this.userFirstName = str;
    }

    public void setUserLastName(String str) {
        this.userLastName = str;
    }

    public void setViewedCoachmarks(List<String> list) {
        this.viewedCoachmarks = list;
    }

    public void setZipcode(String str) {
        this.zipcode = str;
    }

    public String toString() {
        return getUserFirstName();
    }

    public void setIcebreakers(String str, String str2, String str3) {
        this.icebreakers.clear();
        this.icebreakers.add(str);
        this.icebreakers.add(str2);
        this.icebreakers.add(str3);
    }
}
