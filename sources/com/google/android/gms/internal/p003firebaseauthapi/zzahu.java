package com.google.android.gms.internal.p003firebaseauthapi;

import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahu  reason: invalid package */
public final class zzahu implements zzaek {
    private static final String zza = "zzahu";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b optJSONObject = new b(str).optJSONObject("phoneResponseInfo");
            if (optJSONObject != null) {
                this.zzb = r.a(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
