package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcc  reason: invalid package */
public final class zzcc {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzcb zza(String str) throws GeneralSecurityException {
        Iterator it = zza.iterator();
        while (it.hasNext()) {
            zzcb zzcb = (zzcb) it.next();
            if (zzcb.zzb(str)) {
                return zzcb;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
