package com.coffeemeetsbagel.models.entities;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum CapabilityType {
    SEE_ALL_LIKES_YOU("has_limelight"),
    PREMIUM_PREFERENCES("has_premium_preferences"),
    NONE("none");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, CapabilityType> map = null;
    private final String apiKey;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CapabilityType fromApiKey(String str) {
            CapabilityType capabilityType;
            if (!CapabilityType.map.containsKey(str)) {
                return CapabilityType.NONE;
            }
            if (str == null || (capabilityType = (CapabilityType) CapabilityType.map.get(str)) == null) {
                return CapabilityType.NONE;
            }
            return capabilityType;
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        CapabilityType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (CapabilityType capabilityType : values) {
            linkedHashMap.put(capabilityType.apiKey, capabilityType);
        }
        map = linkedHashMap;
    }

    private CapabilityType(String str) {
        this.apiKey = str;
    }

    public final String getApiKey() {
        return this.apiKey;
    }
}
