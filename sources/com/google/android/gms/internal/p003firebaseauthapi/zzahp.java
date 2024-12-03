package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahp  reason: invalid package */
public final class zzahp implements zzaej {
    private String zza;
    private String zzb;
    private final String zzc;
    private String zzd;

    public zzahp(String str) {
        this.zzc = str;
    }

    public zzahp(String str, String str2, String str3, String str4, String str5) {
        this.zza = p.g(str);
        this.zzb = p.g(str2);
        this.zzc = str4;
        this.zzd = str5;
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        String str = this.zza;
        if (str != null) {
            bVar.put("email", (Object) str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            bVar.put("password", (Object) str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            bVar.put("tenantId", (Object) str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            zzain.zzd(bVar, "captchaResponse", str4);
        } else {
            zzain.zzc(bVar);
        }
        return bVar.toString();
    }
}
