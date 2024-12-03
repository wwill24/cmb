package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.a;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagy  reason: invalid package */
public final class zzagy implements zzaek {
    private static final String zza = "zzagy";
    private List zzb;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        zzb(str);
        return this;
    }

    public final zzagy zzb(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = new ArrayList();
            a optJSONArray = bVar.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.o(); i10++) {
                    this.zzb.add(optJSONArray.n(i10));
                }
            }
            return this;
        } catch (JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final List zzc() {
        return this.zzb;
    }
}
