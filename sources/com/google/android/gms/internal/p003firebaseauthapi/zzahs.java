package com.google.android.gms.internal.p003firebaseauthapi;

import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahs  reason: invalid package */
public class zzahs implements zzaek {
    private static final String zza = "zzahs";

    /* renamed from: zzb */
    public zzahs zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            if (bVar.optJSONObject("phoneSessionInfo") != null) {
                zzahw zzahw = new zzahw();
                zzahw.zzd(str);
                return zzahw;
            } else if (bVar.optJSONObject("totpSessionInfo") != null) {
                zzahy zzahy = new zzahy();
                zzahy.zzg(str);
                return zzahy;
            } else {
                throw new IllegalArgumentException("Missing phoneSessionInfo or totpSessionInfo.");
            }
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public String zzc() {
        return null;
    }
}
