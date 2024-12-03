package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.p;
import me.a;
import me.k;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafi  reason: invalid package */
public final class zzafi {
    private final String zza;
    private final String zzb;

    public zzafi(Context context, String str) {
        p.k(context);
        String g10 = p.g(str);
        this.zza = g10;
        try {
            byte[] a10 = a.a(context, g10);
            if (a10 == null) {
                "single cert required: ".concat(String.valueOf(str));
                this.zzb = null;
                return;
            }
            this.zzb = k.c(a10, false);
        } catch (PackageManager.NameNotFoundException unused) {
            "no pkg: ".concat(String.valueOf(str));
            this.zzb = null;
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
