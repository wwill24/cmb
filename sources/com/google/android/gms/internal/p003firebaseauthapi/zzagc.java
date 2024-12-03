package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.List;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagc  reason: invalid package */
public final class zzagc implements zzaek {
    private static final String zza = "zzagc";
    private String zzb;
    private String zzc;
    private zzahz zzd = new zzahz((List) null);
    private List zze;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = bVar.optString("authUri", (String) null);
            bVar.optBoolean("registered", false);
            this.zzc = bVar.optString("providerId", (String) null);
            bVar.optBoolean("forExistingProvider", false);
            if (!bVar.has("allProviders")) {
                this.zzd = new zzahz((List) null);
            } else {
                this.zzd = new zzahz(1, zzain.zzb(bVar.optJSONArray("allProviders")));
            }
            this.zze = zzain.zzb(bVar.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final List zzb() {
        return this.zze;
    }
}
