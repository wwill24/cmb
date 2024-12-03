package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahj  reason: invalid package */
public final class zzahj implements zzaej {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzahj(String str, String str2, String str3) {
        this.zza = p.g(str);
        this.zzb = str2;
        this.zzc = str3;
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("oobCode", (Object) this.zza);
        String str = this.zzb;
        if (str != null) {
            bVar.put("newPassword", (Object) str);
        }
        String str2 = this.zzc;
        if (str2 != null) {
            bVar.put("tenantId", (Object) str2);
        }
        return bVar.toString();
    }
}
