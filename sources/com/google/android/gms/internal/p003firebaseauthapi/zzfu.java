package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfu  reason: invalid package */
final class zzfu {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzob zzc;
    private static final zznx zzd;
    private static final zzne zze;
    private static final zzna zzf;

    static {
        Class<zzoo> cls = zzoo.class;
        Class<zzop> cls2 = zzop.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzb2;
        zzc = zzob.zzb(zzfq.zza, zzfp.class, cls2);
        zzd = zznx.zzb(zzfr.zza, zzb2, cls2);
        zze = zzne.zza(zzfs.zza, zzfh.class, cls);
        zzf = zzna.zzb(zzft.zza, zzb2, cls);
    }

    public static /* synthetic */ zzfh zza(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zztm zzd2 = zztm.zzd(zzoo.zze(), zzajx.zza());
                if (zzd2.zza() == 0) {
                    zzfm zzfm = new zzfm((zzfl) null);
                    zzfm.zza(zzd2.zze().zzd());
                    zzfm.zzb(zzd(zzoo.zzc()));
                    zzfp zzc2 = zzfm.zzc();
                    zzff zzff = new zzff((zzfe) null);
                    zzff.zzc(zzc2);
                    zzff.zzb(zzzq.zzb(zzd2.zze().zzq(), zzcr));
                    zzff.zza(zzoo.zzf());
                    return zzff.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzfp zzb(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zztp zze2 = zztp.zze(zzop.zzc().zzf(), zzajx.zza());
                if (zze2.zzb() == 0) {
                    zzfm zzfm = new zzfm((zzfl) null);
                    zzfm.zza(zze2.zza());
                    zzfm.zzb(zzd(zzop.zzc().zze()));
                    return zzfm.zzc();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static void zzc(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzc);
        zznt.zzg(zzd);
        zznt.zzf(zze);
        zznt.zze(zzf);
    }

    private static zzfn zzd(zzxo zzxo) throws GeneralSecurityException {
        zzxo zzxo2 = zzxo.UNKNOWN_PREFIX;
        int ordinal = zzxo.ordinal();
        if (ordinal == 1) {
            return zzfn.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzfn.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzxo.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzfn.zzb;
    }
}
