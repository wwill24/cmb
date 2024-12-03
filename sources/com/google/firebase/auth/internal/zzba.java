package com.google.firebase.auth.internal;

import com.google.android.gms.internal.p003firebaseauthapi.zzzr;
import com.google.firebase.auth.GetTokenResult;
import he.a;
import java.util.HashMap;
import java.util.Map;

public final class zzba {
    private static final a zza = new a("GetTokenResultFactory", new String[0]);

    public static GetTokenResult zza(String str) {
        Map map;
        try {
            map = zzbb.zzb(str);
        } catch (zzzr e10) {
            zza.b("Error parsing token claims", e10, new Object[0]);
            map = new HashMap();
        }
        return new GetTokenResult(str, map);
    }
}
