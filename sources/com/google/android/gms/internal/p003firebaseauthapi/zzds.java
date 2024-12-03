package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzds  reason: invalid package */
final class zzds {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzob zzc;
    private static final zznx zzd;
    private static final zzne zze;
    private static final zzna zzf;

    static {
        Class<zzoo> cls = zzoo.class;
        Class<zzop> cls2 = zzop.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzb2;
        zzc = zzob.zzb(zzdo.zza, zzdn.class, cls2);
        zzd = zznx.zzb(zzdp.zza, zzb2, cls2);
        zze = zzne.zza(zzdq.zza, zzde.class, cls);
        zzf = zzna.zzb(zzdr.zza, zzb2, cls);
    }

    public static /* synthetic */ zzde zza(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzsi zzd2 = zzsi.zzd(zzoo.zze(), zzajx.zza());
                if (zzd2.zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                } else if (zzd2.zze().zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                } else if (zzd2.zzf().zza() == 0) {
                    zzdj zzdj = new zzdj((zzdi) null);
                    zzdj.zza(zzd2.zze().zzg().zzd());
                    zzdj.zzc(zzd2.zzf().zzg().zzd());
                    zzdj.zzd(zzd2.zze().zzf().zza());
                    zzdj.zze(zzd2.zzf().zzf().zza());
                    zzdj.zzb(zzd(zzd2.zzf().zzf().zzb()));
                    zzdj.zzf(zze(zzoo.zzc()));
                    zzdn zzg = zzdj.zzg();
                    zzdc zzdc = new zzdc((zzdb) null);
                    zzdc.zzd(zzg);
                    zzdc.zza(zzzq.zzb(zzd2.zze().zzg().zzq(), zzcr));
                    zzdc.zzb(zzzq.zzb(zzd2.zzf().zzg().zzq(), zzcr));
                    zzdc.zzc(zzoo.zzf());
                    return zzdc.zze();
                } else {
                    throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                }
            } catch (zzaks unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzdn zzb(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzsl zzc2 = zzsl.zzc(zzop.zzc().zzf(), zzajx.zza());
                if (zzc2.zze().zzb() == 0) {
                    zzdj zzdj = new zzdj((zzdi) null);
                    zzdj.zza(zzc2.zzd().zza());
                    zzdj.zzc(zzc2.zze().zza());
                    zzdj.zzd(zzc2.zzd().zzf().zza());
                    zzdj.zze(zzc2.zze().zzg().zza());
                    zzdj.zzb(zzd(zzc2.zze().zzg().zzb()));
                    zzdj.zzf(zze(zzop.zzc().zze()));
                    return zzdj.zzg();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static void zzc(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzc);
        zznt.zzg(zzd);
        zznt.zzf(zze);
        zznt.zze(zzf);
    }

    private static zzdk zzd(zzvc zzvc) throws GeneralSecurityException {
        zzvc zzvc2 = zzvc.UNKNOWN_HASH;
        zzxo zzxo = zzxo.UNKNOWN_PREFIX;
        int ordinal = zzvc.ordinal();
        if (ordinal == 1) {
            return zzdk.zza;
        }
        if (ordinal == 2) {
            return zzdk.zzd;
        }
        if (ordinal == 3) {
            return zzdk.zzc;
        }
        if (ordinal == 4) {
            return zzdk.zze;
        }
        if (ordinal == 5) {
            return zzdk.zzb;
        }
        int zza2 = zzvc.zza();
        throw new GeneralSecurityException("Unable to parse HashType: " + zza2);
    }

    private static zzdl zze(zzxo zzxo) throws GeneralSecurityException {
        zzvc zzvc = zzvc.UNKNOWN_HASH;
        zzxo zzxo2 = zzxo.UNKNOWN_PREFIX;
        int ordinal = zzxo.ordinal();
        if (ordinal == 1) {
            return zzdl.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzdl.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzxo.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzdl.zzb;
    }
}
