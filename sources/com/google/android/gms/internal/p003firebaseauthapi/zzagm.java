package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagm  reason: invalid package */
public final class zzagm implements zzagg {
    private String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;

    zzagm(String str, String str2, String str3, String str4, String str5) {
        this.zza = p.g(str);
        this.zzb = p.g(str2);
        this.zzc = p.g(str3);
        this.zzd = p.g(str4);
        this.zze = str5;
    }

    public static zzagm zzc(String str, String str2, String str3, String str4, String str5) {
        return new zzagm(str, str2, str3, str4, str5);
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("idToken", (Object) this.zza);
        if (!TextUtils.isEmpty(this.zzb)) {
            bVar.put("displayName", (Object) this.zzb);
        }
        b bVar2 = new b();
        if (!TextUtils.isEmpty(this.zzc)) {
            bVar2.put("sessionInfo", (Object) this.zzc);
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            bVar2.put("verificationCode", (Object) this.zzd);
        }
        bVar.put("totpVerificationInfo", (Object) bVar2);
        if (!TextUtils.isEmpty(this.zze)) {
            bVar.put("tenantId", (Object) this.zze);
        }
        return bVar.toString();
    }

    public final /* synthetic */ zzagg zzb(String str) {
        this.zza = str;
        return this;
    }
}
