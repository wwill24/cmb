package com.coffeemeetsbagel.models;

import lg.c;

public class VerifyPhoneNumberBody {
    @c("phone_number")
    private final String phoneNumber;
    @c("vem")
    private final String vem;

    public VerifyPhoneNumberBody(String str, String str2) {
        this.phoneNumber = str;
        this.vem = str2;
    }
}
