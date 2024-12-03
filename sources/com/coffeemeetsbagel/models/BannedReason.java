package com.coffeemeetsbagel.models;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.b;

public enum BannedReason {
    BANNED("BANNED"),
    BANNED_ADMIN("BANNED_ADMIN"),
    BAD_USER("BANNED_BAD_USER"),
    LEGACY_BANNED("BANNED_PROFILE"),
    NONE("");
    
    public static final Companion Companion = null;
    private final String apiReason;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BannedReason fromApiKey(String str) {
            boolean z10;
            if (str == null || r.w(str)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return BannedReason.NONE;
            }
            BannedReason[] values = BannedReason.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
            for (BannedReason bannedReason : values) {
                linkedHashMap.put(bannedReason.getApiReason(), bannedReason);
            }
            if (linkedHashMap.containsKey(str)) {
                BannedReason bannedReason2 = (BannedReason) linkedHashMap.get(str);
                if (bannedReason2 == null) {
                    return BannedReason.NONE;
                }
                return bannedReason2;
            } else if (r.H(str, "banned", true)) {
                return BannedReason.LEGACY_BANNED;
            } else {
                return BannedReason.NONE;
            }
        }

        public final BannedReason fromJsonString(String str) {
            if (str == null) {
                str = "";
            }
            try {
                return fromApiKey(new b(str).getString("error"));
            } catch (Exception unused) {
                return BannedReason.NONE;
            }
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private BannedReason(String str) {
        this.apiReason = str;
    }

    public final String getApiReason() {
        return this.apiReason;
    }
}
