package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahx  reason: invalid package */
public final class zzahx implements zzahr {
    private final String zza;
    private final String zzb;

    private zzahx(String str, String str2) {
        this.zza = p.g(str);
        this.zzb = str2;
    }

    public static zzahx zzb(String str, String str2) {
        return new zzahx(str, str2);
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("idToken", (Object) this.zza);
        if (!TextUtils.isEmpty(this.zzb)) {
            bVar.put("tenantId", (Object) this.zzb);
        }
        bVar.put("totpEnrollmentInfo", (Object) new b());
        return bVar.toString();
    }
}
