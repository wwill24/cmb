package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.m;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.kits.MPSideloadedKit;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzael  reason: invalid package */
public final class zzael {
    private final int zza;

    public zzael(String str) {
        int i10 = -1;
        try {
            List zzd = zzab.zzc("[.-]").zzd(str);
            if (zzd.size() == 1) {
                i10 = Integer.parseInt(str);
            } else if (zzd.size() >= 3) {
                i10 = (Integer.parseInt((String) zzd.get(0)) * MPSideloadedKit.MIN_SIDELOADED_KIT) + (Integer.parseInt((String) zzd.get(1)) * 1000) + Integer.parseInt((String) zzd.get(2));
            }
        } catch (IllegalArgumentException e10) {
            if (Log.isLoggable("LibraryVersionContainer", 3)) {
                String.format("Version code parsing failed for: %s with exception %s.", new Object[]{str, e10});
            }
        }
        this.zza = i10;
    }

    public static zzael zza() {
        String b10 = m.a().b("firebase-auth");
        if (TextUtils.isEmpty(b10) || b10.equals(IdentityHttpResponse.UNKNOWN)) {
            b10 = "-1";
        }
        return new zzael(b10);
    }

    public final String zzb() {
        return String.format("X%s", new Object[]{Integer.toString(this.zza)});
    }
}
