package com.google.android.gms.internal.p003firebaseauthapi;

import androidx.annotation.NonNull;
import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahq  reason: invalid package */
public final class zzahq implements zzaek {
    private static final String zza = "zzahq";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private long zzf;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = r.a(bVar.optString("idToken", (String) null));
            this.zzc = r.a(bVar.optString("displayName", (String) null));
            this.zzd = r.a(bVar.optString("email", (String) null));
            this.zze = r.a(bVar.optString("refreshToken", (String) null));
            this.zzf = bVar.optLong("expiresIn", 0);
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final long zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzb;
    }

    @NonNull
    public final String zzd() {
        return this.zze;
    }
}
