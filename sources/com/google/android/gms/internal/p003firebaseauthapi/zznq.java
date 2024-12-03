package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznq  reason: invalid package */
public final class zznq {
    private static final zznq zza = new zznq();
    private final AtomicReference zzb = new AtomicReference(new zzom(new zzoi((zzoh) null), (zzol) null));

    zznq() {
    }

    public static zznq zza() {
        return zza;
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        return ((zzom) this.zzb.get()).zza(cls);
    }

    public final Object zzc(zzbn zzbn, Class cls) throws GeneralSecurityException {
        return ((zzom) this.zzb.get()).zzb(zzbn, cls);
    }

    public final Object zzd(zzcl zzcl, Class cls) throws GeneralSecurityException {
        return ((zzom) this.zzb.get()).zzc(zzcl, cls);
    }

    public final synchronized void zze(zzof zzof) throws GeneralSecurityException {
        zzoi zzoi = new zzoi((zzom) this.zzb.get(), (zzoh) null);
        zzoi.zza(zzof);
        this.zzb.set(new zzom(zzoi, (zzol) null));
    }

    public final synchronized void zzf(zzcm zzcm) throws GeneralSecurityException {
        zzoi zzoi = new zzoi((zzom) this.zzb.get(), (zzoh) null);
        zzoi.zzb(zzcm);
        this.zzb.set(new zzom(zzoi, (zzol) null));
    }
}
