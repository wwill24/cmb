package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagf  reason: invalid package */
public final class zzagf implements zzaek {
    private static final String zza = "zzagf";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;
    private long zzg;
    private List zzh;
    private String zzi;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = bVar.optString("localId", (String) null);
            this.zzc = bVar.optString("email", (String) null);
            this.zzd = bVar.optString("idToken", (String) null);
            this.zze = bVar.optString("refreshToken", (String) null);
            this.zzf = bVar.optBoolean("isNewUser", false);
            this.zzg = bVar.optLong("expiresIn", 0);
            this.zzh = zzahf.zzg(bVar.optJSONArray("mfaInfo"));
            this.zzi = bVar.optString("mfaPendingCredential", (String) null);
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final long zzb() {
        return this.zzg;
    }

    @NonNull
    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zzi;
    }

    @NonNull
    public final String zze() {
        return this.zze;
    }

    public final List zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzi);
    }

    public final boolean zzh() {
        return this.zzf;
    }
}
