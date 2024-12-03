package com.google.android.gms.internal.p003firebaseauthapi;

import android.util.Log;
import com.facebook.AuthenticationTokenClaims;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahe  reason: invalid package */
public final class zzahe {
    private String zza;
    private String zzb;
    private String zzc;
    private Long zzd;
    private Long zze;

    public static zzahe zza(String str) throws UnsupportedEncodingException {
        try {
            zzahe zzahe = new zzahe();
            b bVar = new b(str);
            zzahe.zza = bVar.optString(AuthenticationTokenClaims.JSON_KEY_ISS);
            zzahe.zzb = bVar.optString(AuthenticationTokenClaims.JSON_KEY_AUD);
            zzahe.zzc = bVar.optString("sub");
            zzahe.zzd = Long.valueOf(bVar.optLong(AuthenticationTokenClaims.JSON_KEY_IAT));
            zzahe.zze = Long.valueOf(bVar.optLong(AuthenticationTokenClaims.JSON_KEY_EXP));
            bVar.optBoolean("is_anonymous");
            return zzahe;
        } catch (JSONException e10) {
            if (Log.isLoggable("JwtToken", 3)) {
                "Failed to read JwtToken from JSONObject. ".concat(e10.toString());
            }
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. ".concat(e10.toString()));
        }
    }

    public final Long zzb() {
        return this.zze;
    }

    public final Long zzc() {
        return this.zzd;
    }
}
