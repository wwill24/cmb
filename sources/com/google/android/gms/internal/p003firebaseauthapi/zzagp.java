package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagp  reason: invalid package */
public final class zzagp implements zzaej {
    private final String zza = zzago.REFRESH_TOKEN.toString();
    private final String zzb;

    public zzagp(String str) {
        this.zzb = p.g(str);
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("grantType", (Object) this.zza);
        bVar.put("refreshToken", (Object) this.zzb);
        return bVar.toString();
    }
}
