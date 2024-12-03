package com.coffeemeetsbagel.phone_login.api.models;

import com.coffeemeetsbagel.phone_login.PhoneErrorCodes;

public class VerifyCodeResponse {
    private final String error;
    private final String token;

    public VerifyCodeResponse(String str, String str2) {
        this.token = str;
        this.error = str2;
    }

    public PhoneErrorCodes getError() {
        String str = this.error;
        return str != null ? PhoneErrorCodes.f35682a.a(str) : PhoneErrorCodes.NONE;
    }

    public String getToken() {
        return this.token;
    }
}
