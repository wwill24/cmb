package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagz  reason: invalid package */
public final class zzagz implements zzaej {
    private final String zza;
    private final String zzb = "CLIENT_TYPE_ANDROID";
    private final String zzc = "RECAPTCHA_ENTERPRISE";

    private zzagz(String str, String str2) {
        this.zza = str;
    }

    public static zzagz zzb(String str, String str2) {
        return new zzagz(str, "RECAPTCHA_ENTERPRISE");
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        if (!TextUtils.isEmpty(this.zza)) {
            bVar.put("tenantId", (Object) this.zza);
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            bVar.put("clientType", (Object) this.zzb);
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            bVar.put("recaptchaVersion", (Object) this.zzc);
        }
        return bVar.toString();
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }
}
