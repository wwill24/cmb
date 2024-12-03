package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import net.bytebuddy.jar.asm.Opcodes;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlq  reason: invalid package */
final class zzlq implements zzbk {
    private static final byte[] zza = new byte[0];
    private final zzlu zzb;
    private final zzlt zzc;
    private final zzls zzd;
    private final zzlo zze;
    private final int zzf;

    private zzlq(zzlu zzlu, zzlt zzlt, zzls zzls, zzlo zzlo, int i10) {
        this.zzb = zzlu;
        this.zzc = zzlt;
        this.zzd = zzls;
        this.zze = zzlo;
        this.zzf = i10;
    }

    static zzlq zzb(zzwa zzwa) throws GeneralSecurityException {
        int i10;
        zzlu zzlu;
        if (!zzwa.zzk()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        } else if (!zzwa.zze().zzl()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        } else if (!zzwa.zzf().zzp()) {
            zzvx zzb2 = zzwa.zze().zzb();
            zzlt zzc2 = zzlv.zzc(zzb2);
            zzls zzb3 = zzlv.zzb(zzb2);
            zzlo zza2 = zzlv.zza(zzb2);
            zzvr zzc3 = zzb2.zzc();
            zzvr zzvr = zzvr.KEM_UNKNOWN;
            int ordinal = zzc3.ordinal();
            if (ordinal == 1) {
                i10 = 32;
            } else if (ordinal == 2) {
                i10 = 65;
            } else if (ordinal == 3) {
                i10 = 97;
            } else if (ordinal == 4) {
                i10 = Opcodes.I2L;
            } else {
                throw new IllegalArgumentException("Unable to determine KEM-encoding length for ".concat(String.valueOf(zzc3.name())));
            }
            int ordinal2 = zzwa.zze().zzb().zzc().ordinal();
            if (ordinal2 == 1) {
                zzlu = zzmf.zzc(zzwa.zzf().zzq());
            } else if (ordinal2 == 2 || ordinal2 == 3 || ordinal2 == 4) {
                zzlu = zzmd.zzc(zzwa.zzf().zzq(), zzwa.zze().zzg().zzq(), zzmb.zzh(zzwa.zze().zzb().zzc()));
            } else {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            return new zzlq(zzlu, zzc2, zzb3, zza2, i10);
        } else {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.zzf;
        if (length >= i10) {
            byte[] copyOf = Arrays.copyOf(bArr, i10);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzf, length);
            zzlu zzlu = this.zzb;
            zzlt zzlt = this.zzc;
            zzls zzls = this.zzd;
            zzlo zzlo = this.zze;
            byte[] zza2 = zzlt.zza(copyOf, zzlu);
            return zzlp.zza(zzmb.zza, copyOf, zza2, zzlt, zzls, zzlo, new byte[0]).zzb(copyOfRange, zza);
        }
        throw new GeneralSecurityException("Ciphertext is too short.");
    }
}
