package com.coffeemeetsbagel.models.entities;

import android.text.TextUtils;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum GenderType {
    FEMALE(NetworkProfile.FEMALE),
    MALE(NetworkProfile.MALE),
    BISEXUAL(NetworkProfile.BISEXUAL),
    AGENDER("gender_agender"),
    ANDROGYNOUS("gender_androgynous"),
    BI_GENDER("gender_bigender"),
    NON_CONFORMING("gender_nonconforming"),
    FLUID("gender_fluid"),
    QUEER("gender_queer"),
    INTERSEX("gender_intersex"),
    NON_BINARY("gender_non_binary"),
    PAN_GENDER("gender_pangender"),
    POLY_GENDER("gender_polygender"),
    THIRD_GENDER("gender_third_gender"),
    TRANS_GENDER("gender_transgender"),
    TWO_SPIRIT("gender_two_spirit"),
    SOMETHING_ELSE("gender_something_else"),
    UNSPECIFIED("");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, GenderType> map = null;
    private final String apiKey;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GenderType fromApiKey(String str) {
            if (TextUtils.equals(str, "gender_woman")) {
                return GenderType.FEMALE;
            }
            if (TextUtils.equals(str, "gender_man")) {
                return GenderType.MALE;
            }
            try {
                Map access$getMap$cp = GenderType.map;
                if (str == null) {
                    str = "";
                }
                return (GenderType) h0.j(access$getMap$cp, str);
            } catch (NoSuchElementException unused) {
                return GenderType.UNSPECIFIED;
            }
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        GenderType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (GenderType genderType : values) {
            linkedHashMap.put(genderType.apiKey, genderType);
        }
        map = linkedHashMap;
    }

    private GenderType(String str) {
        this.apiKey = str;
    }

    public final String getApiKey() {
        return this.apiKey;
    }
}
