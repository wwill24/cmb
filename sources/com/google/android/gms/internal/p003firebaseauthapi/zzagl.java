package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagl  reason: invalid package */
public final class zzagl implements zzagi {
    private final String zza = p.g("phone");
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;

    zzagl(String str, String str2, String str3, String str4, String str5) {
        this.zzb = p.g(str2);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
    }

    public static zzagl zzb(String str, String str2, String str3, String str4) {
        p.g(str3);
        p.g(str2);
        return new zzagl("phone", str, str2, str3, str4);
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("mfaProvider", 1);
        b bVar2 = new b();
        String str = this.zzc;
        if (str != null) {
            bVar2.put("sessionInfo", (Object) str);
        }
        String str2 = this.zzd;
        if (str2 != null) {
            bVar2.put("code", (Object) str2);
        }
        bVar.put("phoneVerificationInfo", (Object) bVar2);
        bVar.put("mfaPendingCredential", (Object) this.zzb);
        String str3 = this.zze;
        if (str3 != null) {
            bVar.put("tenantId", (Object) str3);
        }
        return bVar.toString();
    }
}
