package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.zze;
import java.util.List;
import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaie  reason: invalid package */
public final class zzaie implements zzaek {
    private static final String zza = "zzaie";
    private boolean zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private boolean zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private List zzs;
    private String zzt;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = bVar.optBoolean("needConfirmation", false);
            bVar.optBoolean("needEmail", false);
            this.zzc = r.a(bVar.optString("idToken", (String) null));
            this.zzd = r.a(bVar.optString("refreshToken", (String) null));
            this.zze = bVar.optLong("expiresIn", 0);
            this.zzf = r.a(bVar.optString("localId", (String) null));
            this.zzg = r.a(bVar.optString("email", (String) null));
            this.zzh = r.a(bVar.optString("displayName", (String) null));
            this.zzi = r.a(bVar.optString("photoUrl", (String) null));
            this.zzj = r.a(bVar.optString("providerId", (String) null));
            this.zzk = r.a(bVar.optString("rawUserInfo", (String) null));
            this.zzl = bVar.optBoolean("isNewUser", false);
            this.zzm = bVar.optString("oauthAccessToken", (String) null);
            this.zzn = bVar.optString("oauthIdToken", (String) null);
            this.zzp = r.a(bVar.optString("errorMessage", (String) null));
            this.zzq = r.a(bVar.optString("pendingToken", (String) null));
            this.zzr = r.a(bVar.optString("tenantId", (String) null));
            this.zzs = zzahf.zzg(bVar.optJSONArray("mfaInfo"));
            this.zzt = r.a(bVar.optString("mfaPendingCredential", (String) null));
            this.zzo = r.a(bVar.optString("oauthTokenSecret", (String) null));
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final long zzb() {
        return this.zze;
    }

    public final zze zzc() {
        if (!TextUtils.isEmpty(this.zzm) || !TextUtils.isEmpty(this.zzn)) {
            return zze.zzc(this.zzj, this.zzn, this.zzm, this.zzq, this.zzo);
        }
        return null;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzp;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final String zzg() {
        return this.zzt;
    }

    public final String zzh() {
        return this.zzj;
    }

    public final String zzi() {
        return this.zzk;
    }

    public final String zzj() {
        return this.zzd;
    }

    public final String zzk() {
        return this.zzr;
    }

    public final List zzl() {
        return this.zzs;
    }

    public final boolean zzm() {
        return !TextUtils.isEmpty(this.zzt);
    }

    public final boolean zzn() {
        return this.zzb;
    }

    public final boolean zzo() {
        return this.zzl;
    }

    public final boolean zzp() {
        return this.zzb || !TextUtils.isEmpty(this.zzp);
    }
}
