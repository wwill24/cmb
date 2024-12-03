package com.coffeemeetsbagel.phone_login;

import com.coffeemeetsbagel.R;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum PhoneErrorCodes {
    AUTH_CODE_EXPIRED("AUTH_CODE_EXPIRED", R.string.phone_error_auth_code_expired),
    TOO_MANY_ATTEMPTS("TOO_MANY_ATTEMPTS", R.string.phone_error_too_many_attempts),
    COUNTRY_NOT_SUPPORTED("COUNTRY_NOT_SUPPORTED", R.string.phone_error_country_not_supported),
    BLOCKED_FOR_SECURITY("BLOCKED_FOR_SECURITY", R.string.phone_error_blocked_security),
    INVALID_AUTH_CODE("INVALID_AUTH_CODE", R.string.phone_error_auth_code),
    INVALID_PHONE_NUMBER("INVALID_PHONE_NUMBER", R.string.phone_error_invalid_number),
    OTHER_ERROR("OTHER_ERROR", R.string.phone_error_other),
    NONE("NONE", -1);
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f35682a = null;
    private final String code;
    private final int stringRes;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PhoneErrorCodes a(String str) {
            j.g(str, "code");
            PhoneErrorCodes[] values = PhoneErrorCodes.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
            for (PhoneErrorCodes phoneErrorCodes : values) {
                linkedHashMap.put(phoneErrorCodes.b(), phoneErrorCodes);
            }
            if (!linkedHashMap.containsKey(str)) {
                return PhoneErrorCodes.OTHER_ERROR;
            }
            Object obj = linkedHashMap.get(str);
            j.d(obj);
            return (PhoneErrorCodes) obj;
        }
    }

    static {
        f35682a = new a((DefaultConstructorMarker) null);
    }

    private PhoneErrorCodes(String str, int i10) {
        this.code = str;
        this.stringRes = i10;
    }

    public final String b() {
        return this.code;
    }

    public final int c() {
        return this.stringRes;
    }
}
