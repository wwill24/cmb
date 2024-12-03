package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.List;
import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaho  reason: invalid package */
public final class zzaho implements zzaek {
    private static final String zza = "zzaho";
    private String zzb;
    private String zzc;
    private Boolean zzd;
    private String zze;
    private String zzf;
    private zzahh zzg;
    private String zzh;
    private String zzi;
    private long zzj;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = r.a(bVar.optString("email", (String) null));
            this.zzc = r.a(bVar.optString("passwordHash", (String) null));
            this.zzd = Boolean.valueOf(bVar.optBoolean("emailVerified", false));
            this.zze = r.a(bVar.optString("displayName", (String) null));
            this.zzf = r.a(bVar.optString("photoUrl", (String) null));
            this.zzg = zzahh.zza(bVar.optJSONArray("providerUserInfo"));
            this.zzh = r.a(bVar.optString("idToken", (String) null));
            this.zzi = r.a(bVar.optString("refreshToken", (String) null));
            this.zzj = bVar.optLong("expiresIn", 0);
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final long zzb() {
        return this.zzj;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzh;
    }

    public final String zze() {
        return this.zzi;
    }

    public final List zzf() {
        zzahh zzahh = this.zzg;
        if (zzahh != null) {
            return zzahh.zzc();
        }
        return null;
    }
}
