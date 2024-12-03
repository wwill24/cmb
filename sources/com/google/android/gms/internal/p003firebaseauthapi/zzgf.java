package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgf  reason: invalid package */
final class zzgf {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzob zzc;
    private static final zznx zzd;
    private static final zzne zze;
    private static final zzna zzf;

    static {
        Class<zzoo> cls = zzoo.class;
        Class<zzop> cls2 = zzop.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zzb2;
        zzc = zzob.zzb(zzgb.zza, zzga.class, cls2);
        zzd = zznx.zzb(zzgc.zza, zzb2, cls2);
        zze = zzne.zza(zzgd.zza, zzfv.class, cls);
        zzf = zzna.zzb(zzge.zza, zzb2, cls);
    }

    public static /* synthetic */ zzfv zza(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzty zzd2 = zzty.zzd(zzoo.zze(), zzajx.zza());
                if (zzd2.zza() == 0) {
                    return zzfv.zza(zzd(zzoo.zzc()), zzzq.zzb(zzd2.zze().zzq(), zzcr), zzoo.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzga zzb(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzub.zzc(zzop.zzc().zzf(), zzajx.zza());
                return zzga.zzc(zzd(zzop.zzc().zze()));
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static void zzc(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzc);
        zznt.zzg(zzd);
        zznt.zzf(zze);
        zznt.zze(zzf);
    }

    private static zzfz zzd(zzxo zzxo) throws GeneralSecurityException {
        zzxo zzxo2 = zzxo.UNKNOWN_PREFIX;
        int ordinal = zzxo.ordinal();
        if (ordinal == 1) {
            return zzfz.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzfz.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzxo.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzfz.zzb;
    }
}
