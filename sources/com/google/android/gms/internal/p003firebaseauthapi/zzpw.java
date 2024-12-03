package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpw  reason: invalid package */
final class zzpw {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzob zzc;
    private static final zznx zzd;
    private static final zzne zze;
    private static final zzna zzf;

    static {
        Class<zzoo> cls = zzoo.class;
        Class<zzop> cls2 = zzop.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzb2;
        zzc = zzob.zzb(zzps.zza, zzpr.class, cls2);
        zzd = zznx.zzb(zzpt.zza, zzb2, cls2);
        zze = zzne.zza(zzpu.zza, zzph.class, cls);
        zzf = zzna.zzb(zzpv.zza, zzb2, cls);
    }

    public static /* synthetic */ zzph zza(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzrz zzd2 = zzrz.zzd(zzoo.zze(), zzajx.zza());
                if (zzd2.zza() == 0) {
                    zzpo zzpo = new zzpo((zzpn) null);
                    zzpo.zza(zzd2.zzf().zzd());
                    zzpo.zzb(zzd2.zze().zza());
                    zzpo.zzc(zzd(zzoo.zzc()));
                    zzpr zzd3 = zzpo.zzd();
                    zzpf zzpf = new zzpf((zzpe) null);
                    zzpf.zzc(zzd3);
                    zzpf.zza(zzzq.zzb(zzd2.zzf().zzq(), zzcr));
                    zzpf.zzb(zzoo.zzf());
                    return zzpf.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzpr zzb(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzsc zzd2 = zzsc.zzd(zzop.zzc().zzf(), zzajx.zza());
                zzpo zzpo = new zzpo((zzpn) null);
                zzpo.zza(zzd2.zza());
                zzpo.zzb(zzd2.zze().zza());
                zzpo.zzc(zzd(zzop.zzc().zze()));
                return zzpo.zzd();
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static void zzc(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzc);
        zznt.zzg(zzd);
        zznt.zzf(zze);
        zznt.zze(zzf);
    }

    private static zzpp zzd(zzxo zzxo) throws GeneralSecurityException {
        zzxo zzxo2 = zzxo.UNKNOWN_PREFIX;
        int ordinal = zzxo.ordinal();
        if (ordinal == 1) {
            return zzpp.zza;
        }
        if (ordinal == 2) {
            return zzpp.zzc;
        }
        if (ordinal == 3) {
            return zzpp.zzd;
        }
        if (ordinal == 4) {
            return zzpp.zzb;
        }
        int zza2 = zzxo.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }
}
