package com.google.android.gms.internal.p003firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import net.bytebuddy.jar.asm.Opcodes;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzky  reason: invalid package */
public final class zzky {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzzo zzc;
    private static final zzob zzd;
    private static final zznx zze;
    private static final zzne zzf;
    private static final zzna zzg;
    private static final zzne zzh;
    private static final zzna zzi;
    private static final zzmu zzj;
    private static final zzmu zzk;
    private static final zzmu zzl;
    private static final zzmu zzm;

    static {
        Class<zzop> cls = zzop.class;
        Class<zzoo> cls2 = zzoo.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zzb = zzb2;
        zzzo zzb3 = zzpd.zzb("type.googleapis.com/google.crypto.tink.HpkePublicKey");
        zzc = zzb3;
        zzd = zzob.zzb(zzks.zza, zzkq.class, cls);
        zze = zznx.zzb(zzkt.zza, zzb2, cls);
        zzf = zzne.zza(zzku.zza, zzkz.class, cls2);
        zzg = zzna.zzb(zzkv.zza, zzb3, cls2);
        zzh = zzne.zza(zzkw.zza, zzkr.class, cls2);
        zzi = zzna.zzb(zzkx.zza, zzb2, cls2);
        zzms zza2 = zzmu.zza();
        zza2.zza(zzxo.RAW, zzko.zzc);
        zza2.zza(zzxo.TINK, zzko.zza);
        zzxo zzxo = zzxo.LEGACY;
        zzko zzko = zzko.zzb;
        zza2.zza(zzxo, zzko);
        zza2.zza(zzxo.CRUNCHY, zzko);
        zzj = zza2.zzb();
        zzms zza3 = zzmu.zza();
        zza3.zza(zzvr.DHKEM_P256_HKDF_SHA256, zzkn.zza);
        zza3.zza(zzvr.DHKEM_P384_HKDF_SHA384, zzkn.zzb);
        zza3.zza(zzvr.DHKEM_P521_HKDF_SHA512, zzkn.zzc);
        zza3.zza(zzvr.DHKEM_X25519_HKDF_SHA256, zzkn.zzf);
        zzk = zza3.zzb();
        zzms zza4 = zzmu.zza();
        zza4.zza(zzvp.HKDF_SHA256, zzkm.zza);
        zza4.zza(zzvp.HKDF_SHA384, zzkm.zzb);
        zza4.zza(zzvp.HKDF_SHA512, zzkm.zzc);
        zzl = zza4.zzb();
        zzms zza5 = zzmu.zza();
        zza5.zza(zzvn.AES_128_GCM, zzkh.zza);
        zza5.zza(zzvn.AES_256_GCM, zzkh.zzb);
        zza5.zza(zzvn.CHACHA20_POLY1305, zzkh.zzc);
        zzm = zza5.zzb();
    }

    public static /* synthetic */ zzkq zza(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            try {
                return zzf(zzop.zzc().zze(), zzvu.zzc(zzop.zzc().zzf(), zzajx.zza()).zzd());
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static /* synthetic */ zzkr zzb(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            try {
                zzwa zzd2 = zzwa.zzd(zzoo.zze(), zzajx.zza());
                if (zzd2.zza() == 0) {
                    zzwd zze2 = zzd2.zze();
                    return zzkr.zza(zzkz.zzb(zzf(zzoo.zzc(), zze2.zzb()), zzg(zze2.zzb().zzc(), zze2.zzg().zzq()), zzoo.zzf()), zzzq.zzb(zzmn.zzc(zzmn.zza(zzd2.zzf().zzq()), zzmb.zza(zze2.zzb().zzc())), zzcr));
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks unused) {
                throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: ".concat(String.valueOf(zzoo.zzg())));
        }
    }

    public static /* synthetic */ zzkz zzc(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.HpkePublicKey")) {
            try {
                zzwd zzf2 = zzwd.zzf(zzoo.zze(), zzajx.zza());
                if (zzf2.zza() == 0) {
                    return zzkz.zzb(zzf(zzoo.zzc(), zzf2.zzb()), zzg(zzf2.zzb().zzc(), zzf2.zzg().zzq()), zzoo.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks unused) {
                throw new GeneralSecurityException("Parsing HpkePublicKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: ".concat(String.valueOf(zzoo.zzg())));
        }
    }

    public static /* synthetic */ zzop zzd(zzkq zzkq) {
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zzvt zza3 = zzvu.zza();
        zzvw zzd2 = zzvx.zzd();
        zzd2.zzc((zzvr) zzk.zzb(zzkq.zze()));
        zzd2.zzb((zzvp) zzl.zzb(zzkq.zzd()));
        zzd2.zza((zzvn) zzm.zzb(zzkq.zzb()));
        zza3.zza((zzvx) zzd2.zzi());
        zza2.zzc(((zzvu) zza3.zzi()).zzo());
        zza2.zza((zzxo) zzj.zzb(zzkq.zzf()));
        return zzop.zzb((zzwn) zza2.zzi());
    }

    public static void zze(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzd);
        zznt.zzg(zze);
        zznt.zzf(zzf);
        zznt.zze(zzg);
        zznt.zzf(zzh);
        zznt.zze(zzi);
    }

    private static zzkq zzf(zzxo zzxo, zzvx zzvx) throws GeneralSecurityException {
        zzkl zzkl = new zzkl((zzkk) null);
        zzkl.zzd((zzko) zzj.zzc(zzxo));
        zzkl.zzc((zzkn) zzk.zzc(zzvx.zzc()));
        zzkl.zzb((zzkm) zzl.zzc(zzvx.zzb()));
        zzkl.zza((zzkh) zzm.zzc(zzvx.zza()));
        return zzkl.zze();
    }

    private static zzzo zzg(zzvr zzvr, byte[] bArr) throws GeneralSecurityException {
        int i10;
        BigInteger zza2 = zzmn.zza(bArr);
        byte[] bArr2 = zzmb.zza;
        zzvr zzvr2 = zzvr.KEM_UNKNOWN;
        int ordinal = zzvr.ordinal();
        if (ordinal == 1) {
            i10 = 32;
        } else if (ordinal == 2) {
            i10 = 65;
        } else if (ordinal == 3) {
            i10 = 97;
        } else if (ordinal == 4) {
            i10 = Opcodes.I2L;
        } else {
            throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
        }
        return zzzo.zzb(zzmn.zzc(zza2, i10));
    }
}
