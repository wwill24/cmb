package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpa  reason: invalid package */
public final class zzpa {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    /* synthetic */ zzpa(zzou zzou, zzoz zzoz) {
        this.zza = new HashMap(zzou.zza);
        this.zzb = new HashMap(zzou.zzb);
        this.zzc = new HashMap(zzou.zzc);
        this.zzd = new HashMap(zzou.zzd);
    }

    public final zzbn zza(zzot zzot, zzcr zzcr) throws GeneralSecurityException {
        zzow zzow = new zzow(zzot.getClass(), zzot.zzd(), (zzov) null);
        if (this.zzb.containsKey(zzow)) {
            return ((zzna) this.zzb.get(zzow)).zza(zzot, zzcr);
        }
        String obj = zzow.toString();
        throw new GeneralSecurityException("No Key Parser for requested key type " + obj + " available");
    }

    public final zzce zzb(zzot zzot) throws GeneralSecurityException {
        zzow zzow = new zzow(zzot.getClass(), zzot.zzd(), (zzov) null);
        if (this.zzd.containsKey(zzow)) {
            return ((zznx) this.zzd.get(zzow)).zza(zzot);
        }
        String obj = zzow.toString();
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + obj + " available");
    }

    public final zzot zzc(zzce zzce, Class cls) throws GeneralSecurityException {
        zzoy zzoy = new zzoy(zzce.getClass(), cls, (zzox) null);
        if (this.zzc.containsKey(zzoy)) {
            return ((zzob) this.zzc.get(zzoy)).zza(zzce);
        }
        String obj = zzoy.toString();
        throw new GeneralSecurityException("No Key Format serializer for " + obj + " available");
    }

    public final boolean zzh(zzot zzot) {
        return this.zzb.containsKey(new zzow(zzot.getClass(), zzot.zzd(), (zzov) null));
    }

    public final boolean zzi(zzot zzot) {
        return this.zzd.containsKey(new zzow(zzot.getClass(), zzot.zzd(), (zzov) null));
    }
}
