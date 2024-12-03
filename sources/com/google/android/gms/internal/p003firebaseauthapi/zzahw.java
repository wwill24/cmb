package com.google.android.gms.internal.p003firebaseauthapi;

import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahw  reason: invalid package */
public final class zzahw extends zzahs {
    private static final String zza = "zzahw";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        zzd(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzahs zzb(String str) throws zzaca {
        zzd(str);
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final zzahw zzd(String str) throws zzaca {
        try {
            b optJSONObject = new b(str).optJSONObject("phoneSessionInfo");
            if (optJSONObject != null) {
                this.zzb = zzac.zza(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }
}
