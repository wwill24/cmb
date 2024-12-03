package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagk  reason: invalid package */
public final class zzagk implements zzagg {
    private final String zza = p.g("phone");
    private String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    private zzagk(String str, String str2, String str3, String str4, String str5, String str6) {
        this.zzb = p.g(str2);
        this.zzd = str3;
        this.zze = str4;
        this.zzc = str5;
        this.zzf = str6;
    }

    public static zzagk zzc(String str, String str2, String str3, String str4, String str5) {
        p.g(str3);
        p.g(str2);
        return new zzagk("phone", str, str2, str3, str4, str5);
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("idToken", (Object) this.zzb);
        bVar.put("mfaProvider", 1);
        String str = this.zzc;
        if (str != null) {
            bVar.put("displayName", (Object) str);
        }
        b bVar2 = new b();
        String str2 = this.zzd;
        if (str2 != null) {
            bVar2.put("sessionInfo", (Object) str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            bVar2.put("code", (Object) str3);
        }
        bVar.put("phoneVerificationInfo", (Object) bVar2);
        String str4 = this.zzf;
        if (str4 != null) {
            bVar.put("tenantId", (Object) str4);
        }
        return bVar.toString();
    }

    public final /* synthetic */ zzagg zzb(String str) {
        this.zzb = str;
        return this;
    }
}
