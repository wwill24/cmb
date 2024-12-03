package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrl  reason: invalid package */
public final class zzrl implements zzcd {
    private static final byte[] zza = {0};
    private final zzcd zzb;
    private final zzxo zzc;
    private final byte[] zzd;

    private zzrl(zzcd zzcd, zzxo zzxo, byte[] bArr) {
        this.zzb = zzcd;
        this.zzc = zzxo;
        this.zzd = bArr;
    }

    public static zzcd zzb(zzni zzni) throws GeneralSecurityException {
        byte[] bArr;
        zzoo zza2 = zzni.zza(zzbm.zza());
        zzwf zza3 = zzwi.zza();
        zza3.zzb(zza2.zzg());
        zza3.zzc(zza2.zze());
        zza3.zza(zza2.zzb());
        zzcd zzcd = (zzcd) zzcq.zzd((zzwi) zza3.zzi(), zzcd.class);
        zzxo zzc2 = zza2.zzc();
        zzxo zzxo = zzxo.UNKNOWN_PREFIX;
        int ordinal = zzc2.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    bArr = new byte[0];
                } else if (ordinal != 4) {
                    throw new GeneralSecurityException("unknown output prefix type");
                }
            }
            bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzni.zzb().intValue()).array();
        } else {
            bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzni.zzb().intValue()).array();
        }
        return new zzrl(zzcd, zzc2, bArr);
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length >= 10) {
            if (this.zzc.equals(zzxo.LEGACY)) {
                bArr2 = zzyf.zzb(bArr2, zza);
            }
            byte[] bArr3 = new byte[0];
            if (!this.zzc.equals(zzxo.RAW)) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                bArr = Arrays.copyOfRange(bArr, 5, length);
                bArr3 = copyOf;
            }
            if (Arrays.equals(this.zzd, bArr3)) {
                this.zzb.zza(bArr, bArr2);
                return;
            }
            throw new GeneralSecurityException("wrong prefix");
        }
        throw new GeneralSecurityException("tag too short");
    }
}
