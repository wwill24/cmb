package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import he.a;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzage  reason: invalid package */
public final class zzage implements zzaej {
    private static final String zza = "zzage";
    private static final a zzb = new a(zzage.class.getSimpleName(), new String[0]);
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    public zzage(EmailAuthCredential emailAuthCredential, String str, String str2) {
        this.zzc = p.g(emailAuthCredential.zzd());
        this.zzd = p.g(emailAuthCredential.zzf());
        this.zze = str;
        this.zzf = str2;
    }

    public final String zza() throws JSONException {
        String str;
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(this.zzd);
        String str2 = null;
        if (parseLink != null) {
            str = parseLink.getCode();
        } else {
            str = null;
        }
        if (parseLink != null) {
            str2 = parseLink.zza();
        }
        b bVar = new b();
        bVar.put("email", (Object) this.zzc);
        if (str != null) {
            bVar.put("oobCode", (Object) str);
        }
        if (str2 != null) {
            bVar.put("tenantId", (Object) str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            bVar.put("idToken", (Object) str3);
        }
        String str4 = this.zzf;
        if (str4 != null) {
            zzain.zzd(bVar, "captchaResp", str4);
        } else {
            zzain.zzc(bVar);
        }
        return bVar.toString();
    }
}
