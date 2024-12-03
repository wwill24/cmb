package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjb  reason: invalid package */
final class zzjb {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzob zzc;
    private static final zznx zzd;
    private static final zzne zze;
    private static final zzna zzf;
    private static final Map zzg;
    private static final Map zzh;

    static {
        Class<zzoo> cls = zzoo.class;
        Class<zzop> cls2 = zzop.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zzb = zzb2;
        zzc = zzob.zzb(zzix.zza, zziw.class, cls2);
        zzd = zznx.zzb(zziy.zza, zzb2, cls2);
        zze = zzne.zza(zziz.zza, zzio.class, cls);
        zzf = zzna.zzb(zzja.zza, zzb2, cls);
        HashMap hashMap = new HashMap();
        zziu zziu = zziu.zzc;
        zzxo zzxo = zzxo.RAW;
        hashMap.put(zziu, zzxo);
        zziu zziu2 = zziu.zza;
        zzxo zzxo2 = zzxo.TINK;
        hashMap.put(zziu2, zzxo2);
        zziu zziu3 = zziu.zzb;
        zzxo zzxo3 = zzxo.CRUNCHY;
        hashMap.put(zziu3, zzxo3);
        zzg = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(zzxo.class);
        enumMap.put(zzxo, zziu);
        enumMap.put(zzxo2, zziu2);
        enumMap.put(zzxo3, zziu3);
        enumMap.put(zzxo.LEGACY, zziu3);
        zzh = Collections.unmodifiableMap(enumMap);
    }

    public static /* synthetic */ zzio zza(zzoo zzoo, zzcr zzcr) {
        if (zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzts zzd2 = zzts.zzd(zzoo.zze(), zzajx.zza());
                if (zzd2.zza() == 0) {
                    zzit zzit = new zzit((zzis) null);
                    zzit.zza(zzd2.zze().zzd());
                    zzit.zzb(zze(zzoo.zzc()));
                    zziw zzc2 = zzit.zzc();
                    zzim zzim = new zzim((zzil) null);
                    zzim.zzc(zzc2);
                    zzim.zzb(zzzq.zzb(zzd2.zze().zzq(), zzcr));
                    zzim.zza(zzoo.zzf());
                    return zzim.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks unused) {
                throw new GeneralSecurityException("Parsing AesSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
        }
    }

    public static /* synthetic */ zziw zzb(zzop zzop) {
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zztv zze2 = zztv.zze(zzop.zzc().zzf(), zzajx.zza());
                if (zze2.zzb() == 0) {
                    zzit zzit = new zzit((zzis) null);
                    zzit.zza(zze2.zza());
                    zzit.zzb(zze(zzop.zzc().zze()));
                    return zzit.zzc();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }

    public static /* synthetic */ zzop zzc(zziw zziw) {
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zztu zzc2 = zztv.zzc();
        zzc2.zza(zziw.zzb());
        zza2.zzc(((zztv) zzc2.zzi()).zzo());
        zziu zzd2 = zziw.zzd();
        Map map = zzg;
        if (map.containsKey(zzd2)) {
            zza2.zza((zzxo) map.get(zzd2));
            return zzop.zzb((zzwn) zza2.zzi());
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzd2)));
    }

    public static void zzd(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzc);
        zznt.zzg(zzd);
        zznt.zzf(zze);
        zznt.zze(zzf);
    }

    private static zziu zze(zzxo zzxo) throws GeneralSecurityException {
        Map map = zzh;
        if (map.containsKey(zzxo)) {
            return (zziu) map.get(zzxo);
        }
        int zza2 = zzxo.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }
}
