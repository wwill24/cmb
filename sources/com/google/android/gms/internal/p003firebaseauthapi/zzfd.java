package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfd  reason: invalid package */
final class zzfd {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzob zzc;
    private static final zznx zzd;
    private static final zzne zze;
    private static final zzna zzf;

    static {
        Class<zzoo> cls = zzoo.class;
        Class<zzop> cls2 = zzop.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzb2;
        zzc = zzob.zzb(zzez.zza, zzey.class, cls2);
        zzd = zznx.zzb(zzfa.zza, zzb2, cls2);
        zze = zzne.zza(zzfb.zza, zzeq.class, cls);
        zzf = zzna.zzb(zzfc.zza, zzb2, cls);
    }

    public static /* synthetic */ zzeq zza(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zztg zzd2 = zztg.zzd(zzoo.zze(), zzajx.zza());
                if (zzd2.zza() == 0) {
                    zzev zzev = new zzev((zzeu) null);
                    zzev.zzb(zzd2.zze().zzd());
                    zzev.zza(12);
                    zzev.zzc(16);
                    zzev.zzd(zzd(zzoo.zzc()));
                    zzey zze2 = zzev.zze();
                    zzeo zzeo = new zzeo((zzen) null);
                    zzeo.zzc(zze2);
                    zzeo.zzb(zzzq.zzb(zzd2.zze().zzq(), zzcr));
                    zzeo.zza(zzoo.zzf());
                    return zzeo.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzey zzb(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zztj zze2 = zztj.zze(zzop.zzc().zzf(), zzajx.zza());
                if (zze2.zzb() == 0) {
                    zzev zzev = new zzev((zzeu) null);
                    zzev.zzb(zze2.zza());
                    zzev.zza(12);
                    zzev.zzc(16);
                    zzev.zzd(zzd(zzop.zzc().zze()));
                    return zzev.zze();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static void zzc(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzc);
        zznt.zzg(zzd);
        zznt.zzf(zze);
        zznt.zze(zzf);
    }

    private static zzew zzd(zzxo zzxo) throws GeneralSecurityException {
        zzxo zzxo2 = zzxo.UNKNOWN_PREFIX;
        int ordinal = zzxo.ordinal();
        if (ordinal == 1) {
            return zzew.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzew.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzxo.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzew.zzb;
    }
}
