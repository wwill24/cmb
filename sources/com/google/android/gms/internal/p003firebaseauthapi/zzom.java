package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzom  reason: invalid package */
public final class zzom {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    /* synthetic */ zzom(zzoi zzoi, zzol zzol) {
        this.zza = new HashMap(zzoi.zza);
        this.zzb = new HashMap(zzoi.zzb);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzcm) this.zzb.get(cls)).zza();
        }
        String obj = cls.toString();
        throw new GeneralSecurityException("No input primitive class for " + obj + " available");
    }

    public final Object zzb(zzbn zzbn, Class cls) throws GeneralSecurityException {
        zzok zzok = new zzok(zzbn.getClass(), cls, (zzoj) null);
        if (this.zza.containsKey(zzok)) {
            return ((zzof) this.zza.get(zzok)).zza(zzbn);
        }
        String obj = zzok.toString();
        throw new GeneralSecurityException("No PrimitiveConstructor for " + obj + " available");
    }

    public final Object zzc(zzcl zzcl, Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzcm zzcm = (zzcm) this.zzb.get(cls);
            if (zzcl.zzc().equals(zzcm.zza()) && zzcm.zza().equals(zzcl.zzc())) {
                return zzcm.zzc(zzcl);
            }
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
    }
}
