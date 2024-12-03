package com.coffeemeetsbagel.models.constants;

import com.leanplum.messagetemplates.MessageTemplateConstants;
import net.bytebuddy.jar.asm.Opcodes;

public final class ProfileConstants {
    public static final String ID = "id";
    public static final int[] POSSIBLE_DISTANCE_VALUES_KM = {8, 16, 40, 80, 160, 240, 320, 400};
    public static final int[] POSSIBLE_DISTANCE_VALUES_MILES = {5, 10, 25, 50, 100, Opcodes.FCMPG, 200, MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT};

    public static class Criteria {
        public static final String AGE_FROM = "criteria__age_from";
        public static final String AGE_TO = "criteria__age_to";
        public static final String ETHNICITY = "criteria__ethnicity";
        public static final String HEIGHT_CENTIMETERS_FROM = "criteria__height_cm_from";
        public static final String HEIGHT_CENTIMETERS_TO = "criteria__height_cm_to";
        public static final String HEIGHT_FEET_FROM = "criteria__height_feet_from";
        public static final String HEIGHT_FEET_TO = "criteria__height_feet_to";
        public static final String HEIGHT_INCHES_FROM = "criteria__height_inches_from";
        public static final String HEIGHT_INCHES_TO = "criteria__height_inches_to";
        public static final String RELIGION = "criteria__religion";
    }

    public static class Defaults {
        public static final int DEFAULT_AGE_RANGE_MAX_OFFSET_MEN = 2;
        public static final int DEFAULT_AGE_RANGE_MAX_OFFSET_WOMEN = 7;
        public static final int DEFAULT_AGE_RANGE_MIN_OFFSET_MEN = 7;
        public static final int DEFAULT_AGE_RANGE_MIN_OFFSET_WOMEN = 2;
        public static final int MAX_AGE = 99;
        public static final int MIN_AGE = 18;
    }

    public static class Field {
        public static final String APPSFLYER_ID = "appsflyer_id";
        public static final String BADGE_COUNT = "badge_count";
        public static final String BIRTHDAY = "birthday";
        public static final String CLEAR_RISING_BAGELS = "clear_rising_bagels";
        public static final String CRITERIA_MAX_DISTANCE_KM = "criteria__max_distance_km";
        public static final String CRITERIA_MAX_DISTANCE_MILES = "criteria__max_distance_miles";
        public static final String DEGREE = "degree";
        public static final String EDUCATION = "education";
        public static final String ETHNICITY = "ethnicity";
        public static final String FIRST_NAME = "user__first_name";
        public static final String GENDER = "gender";
        public static final String GENDER_CRITERIA = "criteria__gender";
        public static final String HAS_SEEN_LIKE_FLOW = "viewed_like_flow";
        public static final String HAS_SEEN_PASS_FLOW = "viewed_pass_flow";
        public static final String HEIGHT_CM = "height_cm";
        public static final String HEIGHT_FEET = "height_feet";
        public static final String HEIGHT_INCHES = "height_inches";
        public static final String ICEBREAKERS = "icebreakers";
        public static final String ID = "id";
        public static final String IS_METRIC = "height_unit_is_metric";
        public static final String LANGUAGE_CODE = "language_code";
        public static final String LAST_NAME = "user__last_name";
        public static final String LATITUDE = "latitude";
        public static final String LOCATION = "location";
        public static final String LONGITUDE = "longitude";
        public static final String NOTIFICATION_SETTINGS = "notification_settings";
        public static final String ONBOARDING_QUESTIONS = "onboarding_questions";
        public static final String ON_HOLD = "on_hold";
        public static final String ON_HOLD_REASON = "on_hold_reason";
        public static final String PHONE = "phone";
        public static final String PHOTO = "photo";
        public static final String PURCHASED_SUBSCRIPTION_SKUS = "android_purchased_subscription_skus";
        public static final String QUESTIONS = "questions";
        public static final String REACTIVATE_DATE = "reactivate_date";
        public static final String RELIGION = "religion";
        public static final String SIGNUP_REFERRAL_CODE = "signup_referral_code";
        public static final String TEXT_REASON = "text_reason";
        public static final String USER_EMAIL = "user__email";
        public static final String USER_EMPLOYER = "employer";
        public static final String USER_OCCUPATION = "occupation";
        public static final String VIEWED_COACHMARKS = "viewed_coachmarks";

        public interface NotificationSettings {
            public static final String CHAT_PUSH = "chat_push";
            public static final String CUSTOMER_PUSH = "customers_push";
            public static final String DAILY_PUSH = "daily_push";
            public static final String NEW_LIKES_PUSH = "new_likes_push";
            public static final String VIDEO_PUSH = "video_push";
        }
    }

    public static class OnboardingQuestions {
        public static final String ANSWER_NAME = "answer_name";
        public static final String ANSWER_TEXT = "answer_text";
        public static final String QUESTION_NAME = "question_name";
        public static final String QUESTION_TEXT = "question_text";
    }
}
