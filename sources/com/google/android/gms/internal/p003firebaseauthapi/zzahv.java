package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahv  reason: invalid package */
public final class zzahv implements zzahr {
    private final String zza;
    private final String zzb = p.g("phone");
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private zzafy zzg;

    private zzahv(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = p.g(str);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
    }

    public static zzahv zzb(String str, String str2, String str3, String str4, String str5, String str6) {
        p.g(str2);
        return new zzahv(str, "phone", str2, str3, str4, str5, (String) null);
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("idToken", (Object) this.zza);
        bVar.put("mfaProvider", 1);
        if (this.zzc != null) {
            b bVar2 = new b();
            bVar2.put("phoneNumber", (Object) this.zzc);
            if (!TextUtils.isEmpty(this.zze)) {
                bVar2.put("recaptchaToken", (Object) this.zze);
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                bVar2.put("playIntegrityToken", (Object) this.zzf);
            }
            zzafy zzafy = this.zzg;
            if (zzafy != null) {
                bVar2.put("autoRetrievalInfo", (Object) zzafy.zza());
            }
            bVar.put("phoneEnrollmentInfo", (Object) bVar2);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            bVar.put("tenantId", (Object) null);
        }
        return bVar.toString();
    }

    public final String zzc() {
        return this.zzd;
    }

    public final void zzd(zzafy zzafy) {
        this.zzg = zzafy;
    }
}
