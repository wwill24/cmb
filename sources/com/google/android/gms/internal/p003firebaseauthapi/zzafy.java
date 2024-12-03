package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafy  reason: invalid package */
public final class zzafy {
    private final String zza;

    public zzafy(String str) {
        this.zza = p.g(str);
    }

    public final b zza() throws JSONException {
        b bVar = new b();
        bVar.put("appSignatureHash", (Object) this.zza);
        return bVar;
    }
}
