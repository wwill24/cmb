package com.google.android.gms.internal.p003firebaseauthapi;

import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahm  reason: invalid package */
public final class zzahm implements zzaek {
    private static final String zza = "zzahm";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            this.zzb = r.a(new b(str).optString("sessionInfo", (String) null));
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
