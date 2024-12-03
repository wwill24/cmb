package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkf  reason: invalid package */
final class zzkf {
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
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zzb = zzb2;
        zzzo zzb3 = zzpd.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
        zzc = zzb3;
        zzd = zzob.zzb(zzjz.zza, zzjx.class, cls);
        zze = zznx.zzb(zzka.zza, zzb2, cls);
        zzf = zzne.zza(zzkb.zza, zzkg.class, cls2);
        zzg = zzna.zzb(zzkc.zza, zzb3, cls2);
        zzh = zzne.zza(zzkd.zza, zzjy.class, cls2);
        zzi = zzna.zzb(zzke.zza, zzb2, cls2);
        zzms zza2 = zzmu.zza();
        zza2.zza(zzxo.RAW, zzjv.zzc);
        zza2.zza(zzxo.TINK, zzjv.zza);
        zzxo zzxo = zzxo.LEGACY;
        zzjv zzjv = zzjv.zzb;
        zza2.zza(zzxo, zzjv);
        zza2.zza(zzxo.CRUNCHY, zzjv);
        zzj = zza2.zzb();
        zzms zza3 = zzmu.zza();
        zza3.zza(zzvc.SHA1, zzjt.zza);
        zza3.zza(zzvc.SHA224, zzjt.zzb);
        zza3.zza(zzvc.SHA256, zzjt.zzc);
        zza3.zza(zzvc.SHA384, zzjt.zzd);
        zza3.zza(zzvc.SHA512, zzjt.zze);
        zzk = zza3.zzb();
        zzms zza4 = zzmu.zza();
        zza4.zza(zzux.NIST_P256, zzjs.zza);
        zza4.zza(zzux.NIST_P384, zzjs.zzb);
        zza4.zza(zzux.NIST_P521, zzjs.zzc);
        zza4.zza(zzux.CURVE25519, zzjs.zzd);
        zzl = zza4.zzb();
        zzms zza5 = zzmu.zza();
        zza5.zza(zzud.UNCOMPRESSED, zzju.zzb);
        zza5.zza(zzud.COMPRESSED, zzju.zza);
        zza5.zza(zzud.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzju.zzc);
        zzm = zza5.zzb();
    }

    public static /* synthetic */ zzjx zza(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            try {
                return zzf(zzop.zzc().zze(), zzuj.zzc(zzop.zzc().zzf(), zzajx.zza()).zzd());
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing EciesParameters failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static /* synthetic */ zzjy zzb(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            try {
                zzup zzd2 = zzup.zzd(zzoo.zze(), zzajx.zza());
                if (zzd2.zza() == 0) {
                    zzus zze2 = zzd2.zze();
                    zzjx zzf2 = zzf(zzoo.zzc(), zze2.zzb());
                    if (zzf2.zzc().equals(zzjs.zzd)) {
                        return zzjy.zza(zzkg.zzb(zzf2, zzzo.zzb(zze2.zzg().zzq()), zzoo.zzf()), zzzq.zzb(zzd2.zzf().zzq(), zzcr));
                    }
                    return zzjy.zzb(zzkg.zzc(zzf2, new ECPoint(zzmn.zza(zze2.zzg().zzq()), zzmn.zza(zze2.zzh().zzq())), zzoo.zzf()), zzzp.zza(zzmn.zza(zzd2.zzf().zzq()), zzcr));
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePrivateKey: ".concat(String.valueOf(zzoo.zzg())));
        }
    }

    public static /* synthetic */ zzkg zzc(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
            try {
                zzus zzf2 = zzus.zzf(zzoo.zze(), zzajx.zza());
                if (zzf2.zza() == 0) {
                    zzjx zzf3 = zzf(zzoo.zzc(), zzf2.zzb());
                    if (!zzf3.zzc().equals(zzjs.zzd)) {
                        return zzkg.zzc(zzf3, new ECPoint(zzmn.zza(zzf2.zzg().zzq()), zzmn.zza(zzf2.zzh().zzq())), zzoo.zzf());
                    }
                    if (zzf2.zzh().zzp()) {
                        return zzkg.zzb(zzf3, zzzo.zzb(zzf2.zzg().zzq()), zzoo.zzf());
                    }
                    throw new GeneralSecurityException("Y must be empty for X25519 points");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePublicKey: ".concat(String.valueOf(zzoo.zzg())));
        }
    }

    public static /* synthetic */ zzop zzd(zzjx zzjx) {
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zzui zza3 = zzuj.zza();
        zzuu zza4 = zzuv.zza();
        zza4.zza((zzux) zzl.zzb(zzjx.zzc()));
        zza4.zzb((zzvc) zzk.zzb(zzjx.zzd()));
        if (zzjx.zzg() != null && zzjx.zzg().zza() > 0) {
            byte[] zzc2 = zzjx.zzg().zzc();
            zza4.zzc(zzajf.zzn(zzc2, 0, zzc2.length));
        }
        zzuv zzuv = (zzuv) zza4.zzi();
        try {
            zzwn zzd2 = zzwn.zzd(zzcs.zzb(zzjx.zzb()), zzajx.zza());
            zzuf zza5 = zzug.zza();
            zzwm zza6 = zzwn.zza();
            zza6.zzb(zzd2.zzg());
            zza6.zza(zzxo.TINK);
            zza6.zzc(zzd2.zzf());
            zza5.zza((zzwn) zza6.zzi());
            zzug zzug = (zzug) zza5.zzi();
            zzju zze2 = zzjx.zze();
            if (zze2 == null) {
                zze2 = zzju.zza;
            }
            zzul zzc3 = zzum.zzc();
            zzc3.zzc(zzuv);
            zzc3.zza(zzug);
            zzc3.zzb((zzud) zzm.zzb(zze2));
            zza3.zza((zzum) zzc3.zzi());
            zza2.zzc(((zzuj) zza3.zzi()).zzo());
            zza2.zza((zzxo) zzj.zzb(zzjx.zzf()));
            return zzop.zzb((zzwn) zza2.zzi());
        } catch (zzaks e10) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e10);
        }
    }

    public static void zze(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzd);
        zznt.zzg(zze);
        zznt.zzf(zzf);
        zznt.zze(zzg);
        zznt.zzf(zzh);
        zznt.zze(zzi);
    }

    private static zzjx zzf(zzxo zzxo, zzum zzum) throws GeneralSecurityException {
        zzwm zza2 = zzwn.zza();
        zza2.zzb(zzum.zzb().zzd().zzg());
        zza2.zza(zzxo.RAW);
        zza2.zzc(zzum.zzb().zzd().zzf());
        zzjr zzjr = new zzjr((zzjq) null);
        zzjr.zzf((zzjv) zzj.zzc(zzxo));
        zzjr.zza((zzjs) zzl.zzc(zzum.zzf().zzd()));
        zzjr.zzc((zzjt) zzk.zzc(zzum.zzf().zze()));
        zzjr.zzb(zzcs.zza(((zzwn) zza2.zzi()).zzq()));
        zzjr.zze(zzzo.zzb(zzum.zzf().zzf().zzq()));
        if (!zzum.zzf().zzd().equals(zzux.CURVE25519)) {
            zzjr.zzd((zzju) zzm.zzc(zzum.zza()));
        } else if (!zzum.zza().equals(zzud.COMPRESSED)) {
            throw new GeneralSecurityException("For CURVE25519 EcPointFormat must be compressed");
        }
        return zzjr.zzg();
    }
}
