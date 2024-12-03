package com.coffeemeetsbagel.feature.authentication.api.models;

public class AuthenticateBody {
    private final String access_token;

    public AuthenticateBody(String str) {
        this.access_token = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AuthenticateBody)) {
            return false;
        }
        return ((AuthenticateBody) obj).access_token.equals(this.access_token);
    }
}
