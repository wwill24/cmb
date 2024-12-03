package com.coffeemeetsbagel.models.enums;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum Units {
    METRIC("metric"),
    IMPERIAL("imperial");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, Units> map = null;
    private final String apiKey;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Units fromString(String str) {
            try {
                Map access$getMap$cp = Units.map;
                if (str == null) {
                    str = "";
                }
                return (Units) h0.j(access$getMap$cp, str);
            } catch (NoSuchElementException unused) {
                return Units.IMPERIAL;
            }
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        Units[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (Units units : values) {
            linkedHashMap.put(units.apiKey, units);
        }
        map = linkedHashMap;
    }

    private Units(String str) {
        this.apiKey = str;
    }

    public final String getApiKey() {
        return this.apiKey;
    }
}
