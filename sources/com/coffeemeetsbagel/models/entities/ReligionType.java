package com.coffeemeetsbagel.models.entities;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum ReligionType {
    BUDDHIST("Buddhist"),
    CHRISTIAN("Christian"),
    CATHOLIC("Catholic"),
    HINDU("Hindu"),
    JEWISH("Jewish"),
    MUSLIM("Muslim"),
    SIKH("Sikh"),
    SHINTO("Shinto"),
    SPIRITUAL_BUT_NOT_RELIGIOUS("Spiritual but not religious"),
    NEITHER_SPIRITUAL_NOR_RELIGIOUS("Neither religious nor spiritual"),
    OTHER("Other");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, ReligionType> map = null;
    private final String apiKey;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReligionType fromApiKey(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (str != null) {
                    return (ReligionType) h0.j(ReligionType.map, str);
                }
                return null;
            } catch (NoSuchElementException unused) {
                return ReligionType.OTHER;
            }
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        ReligionType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (ReligionType religionType : values) {
            linkedHashMap.put(religionType.apiKey, religionType);
        }
        map = linkedHashMap;
    }

    private ReligionType(String str) {
        this.apiKey = str;
    }

    public final String getApiKey() {
        return this.apiKey;
    }
}
