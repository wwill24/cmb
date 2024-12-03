package com.coffeemeetsbagel.models.enums;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum QuestionGroupType {
    CORE_PROFILE_DATA("core_profile_data"),
    PROMPTS("prompts"),
    DEALBREAKERS("dealbreakers"),
    MATCH_PREFERENCES("match_preferences"),
    INTERESTS("interests"),
    IDENTITY_PROFILE("identity_profile"),
    VALUES("values"),
    PERSONALITY("personality"),
    ONBOARDING("onboarding"),
    DATING_STYLE("dating_style"),
    ORIGINAL_PROFILE("original_profile"),
    ICEBREAKERS(ProfileConstants.Field.ICEBREAKERS),
    FREE_PREFERENCES("free_preferences"),
    EDUCATION_ONE("profile_education_one"),
    EDUCATION_TWO("profile_education_two"),
    NONE("");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, QuestionGroupType> map = null;
    private final String questionGroupApiString;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QuestionGroupType fromApiString(String str) {
            j.g(str, "apiString");
            try {
                return (QuestionGroupType) h0.j(QuestionGroupType.map, str);
            } catch (NoSuchElementException unused) {
                return QuestionGroupType.NONE;
            }
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        QuestionGroupType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (QuestionGroupType questionGroupType : values) {
            linkedHashMap.put(questionGroupType.questionGroupApiString, questionGroupType);
        }
        map = linkedHashMap;
    }

    private QuestionGroupType(String str) {
        this.questionGroupApiString = str;
    }

    public final String getQuestionGroupApiString() {
        return this.questionGroupApiString;
    }
}
