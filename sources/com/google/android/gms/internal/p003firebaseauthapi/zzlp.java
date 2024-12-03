package com.google.android.gms.internal.p003firebaseauthapi;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlp  reason: invalid package */
public final class zzlp {
    private static final byte[] zza = new byte[0];
    private final zzlo zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private BigInteger zzg = BigInteger.ZERO;

    private zzlp(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzlo zzlo) {
        this.zzf = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzlo;
    }

    static zzlp zza(byte[] bArr, byte[] bArr2, byte[] bArr3, zzlt zzlt, zzls zzls, zzlo zzlo, byte[] bArr4) throws GeneralSecurityException {
        zzls zzls2 = zzls;
        byte[] zzc2 = zzmb.zzc(zzlt.zzb(), zzls.zzc(), zzlo.zzb());
        byte[] bArr5 = zzmb.zzm;
        byte[] bArr6 = zza;
        byte[] zzb2 = zzyf.zzb(bArr, zzls2.zze(bArr5, bArr6, "psk_id_hash", zzc2), zzls2.zze(bArr5, bArr4, "info_hash", zzc2));
        zzls zzls3 = zzls;
        byte[] zze2 = zzls2.zze(bArr3, bArr6, "secret", zzc2);
        byte[] bArr7 = zzb2;
        byte[] bArr8 = zzc2;
        byte[] zzd2 = zzls3.zzd(zze2, bArr7, SDKConstants.PARAM_KEY, bArr8, zzlo.zza());
        byte[] zzd3 = zzls3.zzd(zze2, bArr7, "base_nonce", bArr8, 12);
        BigInteger bigInteger = BigInteger.ONE;
        return new zzlp(bArr2, zzd2, zzd3, bigInteger.shiftLeft(96).subtract(bigInteger), zzlo);
    }

    private final synchronized byte[] zzc() throws GeneralSecurityException {
        byte[] zzc2;
        zzc2 = zzyf.zzc(this.zze, zzmn.zzc(this.zzg, 12));
        if (this.zzg.compareTo(this.zzc) < 0) {
            this.zzg = this.zzg.add(BigInteger.ONE);
        } else {
            throw new GeneralSecurityException("message limit reached");
        }
        return zzc2;
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zzc(this.zzd, zzc(), bArr, bArr2);
    }
}
