package com.google.android.gms.internal.p003firebaseauthapi;

import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaim  reason: invalid package */
public final class zzaim implements zzaek {
    private static final String zza = "zzaim";
    private String zzb;
    private String zzc;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = r.a(bVar.optString("idToken", (String) null));
            this.zzc = r.a(bVar.optString("refreshToken", (String) null));
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
