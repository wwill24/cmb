package com.google.android.gms.internal.p003firebaseauthapi;

import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagx  reason: invalid package */
public final class zzagx implements zzaek {
    private static final String zza = "zzagx";
    private String zzb;

    public zzagx() {
    }

    public zzagx(String str) {
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            this.zzb = r.a(new b(str).optString("producerProjectNumber"));
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
