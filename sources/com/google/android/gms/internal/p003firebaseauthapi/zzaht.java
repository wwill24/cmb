package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaht  reason: invalid package */
public final class zzaht implements zzaej {
    private final String zza = p.g("phone");
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private zzafy zzh;

    private zzaht(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zzb = p.g(str2);
        this.zzc = p.g(str3);
        this.zze = str4;
        this.zzd = str5;
        this.zzf = str6;
        this.zzg = str7;
    }

    public static zzaht zzb(String str, String str2, String str3, String str4, String str5, String str6) {
        p.g(str3);
        return new zzaht("phone", str, str2, str3, str4, str5, str6);
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("mfaPendingCredential", (Object) this.zzb);
        bVar.put("mfaEnrollmentId", (Object) this.zzc);
        this.zza.hashCode();
        bVar.put("mfaProvider", 1);
        if (this.zze != null) {
            b bVar2 = new b();
            bVar2.put("phoneNumber", (Object) this.zze);
            if (!TextUtils.isEmpty(this.zzf)) {
                bVar2.put("recaptchaToken", (Object) this.zzf);
            }
            if (!TextUtils.isEmpty(this.zzg)) {
                bVar2.put("playIntegrityToken", (Object) this.zzg);
            }
            zzafy zzafy = this.zzh;
            if (zzafy != null) {
                bVar2.put("autoRetrievalInfo", (Object) zzafy.zza());
            }
            bVar.put("phoneSignInInfo", (Object) bVar2);
        }
        return bVar.toString();
    }

    public final String zzc() {
        return this.zzd;
    }

    public final void zzd(zzafy zzafy) {
        this.zzh = zzafy;
    }
}
