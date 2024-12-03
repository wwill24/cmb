package com.google.android.gms.internal.p003firebaseauthapi;

import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaik  reason: invalid package */
public final class zzaik implements zzaek {
    private static final String zza = "zzaik";
    private String zzb;
    private String zzc;
    private long zzd;
    private String zze;
    private boolean zzf;
    private String zzg;
    private String zzh;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = r.a(bVar.optString("idToken", (String) null));
            this.zzc = r.a(bVar.optString("refreshToken", (String) null));
            this.zzd = bVar.optLong("expiresIn", 0);
            this.zze = r.a(bVar.optString("localId", (String) null));
            this.zzf = bVar.optBoolean("isNewUser", false);
            this.zzg = r.a(bVar.optString("temporaryProof", (String) null));
            this.zzh = r.a(bVar.optString("phoneNumber", (String) null));
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
        return this.zzh;
    }

    public final String zze() {
        return this.zzc;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzf;
    }
}
