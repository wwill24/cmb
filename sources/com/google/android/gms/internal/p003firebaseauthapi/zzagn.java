package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagn  reason: invalid package */
public final class zzagn implements zzagi {
    private final String zza = p.g(TotpMultiFactorGenerator.FACTOR_ID);
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;

    zzagn(String str, String str2, String str3, String str4, String str5) {
        this.zzb = p.g(str2);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
    }

    public static zzagn zzb(String str, String str2, String str3, String str4) {
        p.g(str2);
        p.g(str4);
        return new zzagn(TotpMultiFactorGenerator.FACTOR_ID, str, str2, str3, str4);
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        b bVar2 = new b();
        String str = this.zzc;
        if (str != null) {
            bVar2.put("verificationCode", (Object) str);
        }
        bVar.put("totpVerificationInfo", (Object) bVar2);
        bVar.put("mfaPendingCredential", (Object) this.zzb);
        String str2 = this.zzd;
        if (str2 != null) {
            bVar.put("tenantId", (Object) str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            bVar.put("mfaEnrollmentId", (Object) str3);
        }
        return bVar.toString();
    }
}
