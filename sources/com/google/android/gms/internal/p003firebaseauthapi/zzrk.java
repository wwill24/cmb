package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrk  reason: invalid package */
public final class zzrk {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzmu zzc;
    private static final zzmu zzd;
    private static final zzob zze;
    private static final zznx zzf;
    private static final zzne zzg;
    private static final zzna zzh;

    static {
        Class<zzoo> cls = zzoo.class;
        Class<zzop> cls2 = zzop.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzb2;
        zzms zza2 = zzmu.zza();
        zza2.zza(zzxo.RAW, zzqn.zzd);
        zza2.zza(zzxo.TINK, zzqn.zza);
        zza2.zza(zzxo.LEGACY, zzqn.zzc);
        zza2.zza(zzxo.CRUNCHY, zzqn.zzb);
        zzc = zza2.zzb();
        zzms zza3 = zzmu.zza();
        zza3.zza(zzvc.SHA1, zzqm.zza);
        zza3.zza(zzvc.SHA224, zzqm.zzb);
        zza3.zza(zzvc.SHA256, zzqm.zzc);
        zza3.zza(zzvc.SHA384, zzqm.zzd);
        zza3.zza(zzvc.SHA512, zzqm.zze);
        zzd = zza3.zzb();
        zze = zzob.zzb(zzrg.zza, zzqp.class, cls2);
        zzf = zznx.zzb(zzrh.zza, zzb2, cls2);
        zzg = zzne.zza(zzri.zza, zzqe.class, cls);
        zzh = zzna.zzb(zzrj.zza, zzb2, cls);
    }

    public static /* synthetic */ zzop zza(zzqp zzqp) {
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzvh zzc2 = zzvi.zzc();
        zzvk zzc3 = zzvl.zzc();
        zzc3.zzb(zzqp.zzb());
        zzc3.zza((zzvc) zzd.zzb(zzqp.zzf()));
        zzc2.zzb((zzvl) zzc3.zzi());
        zzc2.zza(zzqp.zzc());
        zza2.zzc(((zzvi) zzc2.zzi()).zzo());
        zza2.zza((zzxo) zzc.zzb(zzqp.zzg()));
        return zzop.zzb((zzwn) zza2.zzi());
    }

    public static /* synthetic */ zzqe zzb(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzvf zze2 = zzvf.zze(zzoo.zze(), zzajx.zza());
                if (zze2.zza() == 0) {
                    zzql zze3 = zzqp.zze();
                    zze3.zzb(zze2.zzg().zzd());
                    zze3.zzc(zze2.zzf().zza());
                    zze3.zza((zzqm) zzd.zzc(zze2.zzf().zzb()));
                    zze3.zzd((zzqn) zzc.zzc(zzoo.zzc()));
                    zzqp zze4 = zze3.zze();
                    zzqc zza2 = zzqe.zza();
                    zza2.zzc(zze4);
                    zza2.zzb(zzzq.zzb(zze2.zzg().zzq(), zzcr));
                    zza2.zza(zzoo.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzqp zzc(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzvi zzf2 = zzvi.zzf(zzop.zzc().zzf(), zzajx.zza());
                if (zzf2.zzb() == 0) {
                    zzql zze2 = zzqp.zze();
                    zze2.zzb(zzf2.zza());
                    zze2.zzc(zzf2.zzg().zza());
                    zze2.zza((zzqm) zzd.zzc(zzf2.zzg().zzb()));
                    zze2.zzd((zzqn) zzc.zzc(zzop.zzc().zze()));
                    return zze2.zze();
                }
                int zzb2 = zzf2.zzb();
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzb2);
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static void zzd(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zze);
        zznt.zzg(zzf);
        zznt.zzf(zzg);
        zznt.zze(zzh);
    }
}
