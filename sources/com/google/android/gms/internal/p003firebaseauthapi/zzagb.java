package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagb  reason: invalid package */
public final class zzagb implements zzaej {
    private final String zza;
    private final String zzb = "http://localhost";
    private final String zzc;

    public zzagb(String str, String str2) {
        this.zza = p.g(str);
        this.zzc = str2;
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("identifier", (Object) this.zza);
        bVar.put("continueUri", (Object) this.zzb);
        String str = this.zzc;
        if (str != null) {
            bVar.put("tenantId", (Object) str);
        }
        return bVar.toString();
    }
}
