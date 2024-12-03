package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.facebook.AuthenticationTokenClaims;
import java.util.Map;

public class GetTokenResult {
    private String zza;
    private Map<String, Object> zzb;

    public GetTokenResult(String str, @NonNull Map<String, Object> map) {
        this.zza = str;
        this.zzb = map;
    }

    private final long zza(String str) {
        Integer num = (Integer) this.zzb.get(str);
        if (num == null) {
            return 0;
        }
        return num.longValue();
    }

    public long getAuthTimestamp() {
        return zza("auth_time");
    }

    @NonNull
    public Map<String, Object> getClaims() {
        return this.zzb;
    }

    public long getExpirationTimestamp() {
        return zza(AuthenticationTokenClaims.JSON_KEY_EXP);
    }

    public long getIssuedAtTimestamp() {
        return zza(AuthenticationTokenClaims.JSON_KEY_IAT);
    }

    public String getSignInProvider() {
        Map map = (Map) this.zzb.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    public String getSignInSecondFactor() {
        Map map = (Map) this.zzb.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_second_factor");
        }
        return null;
    }

    public String getToken() {
        return this.zza;
    }
}
