package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;
import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii  reason: invalid package */
public final class zzaii implements zzaek {
    private static final String zza = "zzaii";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private List zzi;
    private String zzj;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = r.a(bVar.optString("localId", (String) null));
            this.zzc = r.a(bVar.optString("email", (String) null));
            this.zzd = r.a(bVar.optString("displayName", (String) null));
            this.zze = r.a(bVar.optString("idToken", (String) null));
            this.zzf = r.a(bVar.optString("photoUrl", (String) null));
            this.zzg = r.a(bVar.optString("refreshToken", (String) null));
            this.zzh = bVar.optLong("expiresIn", 0);
            this.zzi = zzahf.zzg(bVar.optJSONArray("mfaInfo"));
            this.zzj = bVar.optString("mfaPendingCredential", (String) null);
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    @NonNull
    public final String zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zzj;
    }

    @NonNull
    public final String zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzj);
    }
}
