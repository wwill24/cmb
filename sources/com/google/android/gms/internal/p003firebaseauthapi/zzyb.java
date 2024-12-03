package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyb  reason: invalid package */
final class zzyb extends ThreadLocal {
    zzyb() {
    }

    protected static final Cipher zza() {
        try {
            return (Cipher) zzyv.zza.zza("AES/CTR/NOPADDING");
        } catch (GeneralSecurityException e10) {
            throw new IllegalStateException(e10);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
