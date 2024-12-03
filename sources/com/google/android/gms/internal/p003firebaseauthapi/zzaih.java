package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaih  reason: invalid package */
public final class zzaih implements zzaej {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public zzaih(String str, String str2, String str3, String str4) {
        this.zza = p.g(str);
        this.zzb = p.g(str2);
        this.zzc = str3;
        this.zzd = str4;
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("email", (Object) this.zza);
        bVar.put("password", (Object) this.zzb);
        bVar.put("returnSecureToken", true);
        String str = this.zzc;
        if (str != null) {
            bVar.put("tenantId", (Object) str);
        }
        String str2 = this.zzd;
        if (str2 != null) {
            zzain.zzd(bVar, "captchaResponse", str2);
        } else {
            zzain.zzc(bVar);
        }
        return bVar.toString();
    }
}
