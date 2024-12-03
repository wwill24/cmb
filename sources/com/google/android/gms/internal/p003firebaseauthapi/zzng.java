package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzng  reason: invalid package */
public abstract class zzng {
    private final Class zza;
    private final Map zzb;
    private final Class zzc;

    @SafeVarargs
    protected zzng(Class cls, zzog... zzogArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        int i10 = 0;
        while (i10 <= 0) {
            zzog zzog = zzogArr[i10];
            if (!hashMap.containsKey(zzog.zzb())) {
                hashMap.put(zzog.zzb(), zzog);
                i10++;
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(zzog.zzb().getCanonicalName())));
            }
        }
        this.zzc = zzogArr[0].zzb();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public zznf zza() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract zzwh zzb();

    public abstract zzalp zzc(zzajf zzajf) throws zzaks;

    public abstract String zzd();

    public abstract void zze(zzalp zzalp) throws GeneralSecurityException;

    public int zzf() {
        return 1;
    }

    public final Class zzi() {
        return this.zzc;
    }

    public final Class zzj() {
        return this.zza;
    }

    public final Object zzk(zzalp zzalp, Class cls) throws GeneralSecurityException {
        zzog zzog = (zzog) this.zzb.get(cls);
        if (zzog != null) {
            return zzog.zza(zzalp);
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalArgumentException("Requested primitive class " + canonicalName + " not supported.");
    }

    public final Set zzl() {
        return this.zzb.keySet();
    }
}
