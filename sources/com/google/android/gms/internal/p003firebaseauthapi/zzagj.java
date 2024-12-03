package com.google.android.gms.internal.p003firebaseauthapi;

import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagj  reason: invalid package */
public final class zzagj implements zzaek {
    private static final String zza = "zzagj";
    private String zzb;
    private String zzc;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = bVar.optString("idToken", (String) null);
            this.zzc = bVar.optString("refreshToken", (String) null);
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }
}
