package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagq  reason: invalid package */
public final class zzagq implements zzaej {
    private final String zza;

    public zzagq(String str) {
        this.zza = p.g(str);
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("idToken", (Object) this.zza);
        return bVar.toString();
    }
}
