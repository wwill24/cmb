package com.google.android.gms.internal.p003firebaseauthapi;

import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaig  reason: invalid package */
public final class zzaig implements zzaek {
    private static final String zza = "zzaig";
    private String zzb;
    private String zzc;
    private long zzd;
    private boolean zze;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = r.a(bVar.optString("idToken", (String) null));
            this.zzc = r.a(bVar.optString("refreshToken", (String) null));
            this.zzd = bVar.optLong("expiresIn", 0);
            this.zze = bVar.optBoolean("isNewUser", false);
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final long zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zze;
    }
}
