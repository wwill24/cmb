package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;
import net.bytebuddy.jar.asm.Opcodes;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkz  reason: invalid package */
public final class zzkz extends zzli {
    private final zzkq zza;
    private final zzzo zzb;
    private final zzzo zzc;
    private final Integer zzd;

    private zzkz(zzkq zzkq, zzzo zzzo, zzzo zzzo2, Integer num) {
        this.zza = zzkq;
        this.zzb = zzzo;
        this.zzc = zzzo2;
        this.zzd = num;
    }

    public static zzkz zzb(zzkq zzkq, zzzo zzzo, Integer num) throws GeneralSecurityException {
        zzzo zzzo2;
        EllipticCurve ellipticCurve;
        zzko zzf = zzkq.zzf();
        zzko zzko = zzko.zzc;
        if (!zzf.equals(zzko) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + zzf.toString() + " variant.");
        } else if (!zzf.equals(zzko) || num == null) {
            zzkn zze = zzkq.zze();
            int zza2 = zzzo.zza();
            String str = "Encoded public key byte length for " + zze.toString() + " must be %d, not " + zza2;
            zzkn zzkn = zzkn.zza;
            if (zze == zzkn) {
                if (zza2 != 65) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{65}));
                }
            } else if (zze == zzkn.zzb) {
                if (zza2 != 97) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{97}));
                }
            } else if (zze == zzkn.zzc) {
                if (zza2 != 133) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{Integer.valueOf(Opcodes.I2L)}));
                }
            } else if (zze != zzkn.zzf) {
                throw new GeneralSecurityException("Unable to validate public key length for ".concat(zze.toString()));
            } else if (zza2 != 32) {
                throw new GeneralSecurityException(String.format(str, new Object[]{32}));
            }
            if (zze == zzkn || zze == zzkn.zzb || zze == zzkn.zzc) {
                if (zze == zzkn) {
                    ellipticCurve = zzmq.zza.getCurve();
                } else if (zze == zzkn.zzb) {
                    ellipticCurve = zzmq.zzb.getCurve();
                } else if (zze == zzkn.zzc) {
                    ellipticCurve = zzmq.zzc.getCurve();
                } else {
                    throw new IllegalArgumentException("Unable to determine NIST curve type for ".concat(zze.toString()));
                }
                zzmq.zzf(zzym.zzj(ellipticCurve, 1, zzzo.zzc()), ellipticCurve);
            }
            zzko zzf2 = zzkq.zzf();
            if (zzf2 == zzko) {
                zzzo2 = zzzo.zzb(new byte[0]);
            } else if (num == null) {
                throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant ".concat(zzf2.toString()));
            } else if (zzf2 == zzko.zzb) {
                zzzo2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzf2 == zzko.zza) {
                zzzo2 = zzzo.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown HpkeParameters.Variant: ".concat(zzf2.toString()));
            }
            return new zzkz(zzkq, zzzo, zzzo2, num);
        } else {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
    }

    public final zzkq zza() {
        return this.zza;
    }

    public final zzzo zzc() {
        return this.zzb;
    }
}
