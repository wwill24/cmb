package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzail  reason: invalid package */
public final class zzail implements zzaej {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzail(String str, String str2, String str3) {
        this.zza = p.g(str);
        this.zzb = p.g(str2);
        this.zzc = str3;
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("idToken", (Object) this.zza);
        bVar.put("mfaEnrollmentId", (Object) this.zzb);
        String str = this.zzc;
        if (str != null) {
            bVar.put("tenantId", (Object) str);
        }
        return bVar.toString();
    }
}
