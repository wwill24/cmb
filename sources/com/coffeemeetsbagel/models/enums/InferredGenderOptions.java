package com.coffeemeetsbagel.models.enums;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum InferredGenderOptions {
    MEN("inferred_men"),
    WOMEN("inferred_women"),
    NULL((String) null);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, InferredGenderOptions> map = null;
    private final String apiString;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InferredGenderOptions fromString(String str) {
            if (InferredGenderOptions.map.containsKey(str)) {
                return (InferredGenderOptions) h0.j(InferredGenderOptions.map, str);
            }
            return InferredGenderOptions.NULL;
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        InferredGenderOptions[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (InferredGenderOptions inferredGenderOptions : values) {
            linkedHashMap.put(inferredGenderOptions.apiString, inferredGenderOptions);
        }
        map = linkedHashMap;
    }

    private InferredGenderOptions(String str) {
        this.apiString = str;
    }

    public final String getApiString() {
        return this.apiString;
    }
}
