package com.coffeemeetsbagel.phone_login.api.models;

import android.text.TextUtils;
import com.coffeemeetsbagel.phone_login.PhoneErrorCodes;
import lg.c;

public class VerifyPhoneNumberResponse {
    private static final int MAX_AUTH_CODE_LENGTH = 6;
    private static final int MIN_AUTH_CODE_LENGTH = 4;
    @c("auth_code_length")
    private final String authCodeLength;
    private final String error;
    private final String result;
    @c("type")
    private final String type;

    public enum VerifyType {
        SMS("sms"),
        PHONE_CALL("phone_call");
        
        private final String type;

        private VerifyType(String str) {
            this.type = str;
        }

        static VerifyType fromString(String str) {
            for (VerifyType verifyType : values()) {
                if (TextUtils.equals(verifyType.type.toLowerCase(), str.toLowerCase())) {
                    return verifyType;
                }
            }
            return SMS;
        }
    }

    public VerifyPhoneNumberResponse(String str, String str2, String str3, String str4) {
        this.result = str;
        this.authCodeLength = str2;
        this.error = str3;
        this.type = str4;
    }

    public int getAuthCodeLength() {
        try {
            return Integer.parseInt(this.authCodeLength);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public PhoneErrorCodes getError() {
        String str = this.error;
        return str != null ? PhoneErrorCodes.f35682a.a(str) : PhoneErrorCodes.NONE;
    }

    public String getResult() {
        return this.result;
    }

    public VerifyType getVerifyType() {
        String str = this.type;
        if (str == null) {
            str = "";
        }
        return VerifyType.fromString(str);
    }

    public boolean isSuccessful() {
        if (!TextUtils.equals(this.result, "verificationCodeSent") || getAuthCodeLength() > 6 || getAuthCodeLength() < 4) {
            return false;
        }
        return true;
    }
}
