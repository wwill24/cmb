package com.coffeemeetsbagel.models;

import lg.c;

public class VerifyCodeBody {
    @c("auth_code")
    private final String code;
    @c("phone_number")
    private final String phoneNumber;

    public VerifyCodeBody(String str, String str2) {
        this.phoneNumber = str;
        this.code = str2;
    }
}
