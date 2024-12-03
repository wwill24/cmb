package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoi  reason: invalid package */
public final class zzoi {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    private zzoi() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzoi zza(zzof zzof) throws GeneralSecurityException {
        zzok zzok = new zzok(zzof.zzc(), zzof.zzd(), (zzoj) null);
        if (this.zza.containsKey(zzok)) {
            zzof zzof2 = (zzof) this.zza.get(zzok);
            if (!zzof2.equals(zzof) || !zzof.equals(zzof2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzok.toString()));
            }
        } else {
            this.zza.put(zzok, zzof);
        }
        return this;
    }

    public final zzoi zzb(zzcm zzcm) throws GeneralSecurityException {
        Map map = this.zzb;
        Class zzb2 = zzcm.zzb();
        if (map.containsKey(zzb2)) {
            zzcm zzcm2 = (zzcm) this.zzb.get(zzb2);
            if (!zzcm2.equals(zzcm) || !zzcm.equals(zzcm2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb2.toString()));
            }
        } else {
            this.zzb.put(zzb2, zzcm);
        }
        return this;
    }

    /* synthetic */ zzoi(zzoh zzoh) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    /* synthetic */ zzoi(zzom zzom, zzoh zzoh) {
        this.zza = new HashMap(zzom.zza);
        this.zzb = new HashMap(zzom.zzb);
    }
}
