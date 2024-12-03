package com.coffeemeetsbagel.models.enums;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum ProfileQuestion {
    LOCATION("profile_location"),
    EMPLOYER("profile_employer"),
    GENDER("gender_inferred"),
    GENDER_IDENTITY("gender_identity"),
    OCCUPATION("profile_occupation"),
    RELIGION("profile_religion"),
    ETHNICITY("profile_ethnicity"),
    ICEBREAKER_ONE("icebreaker_one"),
    ICEBREAKER_TWO("icebreaker_two"),
    ICEBREAKER_THREE("icebreaker_three"),
    DEGREE_ONE("profile_degree_one"),
    SCHOOL_ONE("profile_school_one"),
    DEGREE_TWO("profile_degree_two"),
    SCHOOL_TWO("profile_school_two"),
    HEIGHT("profile_height"),
    UNITS("profile_units"),
    NONE("");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, ProfileQuestion> map = null;
    private final String apiKey;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileQuestion fromString(String str) {
            j.g(str, "apiName");
            try {
                return (ProfileQuestion) h0.j(ProfileQuestion.map, str);
            } catch (NoSuchElementException unused) {
                return ProfileQuestion.NONE;
            }
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        ProfileQuestion[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (ProfileQuestion profileQuestion : values) {
            linkedHashMap.put(profileQuestion.apiKey, profileQuestion);
        }
        map = linkedHashMap;
    }

    private ProfileQuestion(String str) {
        this.apiKey = str;
    }

    public final String getApiKey() {
        return this.apiKey;
    }
}
