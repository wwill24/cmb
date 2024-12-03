package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.charset.Charset;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpd  reason: invalid package */
public final class zzpd {
    public static final Charset zza = Charset.forName("UTF-8");

    public static int zza() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b10 = 0;
        while (b10 == 0) {
            secureRandom.nextBytes(bArr);
            b10 = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return b10;
    }

    public static final zzzo zzb(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt < '!' || charAt > '~') {
                throw new zzpc("Not a printable ASCII character: " + charAt);
            }
            bArr[i10] = (byte) charAt;
        }
        return zzzo.zzb(bArr);
    }
}
