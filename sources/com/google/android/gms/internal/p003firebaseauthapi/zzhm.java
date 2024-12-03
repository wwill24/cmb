package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhm  reason: invalid package */
public final class zzhm extends zzcv {
    private final zzhr zza;
    private final zzzq zzb;
    private final zzzo zzc;
    private final Integer zzd;

    private zzhm(zzhr zzhr, zzzq zzzq, zzzo zzzo, Integer num) {
        this.zza = zzhr;
        this.zzb = zzzq;
        this.zzc = zzzo;
        this.zzd = num;
    }

    public static zzhm zza(zzhq zzhq, zzzq zzzq, Integer num) throws GeneralSecurityException {
        zzzo zzzo;
        zzhq zzhq2 = zzhq.zzc;
        if (zzhq != zzhq2 && num == null) {
            String obj = zzhq.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzhq == zzhq2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzzq.zza() == 32) {
            zzhr zzd2 = zzhr.zzd(zzhq);
            if (zzd2.zzb() == zzhq2) {
                zzzo = zzzo.zzb(new byte[0]);
            } else if (zzd2.zzb() == zzhq.zzb) {
                zzzo = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzd2.zzb() == zzhq.zza) {
                zzzo = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzd2.zzb().toString()));
            }
            return new zzhm(zzd2, zzzq, zzzo, num);
        } else {
            int zza2 = zzzq.zza();
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
        }
    }
}
