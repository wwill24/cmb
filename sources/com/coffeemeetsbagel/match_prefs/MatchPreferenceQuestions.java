package com.coffeemeetsbagel.match_prefs;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum MatchPreferenceQuestions {
    RELIGION("religion_preference"),
    ETHNICITY("ethnicity_preference"),
    HEIGHT("height_preference"),
    DISTANCE("distance_preference"),
    GENDER("gender_preference"),
    AGE("age_preference"),
    NONE("");
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f34553a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, MatchPreferenceQuestions> f34554b = null;
    private final String apiKey;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i10;
        f34553a = new a((DefaultConstructorMarker) null);
        MatchPreferenceQuestions[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (MatchPreferenceQuestions matchPreferenceQuestions : values) {
            linkedHashMap.put(matchPreferenceQuestions.apiKey, matchPreferenceQuestions);
        }
        f34554b = linkedHashMap;
    }

    private MatchPreferenceQuestions(String str) {
        this.apiKey = str;
    }

    public final String b() {
        return this.apiKey;
    }
}
