package com.coffeemeetsbagel.models.entities;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum EthnicityType {
    ASIAN("Asian"),
    ARAB("Arab"),
    BLACK_AFRICAN("Black/African-descent"),
    HISPANIC_LATINO("Hispanic/Latino"),
    NATIVE_AMERICAN("Native American"),
    PACIFIC_ISLANDER("Pacific Islander"),
    SOUTH_ASIAN("South Asian"),
    WHITE_CAUCASIAN("White/Caucasian"),
    OTHER("Other");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, EthnicityType> map = null;
    private final String apiKey;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EthnicityType fromApiKey(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (str != null) {
                    return (EthnicityType) h0.j(EthnicityType.map, str);
                }
                return null;
            } catch (NoSuchElementException unused) {
                return EthnicityType.OTHER;
            }
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        EthnicityType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (EthnicityType ethnicityType : values) {
            linkedHashMap.put(ethnicityType.apiKey, ethnicityType);
        }
        map = linkedHashMap;
    }

    private EthnicityType(String str) {
        this.apiKey = str;
    }

    public final String getApiKey() {
        return this.apiKey;
    }
}
