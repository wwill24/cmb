package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcq  reason: invalid package */
public final class zzcq {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = Logger.getLogger(zzcq.class.getName());
    private static final AtomicReference zzc = new AtomicReference(new zzbt());
    private static final ConcurrentMap zzd = new ConcurrentHashMap();
    private static final ConcurrentMap zze = new ConcurrentHashMap();
    private static final ConcurrentMap zzf = new ConcurrentHashMap();
    private static final ConcurrentMap zzg = new ConcurrentHashMap();

    private zzcq() {
    }

    @Deprecated
    static zzbo zza(String str) throws GeneralSecurityException {
        return ((zzbt) zzc.get()).zzb(str);
    }

    public static synchronized zzwi zzb(zzwn zzwn) throws GeneralSecurityException {
        zzwi zza2;
        synchronized (zzcq.class) {
            zzbo zzb2 = ((zzbt) zzc.get()).zzb(zzwn.zzg());
            if (((Boolean) zze.get(zzwn.zzg())).booleanValue()) {
                zza2 = zzb2.zza(zzwn.zzf());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzwn.zzg())));
            }
        }
        return zza2;
    }

    public static Class zzc(Class cls) {
        try {
            return zznq.zza().zzb(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static Object zzd(zzwi zzwi, Class cls) throws GeneralSecurityException {
        return zze(zzwi.zzf(), zzwi.zze(), cls);
    }

    public static Object zze(String str, zzajf zzajf, Class cls) throws GeneralSecurityException {
        return ((zzbt) zzc.get()).zza(str, cls).zzb(zzajf);
    }

    public static synchronized void zzf(zzon zzon, zzng zzng, boolean z10) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            AtomicReference atomicReference = zzc;
            zzbt zzbt = new zzbt((zzbt) atomicReference.get());
            zzbt.zzc(zzon, zzng);
            Map zzc2 = zzon.zza().zzc();
            String zzd2 = zzon.zzd();
            zzi(zzd2, zzc2, true);
            String zzd3 = zzng.zzd();
            zzi(zzd3, Collections.emptyMap(), false);
            if (!((zzbt) atomicReference.get()).zze(zzd2)) {
                zzd.put(zzd2, new zzcp(zzon));
                zzj(zzon.zza().zzc());
            }
            ConcurrentMap concurrentMap = zze;
            concurrentMap.put(zzd2, Boolean.TRUE);
            concurrentMap.put(zzd3, Boolean.FALSE);
            atomicReference.set(zzbt);
        }
    }

    public static synchronized void zzg(zzng zzng, boolean z10) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            AtomicReference atomicReference = zzc;
            zzbt zzbt = new zzbt((zzbt) atomicReference.get());
            zzbt.zzd(zzng);
            Map zzc2 = zzng.zza().zzc();
            String zzd2 = zzng.zzd();
            zzi(zzd2, zzc2, true);
            if (!((zzbt) atomicReference.get()).zze(zzd2)) {
                zzd.put(zzd2, new zzcp(zzng));
                zzj(zzng.zza().zzc());
            }
            zze.put(zzd2, Boolean.TRUE);
            atomicReference.set(zzbt);
        }
    }

    public static synchronized void zzh(zzcm zzcm) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            zznq.zza().zzf(zzcm);
        }
    }

    private static synchronized void zzi(String str, Map map, boolean z10) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            if (z10) {
                ConcurrentMap concurrentMap = zze;
                if (concurrentMap.containsKey(str)) {
                    if (!((Boolean) concurrentMap.get(str)).booleanValue()) {
                        throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
                    }
                }
                if (((zzbt) zzc.get()).zze(str)) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!zzg.containsKey(entry.getKey())) {
                            throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                        }
                    }
                } else {
                    for (Map.Entry entry2 : map.entrySet()) {
                        if (zzg.containsKey(entry2.getKey())) {
                            throw new GeneralSecurityException("Attempted overwrite of a registered key template ".concat(String.valueOf((String) entry2.getKey())));
                        }
                    }
                }
            }
        }
    }

    private static void zzj(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zzg.put((String) entry.getKey(), (zzce) entry.getValue());
        }
    }
}
