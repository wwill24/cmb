package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzop  reason: invalid package */
public final class zzop implements zzot {
    private final zzzo zza;
    private final zzwn zzb;

    private zzop(zzwn zzwn, zzzo zzzo) {
        this.zzb = zzwn;
        this.zza = zzzo;
    }

    public static zzop zza(zzwn zzwn) throws GeneralSecurityException {
        String zzg = zzwn.zzg();
        Charset charset = zzpd.zza;
        byte[] bArr = new byte[zzg.length()];
        for (int i10 = 0; i10 < zzg.length(); i10++) {
            char charAt = zzg.charAt(i10);
            if (charAt < '!' || charAt > '~') {
                throw new GeneralSecurityException("Not a printable ASCII character: " + charAt);
            }
            bArr[i10] = (byte) charAt;
        }
        return new zzop(zzwn, zzzo.zzb(bArr));
    }

    public static zzop zzb(zzwn zzwn) {
        return new zzop(zzwn, zzpd.zzb(zzwn.zzg()));
    }

    public final zzwn zzc() {
        return this.zzb;
    }

    public final zzzo zzd() {
        return this.zza;
    }
}
