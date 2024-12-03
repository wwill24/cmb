package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzem  reason: invalid package */
final class zzem {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzob zzc;
    private static final zznx zzd;
    private static final zzne zze;
    private static final zzna zzf;

    static {
        Class<zzoo> cls = zzoo.class;
        Class<zzop> cls2 = zzop.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzb2;
        zzc = zzob.zzb(zzei.zza, zzeh.class, cls2);
        zzd = zznx.zzb(zzej.zza, zzb2, cls2);
        zze = zzne.zza(zzek.zza, zzdz.class, cls);
        zzf = zzna.zzb(zzel.zza, zzb2, cls);
    }

    public static /* synthetic */ zzdz zza(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzsx zzd2 = zzsx.zzd(zzoo.zze(), zzajx.zza());
                if (zzd2.zza() == 0) {
                    zzee zzee = new zzee((zzed) null);
                    zzee.zzb(zzd2.zzf().zzd());
                    zzee.zza(zzd2.zze().zza());
                    zzee.zzc(16);
                    zzee.zzd(zzd(zzoo.zzc()));
                    zzeh zze2 = zzee.zze();
                    zzdx zzdx = new zzdx((zzdw) null);
                    zzdx.zzc(zze2);
                    zzdx.zzb(zzzq.zzb(zzd2.zzf().zzq(), zzcr));
                    zzdx.zza(zzoo.zzf());
                    return zzdx.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzeh zzb(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzta zzd2 = zzta.zzd(zzop.zzc().zzf(), zzajx.zza());
                zzee zzee = new zzee((zzed) null);
                zzee.zzb(zzd2.zza());
                zzee.zza(zzd2.zze().zza());
                zzee.zzc(16);
                zzee.zzd(zzd(zzop.zzc().zze()));
                return zzee.zze();
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static void zzc(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzc);
        zznt.zzg(zzd);
        zznt.zzf(zze);
        zznt.zze(zzf);
    }

    private static zzef zzd(zzxo zzxo) throws GeneralSecurityException {
        zzxo zzxo2 = zzxo.UNKNOWN_PREFIX;
        int ordinal = zzxo.ordinal();
        if (ordinal == 1) {
            return zzef.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzef.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzxo.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzef.zzb;
    }
}
