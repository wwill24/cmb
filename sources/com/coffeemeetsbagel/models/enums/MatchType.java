package com.coffeemeetsbagel.models.enums;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum MatchType {
    SUGGESTED(ModelDeeplinkData.VALUE_PAGE_SUGGESTED),
    DISCOVER(ModelDeeplinkData.VALUE_PAGE_DISCOVER),
    LIKES_YOU("likes_you"),
    CONNECTED("connected"),
    UNSUPPORTED("unsupported");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, MatchType> map = null;
    private final String key;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MatchType fromKey(String str) {
            j.g(str, SDKConstants.PARAM_KEY);
            try {
                return (MatchType) h0.j(MatchType.map, str);
            } catch (NoSuchElementException unused) {
                return MatchType.UNSUPPORTED;
            }
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        MatchType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (MatchType matchType : values) {
            linkedHashMap.put(matchType.key, matchType);
        }
        map = linkedHashMap;
    }

    private MatchType(String str) {
        this.key = str;
    }

    public final String getKey() {
        return this.key;
    }
}
