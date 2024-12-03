package com.coffeemeetsbagel.models;

import android.text.TextUtils;
import androidx.core.util.d;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.enums.Reason;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class ModelProfileUpdateDelta {
    private Map<String, Object> mFieldStrings = new HashMap();

    private static a joinAsJsonArray(String str, boolean z10, String... strArr) {
        a aVar = new a();
        if (str != null) {
            aVar.E(str);
        }
        for (String str2 : strArr) {
            if (str2 != null) {
                if (!TextUtils.isEmpty(str2)) {
                    aVar.E(str2);
                } else if (z10 && TextUtils.isEmpty(str2)) {
                    aVar.E(str2);
                }
            }
        }
        return aVar;
    }

    private void updatePushEnabled(String str, boolean z10) {
        if (!this.mFieldStrings.containsKey(ProfileConstants.Field.NOTIFICATION_SETTINGS)) {
            this.mFieldStrings.put(ProfileConstants.Field.NOTIFICATION_SETTINGS, new b());
        }
        try {
            ((b) this.mFieldStrings.get(ProfileConstants.Field.NOTIFICATION_SETTINGS)).put(str, z10);
        } catch (JSONException e10) {
            fa.a.i(e10);
        }
    }

    public void addOnboardingQuestion(DynamicMultipleChoiceQuestion dynamicMultipleChoiceQuestion) {
        a aVar = (a) this.mFieldStrings.get(ProfileConstants.Field.ONBOARDING_QUESTIONS);
        if (aVar == null) {
            aVar = new a();
        }
        b bVar = new b();
        try {
            bVar.put(ProfileConstants.OnboardingQuestions.QUESTION_NAME, (Object) dynamicMultipleChoiceQuestion.getQuestionName());
            bVar.put(ProfileConstants.OnboardingQuestions.QUESTION_TEXT, (Object) dynamicMultipleChoiceQuestion.getQuestionText());
            bVar.put(ProfileConstants.OnboardingQuestions.ANSWER_NAME, (Object) dynamicMultipleChoiceQuestion.getAnswerName());
            bVar.put(ProfileConstants.OnboardingQuestions.ANSWER_TEXT, (Object) dynamicMultipleChoiceQuestion.getAnswerText());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        aVar.E(bVar);
        this.mFieldStrings.put(ProfileConstants.Field.ONBOARDING_QUESTIONS, aVar);
    }

    public void clearBadgeCount() {
        this.mFieldStrings.put(ProfileConstants.Field.BADGE_COUNT, 0);
    }

    public String flush() {
        b bVar = new b();
        try {
            Map<String, Object> map = this.mFieldStrings;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry next : this.mFieldStrings.entrySet()) {
                    if (next.getValue() == null) {
                        bVar.put((String) next.getKey(), b.NULL);
                    } else {
                        bVar.put((String) next.getKey(), next.getValue());
                    }
                }
                this.mFieldStrings.clear();
            }
        } catch (Exception e10) {
            fa.a.i(e10);
        }
        return bVar.toString();
    }

    public boolean hasAtLeastOneFieldExcept(String str) {
        if (this.mFieldStrings.size() >= 2) {
            return true;
        }
        if (this.mFieldStrings.size() != 1 || this.mFieldStrings.containsKey(str)) {
            return false;
        }
        return true;
    }

    public boolean isEmpty() {
        return this.mFieldStrings.isEmpty();
    }

    public void removeOccupation() {
        this.mFieldStrings.remove(ProfileConstants.Field.USER_OCCUPATION);
    }

    public void updateAppsFlyerId(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.APPSFLYER_ID, str);
    }

    public void updateBirthdate(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.BIRTHDAY, str);
    }

    public void updateChatPushEnabled(boolean z10) {
        updatePushEnabled(ProfileConstants.Field.NotificationSettings.CHAT_PUSH, z10);
    }

    public void updateClearRisingBagels(boolean z10) {
        this.mFieldStrings.put(ProfileConstants.Field.CLEAR_RISING_BAGELS, Boolean.valueOf(z10));
    }

    public void updateCriteriaAgeFrom(int i10) {
        this.mFieldStrings.put(ProfileConstants.Criteria.AGE_FROM, Integer.valueOf(i10));
    }

    public void updateCriteriaAgeTo(int i10) {
        this.mFieldStrings.put(ProfileConstants.Criteria.AGE_TO, Integer.valueOf(i10));
    }

    public void updateCriteriaDistanceKm(int i10) {
        this.mFieldStrings.put(ProfileConstants.Field.CRITERIA_MAX_DISTANCE_KM, Integer.valueOf(i10));
    }

    public void updateCriteriaDistanceMiles(int i10) {
        this.mFieldStrings.put(ProfileConstants.Field.CRITERIA_MAX_DISTANCE_MILES, Integer.valueOf(i10));
    }

    public void updateCriteriaEthnicity(String str) {
        this.mFieldStrings.put(ProfileConstants.Criteria.ETHNICITY, str);
    }

    public void updateCriteriaGender(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.GENDER_CRITERIA, str);
    }

    public void updateCriteriaHeightFrom(Height height) {
        this.mFieldStrings.put(ProfileConstants.Criteria.HEIGHT_INCHES_FROM, Integer.valueOf(height.getHeightInches()));
        this.mFieldStrings.put(ProfileConstants.Criteria.HEIGHT_FEET_FROM, Integer.valueOf(height.getHeightFeet()));
    }

    public void updateCriteriaHeightTo(Height height) {
        this.mFieldStrings.put(ProfileConstants.Criteria.HEIGHT_INCHES_TO, Integer.valueOf(height.getHeightInches()));
        this.mFieldStrings.put(ProfileConstants.Criteria.HEIGHT_FEET_TO, Integer.valueOf(height.getHeightFeet()));
    }

    public void updateCriteriaReligion(String str) {
        this.mFieldStrings.put(ProfileConstants.Criteria.RELIGION, str);
    }

    public void updateCustomerServicePushEnabled(boolean z10) {
        updatePushEnabled(ProfileConstants.Field.NotificationSettings.CUSTOMER_PUSH, z10);
    }

    public void updateDailyNoonAlertPushEnabled(boolean z10) {
        updatePushEnabled(ProfileConstants.Field.NotificationSettings.DAILY_PUSH, z10);
    }

    public void updateEducation(String str, String str2, String str3, String str4) {
        this.mFieldStrings.put("education", joinAsJsonArray(str, true, str3));
        this.mFieldStrings.put("degree", joinAsJsonArray(str2, true, str4));
    }

    public void updateEmail(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.USER_EMAIL, str);
    }

    public void updateEmployer(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.USER_EMPLOYER, str);
    }

    public void updateEthnicity(String str) {
        this.mFieldStrings.put("ethnicity", str);
    }

    public void updateGender(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.GENDER, str);
    }

    public void updateHasSeenLikeFlow(boolean z10) {
        this.mFieldStrings.put(ProfileConstants.Field.HAS_SEEN_LIKE_FLOW, Boolean.valueOf(z10));
    }

    public void updateHasSeenPassFlow(boolean z10) {
        this.mFieldStrings.put(ProfileConstants.Field.HAS_SEEN_PASS_FLOW, Boolean.valueOf(z10));
    }

    public void updateHeight(Height height, boolean z10) {
        if (z10) {
            this.mFieldStrings.put(ProfileConstants.Field.HEIGHT_CM, Integer.valueOf(height.getHeightCentimetres()));
            return;
        }
        this.mFieldStrings.put(ProfileConstants.Field.HEIGHT_FEET, Integer.valueOf(height.getHeightFeet()));
        this.mFieldStrings.put(ProfileConstants.Field.HEIGHT_INCHES, Integer.valueOf(height.getHeightInches()));
    }

    public void updateIcebreakers(String str, String str2, String str3) {
        this.mFieldStrings.put(ProfileConstants.Field.ICEBREAKERS, joinAsJsonArray(str, false, str2, str3));
    }

    public void updateId(String str) {
        this.mFieldStrings.put("id", str);
    }

    public void updateInputReason(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.TEXT_REASON, str);
    }

    public void updateIsMetric(boolean z10) {
        this.mFieldStrings.put(ProfileConstants.Field.IS_METRIC, Boolean.valueOf(z10));
    }

    public void updateLatitude(double d10) {
        this.mFieldStrings.put(ProfileConstants.Field.LATITUDE, Double.valueOf(d10));
    }

    public void updateList(String str, List<String> list) {
        this.mFieldStrings.put(str, new a((Collection<?>) list));
    }

    public void updateLocation(String str) {
        this.mFieldStrings.put("location", str);
    }

    public void updateLongitude(double d10) {
        this.mFieldStrings.put(ProfileConstants.Field.LONGITUDE, Double.valueOf(d10));
    }

    public void updateNewLikesPushEnabled(boolean z10) {
        updatePushEnabled(ProfileConstants.Field.NotificationSettings.NEW_LIKES_PUSH, z10);
    }

    public void updateOccupation(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.USER_OCCUPATION, str);
    }

    public void updateOnHold(boolean z10) {
        this.mFieldStrings.put(ProfileConstants.Field.ON_HOLD, Boolean.valueOf(z10));
    }

    public void updatePhone(String str) {
        this.mFieldStrings.put("phone", str);
    }

    public void updatePurchasedSubscriptionSkus(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.PURCHASED_SUBSCRIPTION_SKUS, str);
    }

    public void updateReactivateDate(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.REACTIVATE_DATE, str);
    }

    public void updateReasons(List<Reason> list) {
        int i10 = 0;
        for (Reason intValue : list) {
            i10 += intValue.getIntValue();
        }
        this.mFieldStrings.put(ProfileConstants.Field.ON_HOLD_REASON, Integer.valueOf(i10));
    }

    public void updateReligion(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.RELIGION, str);
    }

    public void updateSignupReferralCode(String str) {
        this.mFieldStrings.put(ProfileConstants.Field.SIGNUP_REFERRAL_CODE, str);
    }

    public void updateUserFirstAndLastName(d<String, String> dVar) {
        this.mFieldStrings.put(ProfileConstants.Field.FIRST_NAME, dVar.f4735a);
        this.mFieldStrings.put(ProfileConstants.Field.LAST_NAME, dVar.f4736b);
    }

    public void updateVideoPushEnabled(boolean z10) {
        updatePushEnabled(ProfileConstants.Field.NotificationSettings.VIDEO_PUSH, z10);
    }

    public void updateViewedCoachMarks(List<String> list) {
        this.mFieldStrings.put(ProfileConstants.Field.VIEWED_COACHMARKS, new a((Collection<?>) list));
    }
}
