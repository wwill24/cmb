package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyi  reason: invalid package */
public final class zzyi implements zzbk {
    private static final byte[] zza = new byte[0];
    private final ECPrivateKey zzb;
    private final zzyk zzc;
    private final String zzd;
    private final byte[] zze;
    private final zzyh zzf;
    private final int zzg;

    public zzyi(ECPrivateKey eCPrivateKey, byte[] bArr, String str, int i10, zzyh zzyh) throws GeneralSecurityException {
        this.zzb = eCPrivateKey;
        this.zzc = new zzyk(eCPrivateKey);
        this.zze = bArr;
        this.zzd = str;
        this.zzg = i10;
        this.zzf = zzyh;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(byte[] r10, byte[] r11) throws java.security.GeneralSecurityException {
        /*
            r9 = this;
            java.security.interfaces.ECPrivateKey r11 = r9.zzb
            java.security.spec.ECParameterSpec r11 = r11.getParams()
            java.security.spec.EllipticCurve r11 = r11.getCurve()
            int r11 = com.google.android.gms.internal.p003firebaseauthapi.zzym.zza(r11)
            int r0 = r9.zzg
            int r0 = r0 + -1
            r1 = 1
            if (r0 == 0) goto L_0x0019
            if (r0 == r1) goto L_0x001a
            int r11 = r11 + r11
            goto L_0x001b
        L_0x0019:
            int r11 = r11 + r11
        L_0x001a:
            int r11 = r11 + r1
        L_0x001b:
            int r0 = r10.length
            if (r0 < r11) goto L_0x0047
            r1 = 0
            byte[] r3 = java.util.Arrays.copyOfRange(r10, r1, r11)
            com.google.android.gms.internal.firebase-auth-api.zzyk r2 = r9.zzc
            java.lang.String r4 = r9.zzd
            byte[] r5 = r9.zze
            r6 = 0
            com.google.android.gms.internal.firebase-auth-api.zzyh r1 = r9.zzf
            int r8 = r9.zzg
            int r7 = r1.zza()
            byte[] r1 = r2.zza(r3, r4, r5, r6, r7, r8)
            com.google.android.gms.internal.firebase-auth-api.zzyh r2 = r9.zzf
            com.google.android.gms.internal.firebase-auth-api.zzmg r1 = r2.zzb(r1)
            byte[] r10 = java.util.Arrays.copyOfRange(r10, r11, r0)
            byte[] r11 = zza
            byte[] r10 = r1.zza(r10, r11)
            return r10
        L_0x0047:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            java.lang.String r11 = "ciphertext too short"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzyi.zza(byte[], byte[]):byte[]");
    }
}
