package com.coffeemeetsbagel.feature.authentication.api.models;

import java.util.Objects;
import java.util.Set;
import lg.c;

public class LoginBody {
    @c("access_token")
    private final String accessToken;
    @c("app_version")
    private final int appVersion;
    private final Set<String> permissions;

    public LoginBody(String str, int i10, Set<String> set) {
        this.accessToken = str;
        this.appVersion = i10;
        this.permissions = set;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoginBody loginBody = (LoginBody) obj;
        if (!Objects.equals(this.accessToken, loginBody.accessToken) || !Objects.equals(Integer.valueOf(this.appVersion), Integer.valueOf(loginBody.appVersion)) || !Objects.equals(this.permissions, loginBody.permissions)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.accessToken, Integer.valueOf(this.appVersion), this.permissions});
    }
}
