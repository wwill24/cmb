package com.facebook.login;

import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/facebook/login/LoginResult;", "", "accessToken", "Lcom/facebook/AccessToken;", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "recentlyGrantedPermissions", "", "", "recentlyDeniedPermissions", "(Lcom/facebook/AccessToken;Lcom/facebook/AuthenticationToken;Ljava/util/Set;Ljava/util/Set;)V", "getAccessToken", "()Lcom/facebook/AccessToken;", "getAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "getRecentlyDeniedPermissions", "()Ljava/util/Set;", "getRecentlyGrantedPermissions", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginResult {
    private final AccessToken accessToken;
    private final AuthenticationToken authenticationToken;
    private final Set<String> recentlyDeniedPermissions;
    private final Set<String> recentlyGrantedPermissions;

    public LoginResult(AccessToken accessToken2, AuthenticationToken authenticationToken2, Set<String> set, Set<String> set2) {
        j.g(accessToken2, SDKConstants.PARAM_ACCESS_TOKEN);
        j.g(set, "recentlyGrantedPermissions");
        j.g(set2, "recentlyDeniedPermissions");
        this.accessToken = accessToken2;
        this.authenticationToken = authenticationToken2;
        this.recentlyGrantedPermissions = set;
        this.recentlyDeniedPermissions = set2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoginResult(AccessToken accessToken2, Set<String> set, Set<String> set2) {
        this(accessToken2, (AuthenticationToken) null, set, set2, 2, (DefaultConstructorMarker) null);
        j.g(accessToken2, SDKConstants.PARAM_ACCESS_TOKEN);
        j.g(set, "recentlyGrantedPermissions");
        j.g(set2, "recentlyDeniedPermissions");
    }

    public static /* synthetic */ LoginResult copy$default(LoginResult loginResult, AccessToken accessToken2, AuthenticationToken authenticationToken2, Set<String> set, Set<String> set2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            accessToken2 = loginResult.accessToken;
        }
        if ((i10 & 2) != 0) {
            authenticationToken2 = loginResult.authenticationToken;
        }
        if ((i10 & 4) != 0) {
            set = loginResult.recentlyGrantedPermissions;
        }
        if ((i10 & 8) != 0) {
            set2 = loginResult.recentlyDeniedPermissions;
        }
        return loginResult.copy(accessToken2, authenticationToken2, set, set2);
    }

    public final AccessToken component1() {
        return this.accessToken;
    }

    public final AuthenticationToken component2() {
        return this.authenticationToken;
    }

    public final Set<String> component3() {
        return this.recentlyGrantedPermissions;
    }

    public final Set<String> component4() {
        return this.recentlyDeniedPermissions;
    }

    public final LoginResult copy(AccessToken accessToken2, AuthenticationToken authenticationToken2, Set<String> set, Set<String> set2) {
        j.g(accessToken2, SDKConstants.PARAM_ACCESS_TOKEN);
        j.g(set, "recentlyGrantedPermissions");
        j.g(set2, "recentlyDeniedPermissions");
        return new LoginResult(accessToken2, authenticationToken2, set, set2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginResult)) {
            return false;
        }
        LoginResult loginResult = (LoginResult) obj;
        return j.b(this.accessToken, loginResult.accessToken) && j.b(this.authenticationToken, loginResult.authenticationToken) && j.b(this.recentlyGrantedPermissions, loginResult.recentlyGrantedPermissions) && j.b(this.recentlyDeniedPermissions, loginResult.recentlyDeniedPermissions);
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final AuthenticationToken getAuthenticationToken() {
        return this.authenticationToken;
    }

    public final Set<String> getRecentlyDeniedPermissions() {
        return this.recentlyDeniedPermissions;
    }

    public final Set<String> getRecentlyGrantedPermissions() {
        return this.recentlyGrantedPermissions;
    }

    public int hashCode() {
        int hashCode = this.accessToken.hashCode() * 31;
        AuthenticationToken authenticationToken2 = this.authenticationToken;
        return ((((hashCode + (authenticationToken2 == null ? 0 : authenticationToken2.hashCode())) * 31) + this.recentlyGrantedPermissions.hashCode()) * 31) + this.recentlyDeniedPermissions.hashCode();
    }

    public String toString() {
        return "LoginResult(accessToken=" + this.accessToken + ", authenticationToken=" + this.authenticationToken + ", recentlyGrantedPermissions=" + this.recentlyGrantedPermissions + ", recentlyDeniedPermissions=" + this.recentlyDeniedPermissions + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoginResult(AccessToken accessToken2, AuthenticationToken authenticationToken2, Set set, Set set2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(accessToken2, (i10 & 2) != 0 ? null : authenticationToken2, set, set2);
    }
}
