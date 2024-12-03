package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaif  reason: invalid package */
public final class zzaif implements zzaej {
    private final String zza;
    private final String zzb;

    public zzaif(String str, String str2) {
        this.zza = p.g(str);
        this.zzb = str2;
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("token", (Object) this.zza);
        bVar.put("returnSecureToken", true);
        String str = this.zzb;
        if (str != null) {
            bVar.put("tenantId", (Object) str);
        }
        return bVar.toString();
    }
}
