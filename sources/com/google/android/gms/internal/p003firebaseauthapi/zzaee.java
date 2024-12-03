package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.d;
import com.google.android.gms.common.e;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaee  reason: invalid package */
public final class zzaee {
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int j10 = d.h().j(context, e.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            boolean z10 = true;
            if (!(j10 == 0 || j10 == 2)) {
                z10 = false;
            }
            zza = Boolean.valueOf(z10);
        }
        return zza.booleanValue();
    }
}
