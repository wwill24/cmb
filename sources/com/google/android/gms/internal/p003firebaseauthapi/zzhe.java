package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhe  reason: invalid package */
public final class zzhe {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzob zzc;
    private static final zznx zzd;
    private static final zzne zze;
    private static final zzna zzf;

    static {
        Class<zzoo> cls = zzoo.class;
        Class<zzop> cls2 = zzop.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zzb2;
        zzc = zzob.zzb(zzha.zza, zzgz.class, cls2);
        zzd = zznx.zzb(zzhb.zza, zzb2, cls2);
        zze = zzne.zza(zzhc.zza, zzgu.class, cls);
        zzf = zzna.zzb(zzhd.zza, zzb2, cls);
    }

    public static /* synthetic */ zzgu zza(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                zzxj zzd2 = zzxj.zzd(zzoo.zze(), zzajx.zza());
                if (zzoo.zzc() != zzxo.RAW) {
                    String valueOf = String.valueOf(zzd2);
                    throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with OutputPrefixType RAW, got " + valueOf);
                } else if (zzd2.zza() == 0) {
                    return zzgu.zza(zzd(zzd2.zze()));
                } else {
                    String valueOf2 = String.valueOf(zzd2);
                    throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + valueOf2);
                }
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgz zzb(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                return zzd(zzxm.zze(zzop.zzc().zzf(), zzajx.zza()));
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static void zzc(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzc);
        zznt.zzg(zzd);
        zznt.zzf(zze);
        zznt.zze(zzf);
    }

    private static zzgz zzd(zzxm zzxm) throws GeneralSecurityException {
        zzgx zzgx;
        zzwm zza2 = zzwn.zza();
        zza2.zzb(zzxm.zza().zzg());
        zza2.zzc(zzxm.zza().zzf());
        zza2.zza(zzxo.RAW);
        zzce zza3 = zzcs.zza(((zzwn) zza2.zzi()).zzq());
        if (zza3 instanceof zzey) {
            zzgx = zzgx.zza;
        } else if (zza3 instanceof zzga) {
            zzgx = zzgx.zzc;
        } else if (zza3 instanceof zzhr) {
            zzgx = zzgx.zzb;
        } else if (zza3 instanceof zzdn) {
            zzgx = zzgx.zzd;
        } else if (zza3 instanceof zzeh) {
            zzgx = zzgx.zze;
        } else if (zza3 instanceof zzfp) {
            zzgx = zzgx.zzf;
        } else {
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zza3.toString()));
        }
        zzgw zzgw = new zzgw((zzgv) null);
        zzgw.zzc(zzxm.zzf());
        zzgw.zza((zzcx) zza3);
        zzgw.zzb(zzgx);
        return zzgw.zzd();
    }
}
